package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Intake subsystem.
 */
public class Intake extends Subsystem {
    
	// Intake member variables
	private final DigitalInput leftLimSwitch;
	private final DigitalInput rightLimSwitch;
	
    private final Solenoid intakeLeftSol;
    private final Solenoid intakeRightSol;
    
    private final Victor leftArmMotor;
    private final Victor rightArmMotor;
    
    private boolean isArmOpen;
    private boolean isMotorOn;
    
	// Intake constructor 
	public Intake(RobotMap config) {
    	leftLimSwitch 	= new DigitalInput(config.INTAKE_LEFT_LIMIT);
    	rightLimSwitch 	= new DigitalInput(config.INTAKE_RIGHT_LIMIT);
    	
    	leftArmMotor 	= new Victor(config.INTAKE_LEFT_MOTOR);
    	rightArmMotor 	= new Victor(config.INTAKE_RIGHT_MOTOR);
    	
    	intakeLeftSol   = new Solenoid(config.ELEVATOR_LEFT_SOLENOIDS[0], config.ELEVATOR_LEFT_SOLENOIDS[1]);
    	intakeRightSol  = new Solenoid(config.ELEVATOR_RIGHT_SOLENOIDS[0], config.ELEVATOR_RIGHT_SOLENOIDS[1]);
    	
    	isArmOpen = true;
    	isMotorOn = false;
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
		isMotorOn = !isMotorOn;
	}
	
	/**
	 * Toggles the direction of the motors.
	 */
	public void toggleMotorDir() {
		leftArmMotor.set(-leftArmMotor.get());
		rightArmMotor.set(-rightArmMotor.get());
	}
	
	/**
	 * Toggles the open/closed state of the arms.
	 */
	public void toggleArms() {
		isArmOpen = !isArmOpen;
	}
	
	/**
	 * Returns true if the arms are open, false otherwise.
	 * @return isArmOpen - A boolean that is true if the arms are open, false otherwise.
	 */
	public boolean isArmOpen() {
		
		return isArmOpen;
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

    public void initDefaultCommand() {	
    }
}

