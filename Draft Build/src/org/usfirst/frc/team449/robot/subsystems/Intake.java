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
    
	// Intake hardware fields
	private DigitalInput leftLimSwitch, rightLimSwitch;
    private Solenoid intakeLeftSol, intakeRightSol;
    private Victor leftArmMotor, rightArmMotor;
    
    // Intake conceptual fields
    private boolean isArmOpen;
    
	// Intake constructor 
	public Intake(RobotMap config){
    	leftLimSwitch = new DigitalInput(config.intakeLeftLmChnl);
    	rightLimSwitch = new DigitalInput(config.intakeRightLmChnl);
    	leftArmMotor = new Victor(config.intakeLeftMotor);
    	rightArmMotor = new Victor(config.intakeRightMotor);
    	isArmOpen = true;
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
		
		return isArmOpen;
	}
	
	public boolean getSwitchState(){
		
		//default return statement
		return false;
	}

}

