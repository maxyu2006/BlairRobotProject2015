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
	private DigitalInput leftLimSwitch, rightLimSwitch;
    private Solenoid intakeLeftSol, intakeRightSol;
    private Victor leftArmMotor, rightArmMotor;
    private int armState;
    
    // Intake arm states
    public static final int OPEN = 0;
    public static final int CLOSED = 1;
    
	// Intake constructor 
	public Intake(){
    	leftLimSwitch = new DigitalInput(RobotMap.intakeLeftLmChnl);
    	rightLimSwitch = new DigitalInput(RobotMap.intakeRightLmChnl);
    	leftArmMotor = new Victor(RobotMap.intakeMotorChnls[0]);
    	rightArmMotor = new Victor(RobotMap.intakeMotorChnls[1]);
    	armState = CLOSED;
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

