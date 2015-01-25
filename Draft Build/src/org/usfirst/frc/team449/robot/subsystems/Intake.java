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
	private final DigitalInput leftLimSwitch;
	private final DigitalInput rightLimSwitch;
	
    private final DoubleSolenoid intakeLeftSol;
    private final DoubleSolenoid intakeRightSol;
    
    private final Victor leftArmMotor;
    private final Victor rightArmMotor;
    
    private boolean isArmOpen;
    
	// Intake constructor 
	public Intake(RobotMap config){
    	leftLimSwitch 	= new DigitalInput(config.INTAKE_LEFT_LIMIT);
    	rightLimSwitch 	= new DigitalInput(config.INTAKE_RIGHT_LIMIT);
    	
    	leftArmMotor 	= new Victor(config.INTAKE_LEFT_MOTOR);
    	rightArmMotor 	= new Victor(config.INTAKE_RIGHT_MOTOR);
    	
    	intakeLeftSol  = new DoubleSolenoid(config.ELEVATOR_LEFT_SOLENOIDS[0], config.ELEVATOR_LEFT_SOLENOIDS[1]);
    	intakeRightSol = new DoubleSolenoid(config.ELEVATOR_RIGHT_SOLENOIDS[0], config.ELEVATOR_RIGHT_SOLENOIDS[1]);
    	
    	isArmOpen = true;
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
		if(isArmOpen){
    		intakeLeftSol.set(Value.kReverse);
    		intakeRightSol.set(Value.kReverse);
    	}
    	else{
    		intakeLeftSol.set(Value.kForward);
    		intakeRightSol.set(Value.kForward);
    	}
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

