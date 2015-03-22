package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.RobotMap;
import org.usfirst.frc.team449.robot.commands.AlignerSetPWMVoltage;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Aligner subsystem.
 */
public class Aligner extends Subsystem {
    
	// Aligner member variables
	private final DigitalInput alignerLimSwitch;
	
    private final AnalogInput ultrasonic;
	private final double ultraScale;
	private final VictorSP ledPWM;
	
    private final DoubleSolenoid alingerSol;
    
    private boolean isOpen;
    
    /**
     * 
     * @param config
     */
	public Aligner(RobotMap config) {
		System.out.println("Aligner init started");
		alignerLimSwitch 	= new DigitalInput(config.ALIGNER_LEFT_LIMIT);
    	ultrasonic = new AnalogInput(config.ALIGNER_ULTRASONIC);
    	
    	this.ledPWM = new VictorSP(Robot.robotMap.ALIGNER_LED_PORT);
    	
    	alingerSol  = new DoubleSolenoid(config.ALIGNER_LSOLENOID_FORWARD, config.ALIGNER_LSOLENOID_REVERSE);
    	
    	isOpen = true;
    	
    	ultraScale = 1; //TODO: actually add the correct calibration
    	//motorSpeed = config.ALIGNER_MOTOR_SPEED;
    	this.openArms();
    	System.out.println("Aligner init finished");
	}
	
	
	/**
	 * sets the left motor output
	 * @param throttle
	 */
	public void setLED(double throttle){
		this.ledPWM.set(throttle);
	}
	
	public void openArms() {
		this.alingerSol.set(Value.kForward);
		this.isOpen = true;

	}
	
	public void closeArms() {
		this.alingerSol.set(Value.kForward);
		this.isOpen = false;
	}
		
	public boolean isOpen(){
		return this.isOpen;
	}
	
	/**
	 * @return the state of the limit switch on the front of the robot
	 */
	public boolean getSwitchState() {
		return alignerLimSwitch.get();
	}

	/***
	 * returns the raw voltage from the ultrasonic sensor
	 * @return
	 */
	public double getUltraRawVoltage(){
		return this.ultrasonic.getVoltage();
	}
	
	/**
	 * gets the distance in inches of a target from the ultrasonic sensor
	 * @return
	 */
	public double getUltraDistance(){
		return this.ultrasonic.getVoltage()*ultraScale;
	}
	
    public void initDefaultCommand() {	
    	this.setDefaultCommand(new AlignerSetPWMVoltage());
    }
}

