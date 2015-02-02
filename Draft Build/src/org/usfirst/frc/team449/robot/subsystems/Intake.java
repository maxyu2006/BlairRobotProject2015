package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Intake subsystem.
 */
public class Intake extends Subsystem {
    
	// Intake member variables
    private final DoubleSolenoid intakeLeftSol;
    private final DoubleSolenoid intakeRightSol;
    
    private final Victor leftArmMotor;
    private final Victor rightArmMotor;
    
    private boolean areArmsOpen;
    private boolean isMotorOn;
    private boolean isMotorForward;
    
    private double motorSpeed;
    
    /**
     * 
     * @param config
     */
	public Intake(RobotMap config) {    	
    	leftArmMotor 	= new Victor(config.INTAKE_LEFT_MOTOR);
    	rightArmMotor 	= new Victor(config.INTAKE_RIGHT_MOTOR);
    	
    	intakeLeftSol  = new DoubleSolenoid(config.INTAKE_LSOLENOID_FORWARD, config.INTAKE_LSOLENOID_REVERSE);
    	intakeRightSol = new DoubleSolenoid(config.INTAKE_RSOLENOID_FORWARD, config.INTAKE_RSOLENOID_REVERSE);
    	
    	areArmsOpen = true;
    	isMotorOn = false;
    	isMotorForward = true;
    	
    	//motorSpeed = config.INTAKE_MOTOR_SPEED;
	}
	
	/**
	 * Set the motor state 
	 */
	public void setMotorState(boolean newState) {
		isMotorOn = newState;
	}
	
	/**
	 * Toggles the on/off state of the motors.
	 */
	public void toggleMotor() {
		if(isMotorOn){
			leftArmMotor.set(0);
			rightArmMotor.set(0);
		}else{
			int times = 1;
			if(!isMotorForward) times = -1;
			leftArmMotor.set(motorSpeed * times);
			rightArmMotor.set(motorSpeed * times);
		}
		isMotorOn = !isMotorOn;
	}
	
	/**
	 * Toggles the direction of the motors.
	 */
	public void toggleMotorSpinDirection() {
		leftArmMotor.set(-leftArmMotor.get());
		rightArmMotor.set(-rightArmMotor.get());
		isMotorForward = !isMotorForward;
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

    public void initDefaultCommand() {	
    }
}

