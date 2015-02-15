package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;
import org.usfirst.frc.team449.robot.commands.IntakeRunMotors;

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
	private final DigitalInput leftLimSwitch;
	//private final DigitalInput rightLimSwitch;
	
    private final AnalogInput ultrasonic;
	private final double ultraScale;
	
    private final DoubleSolenoid intakeLeftSol;
    private final DoubleSolenoid intakeRightSol;
    
    private final VictorSP leftArmMotor;
//    private final VictorSP rightArmMotor;
    
    private boolean isLeftOpen;
    private boolean isRightOpen;
    
    /**
     * 
     * @param config
     */
	public Intake(RobotMap config) {
		System.out.println("Intake init started");
		leftLimSwitch 	= new DigitalInput(config.INTAKE_LEFT_LIMIT);
    	//rightLimSwitch 	= new DigitalInput(config.INTAKE_RIGHT_LIMIT);
    	ultrasonic = new AnalogInput(config.INTAKE_ULTRASONIC);
    	
    	leftArmMotor 	= new VictorSP(config.INTAKE_LEFT_MOTOR);
//    	rightArmMotor 	= new VictorSP(config.INTAKE_RIGHT_MOTOR);
    	
    	intakeLeftSol  = new DoubleSolenoid(config.INTAKE_LSOLENOID_FORWARD, config.INTAKE_LSOLENOID_REVERSE);
    	intakeRightSol = new DoubleSolenoid(config.INTAKE_RSOLENOID_FORWARD, config.INTAKE_RSOLENOID_REVERSE);
    	
    	isRightOpen = true;
    	isLeftOpen = true;
    	
    	ultraScale = 1; //TODO: actually add the correct calibration
    	//motorSpeed = config.INTAKE_MOTOR_SPEED;
    	this.openArms();
    	System.out.println("Intake init finished");
	}
	
	
	/**
	 * sets the left motor output
	 * @param throttle
	 */
	public void setLMotor(double throttle){
		this.leftArmMotor.set(throttle);
	}
	
	/**
	 * sets right motor output
	 * @param throttle
	 */
	public void setRMotor(double throttle){
//		this.rightArmMotor.set(throttle);
	}
	
	public void toggleArms() {
		if(this.isLeftOpen && this.isRightOpen) 
			this.closeArms();
		else if(!this.isLeftOpen && !this.isRightOpen)
			this.openArms();
		else
			System.out.println("How the fuck did you manage that?");
	}
	
	public void openArms() {
		this.openRight();
		this.openLeft();
	}
	
	public void closeArms() {
		this.closeRight();
		this.closeLeft();
	}
	
	private void openRight(){
		this.intakeRightSol.set(Value.kForward);
		this.isRightOpen = true;
	}
	
	private void openLeft(){
		this.intakeLeftSol.set(Value.kForward);
		this.isLeftOpen = true;
	}
	
	private void closeRight(){
		this.intakeRightSol.set(Value.kReverse);
		this.isRightOpen = false;
	}
	
	private void closeLeft(){
		this.intakeLeftSol.set(Value.kForward);
		this.isLeftOpen = false;
	}
	
	public boolean isLeftOpen(){
		return this.isLeftOpen;
	}
	
	public boolean isRightOpen(){
		return this.isRightOpen;
	}

	/**
	 * @return left limit switch's state
	 */
	public boolean getSwitchState() {
		return leftLimSwitch.get();
	}

	/**
	 * @return right limit switch's state
	 */
	//public boolean getRightSwitchState() {
	//	return rightLimSwitch.get();
	//}
	
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
    	this.setDefaultCommand(new IntakeRunMotors());
    }
}

