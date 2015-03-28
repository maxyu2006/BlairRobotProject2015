package org.usfirst.frc.team449.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team449.robot.RobotMap;

/**
 * The arms are attached to the elevator 
 */
public class Arms extends Subsystem {
	private final DoubleSolenoid armController; //one solenoid connected to both arms
	
	//limit switches
	private final DigitalInput leftArmLimit;
	private final DigitalInput rightArmLimit;
	
	//
	private boolean armState;
	public static final boolean ARM_OPEN = true;
	public static final boolean ARM_CLOSED = false;
	
	public Arms(RobotMap config){
		System.out.println("Arm init started");
		
		leftArmLimit 	= new DigitalInput(config.ELEVATOR_LEFT_LIMIT);
		rightArmLimit 	= new DigitalInput(config.ELEVATOR_RIGHT_LIMIT);
		
		System.out.println("Left and right limits initialized");
		
		armController  = new DoubleSolenoid(config.ELEVATOR_ARM_SOLENOID_FWD,config.ELEVATOR_ARM_SOLENOID_REV);
		
		System.out.println("Solenoids Initialized");

		
		armState = ARM_CLOSED;
		armController.set(Value.kForward);
		
		System.out.println("Arms init finished");
	}
	
	 /**
	  *Toggles the arm state
	  *if the arms are closed they open, if they are open they close 
	  */
    public void toggleArms(){
    	
    	if(armState == ARM_OPEN)
    		armController.set(Value.kForward);
    	else
    		armController.set(Value.kReverse);
    	
    	
    	this.armState = !armState;
    }
    
	
	/**
     * Opens the arms on the grabber
     */
    public void openArms(){
    	armController.set(Value.kReverse);
    	armState = ARM_OPEN;
    }
    
    /**
     * Closes the arms on the grabber
     */
    public void closeArms(){
		armController.set(Value.kForward);
		armState = ARM_CLOSED;
    }
    
    /**
     * Returns true if arms are open, false otherwise.
     * @return isArmOpen - whether the arms are open
     */
    public boolean getArmState(){
    	return armState;
    }
    
    /**
     * Returns whether the limit switch on the left arm is being pressed
     * @return see description
     */
    public boolean isTouchingLeftArm() {
    	return leftArmLimit.get();
    }
    
    /**
     * Returns whether the limit switch on the right arm is being pressed
     * @return see description
     */
    public boolean isTouchingRightArm() {
    	return rightArmLimit.get();
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

