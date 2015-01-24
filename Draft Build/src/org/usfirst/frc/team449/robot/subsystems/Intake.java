package org.usfirst.frc.team449.robot.subsystems;

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
    
	// Intake constructor 
	public Intake(){
		
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
	
	public void setArms(boolean in){
		
	}
	
	public boolean isArmOpen(){
		
		//default return statement
		return false;
	}
	
	public boolean getSwitchState(){
		
		//default return statement
		return false;
	}

}

