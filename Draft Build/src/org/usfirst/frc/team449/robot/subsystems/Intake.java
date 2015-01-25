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
    
    private int armState;
    
    // Intake arm states
    public static final int ARM_OPEN = 0;
    public static final int ARM_CLOSED = 1;
    
	// Intake constructor 
	public Intake(RobotMap config){
    	leftLimSwitch 	= new DigitalInput(config.intakeLeftLmChnl);
    	rightLimSwitch 	= new DigitalInput(config.intakeRightLmChnl);
    	
    	leftArmMotor 	= new Victor(config.intakeMotorChnls[0]);
    	rightArmMotor 	= new Victor(config.intakeMotorChnls[1]);
    	armState = ARM_CLOSED;

	}
	
    public void initDefaultCommand() {
    	
    }
    
    // Is this meant to be a boolean? Is the boolean meant to confirm that the motor state was successfully changed?
	public boolean setMotorState(){
		
		//default return statement
		return false;
	}
	
	/**
	 * Toggles the on/off state of the motors.
	 */
	public void toggleMotor(){
		
	}
	
	/**
	 * Toggles the direction of the motors.
	 */
	public void toggleMotorDir(){
		
	}
	
	/**
	 * Toggles the open/closed state of the arms.
	 */
	public void toggleArms(){

	}
	
	/**
	 * Returns true if the arms are open, false otherwise.
	 * @return isArmOpen - A boolean that is true if the arms are open, false otherwise.
	 */
	public boolean isArmOpen(){
		
		return isArmOpen;
	}
	
	public boolean getSwitchState(){
		
		//default return statement
		return false;
	}

}

