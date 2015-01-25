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
	
	public void toggleMotor(){
		
	}
	
	public void toggleMotorDir(){
		
	}
	
	public void toggleArms(){

	}
	
	public boolean isArmOpen(){
		
		return armState == OPEN;
	}
	
	public boolean getSwitchState(){
		
		//default return statement
		return false;
	}

}

