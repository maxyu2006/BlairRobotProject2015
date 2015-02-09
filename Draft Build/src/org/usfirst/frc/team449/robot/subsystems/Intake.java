package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

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
	private final DigitalInput rightLimSwitch;
	
    private final AnalogInput ultrasonic;
	private final double ultraScale;
	
    private final DoubleSolenoid intakeLeftSol;
    private final DoubleSolenoid intakeRightSol;
    
    private final VictorSP leftArmMotor;
    private final VictorSP rightArmMotor;
    
    private boolean areArmsOpen;
    private boolean isMotorOn;
    private boolean isMotorForward;
    
    private double motorSpeed;
    
    /**
     * 
     * @param config
     */
	public Intake(RobotMap config) {
    	leftLimSwitch 	= new DigitalInput(config.INTAKE_LEFT_LIMIT);
    	rightLimSwitch 	= new DigitalInput(config.INTAKE_RIGHT_LIMIT);
    	
    	ultrasonic = new AnalogInput(config.INTAKE_ULTRASONIC);
    	
    	leftArmMotor 	= new VictorSP(config.INTAKE_LEFT_MOTOR);
    	rightArmMotor 	= new VictorSP(config.INTAKE_RIGHT_MOTOR);
    	
    	intakeLeftSol  = new DoubleSolenoid(config.INTAKE_LSOLENOID_FORWARD, config.INTAKE_LSOLENOID_REVERSE);
    	intakeRightSol = new DoubleSolenoid(config.INTAKE_RSOLENOID_FORWARD, config.INTAKE_RSOLENOID_REVERSE);
    	
    	areArmsOpen = true;
    	isMotorOn = false;
    	isMotorForward = true;
    	
    	ultraScale = 1; //TODO: actually add the correct calibration
    	//motorSpeed = config.INTAKE_MOTOR_SPEED;
    	this.openArms();
	}
	
	/**
	 * Set the motor state 
	 */
	public void setMotorState(boolean newState) {
		isMotorOn = newState;
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
		this.rightArmMotor.set(throttle);
	}
	
	/**
	 * Opens the intake arms.
	 */
	public void openArms(){
		intakeLeftSol.set(Value.kReverse);
		intakeRightSol.set(Value.kReverse);
		
		areArmsOpen = true;
	}
	
	/**
	 * Closes the intake arms.
	 */
	public void closeArms(){
		intakeLeftSol.set(Value.kForward);
		intakeRightSol.set(Value.kForward);
		
		areArmsOpen = false;
	}
	
	/**
	 * Returns true if the arms are open, false otherwise.
	 * @return isArmOpen - A boolean that is true if the arms are open, false otherwise.
	 */
	public boolean areArmsOpen() {
		
		return areArmsOpen;
	}

	/**
	 * @return left limit switch's state
	 */
	public boolean getLeftSwitchState() {
		return leftLimSwitch.get();
	}

	/**
	 * @return right limit switch's state
	 */
	public boolean getRightSwitchState() {
		return rightLimSwitch.get();
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
    }
}

