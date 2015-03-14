package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.RobotMap;
import org.usfirst.frc.team449.robot.commands.IntakeSetPWMVoltage;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Intake subsystem.
 */
public class Intake extends Subsystem {
    
	// Intake member variables
	private final DigitalInput intakeLimSwitch;
	
    private final AnalogInput ultrasonic;
	private final double ultraScale;
	private final VictorSP ledPWM;
	
    private final DoubleSolenoid intakeSol;
    
    private boolean isOpen;
    
    /**
     * 
     * @param config
     */
	public Intake(RobotMap config) {
		System.out.println("Intake init started");
		intakeLimSwitch 	= new DigitalInput(config.INTAKE_LEFT_LIMIT);
    	ultrasonic = new AnalogInput(config.INTAKE_ULTRASONIC);
    	
    	this.ledPWM = new VictorSP(Robot.robotMap.INTAKE_LED_PORT);
    	
    	intakeSol  = new DoubleSolenoid(config.INTAKE_LSOLENOID_FORWARD, config.INTAKE_LSOLENOID_REVERSE);
    	
    	isOpen = true;
    	
    	ultraScale = 1; //TODO: actually add the correct calibration
    	//motorSpeed = config.INTAKE_MOTOR_SPEED;
    	this.openArms();
    	System.out.println("Intake init finished");
	}
	
	
	/**
	 * sets the left motor output
	 * @param throttle
	 */
	public void setLED(double throttle){
		this.ledPWM.set(throttle);
	}
	
	public void openArms() {
		this.intakeSol.set(Value.kForward);
		this.isOpen = true;

	}
	
	public void closeArms() {
		this.intakeSol.set(Value.kForward);
		this.isOpen = false;
	}
		
	public boolean isOpen(){
		return this.isOpen;
	}
	
	/**
	 * @return left limit switch's state
	 */
	public boolean getSwitchState() {
		return intakeLimSwitch.get();
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
    	this.setDefaultCommand(new IntakeSetPWMVoltage());
    }
}

