package org.usfirst.frc.team449.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team449.robot.RobotMap;

/**
 * The arms are attached to the elevator 
 */
public class Arms extends Subsystem {
	private final DoubleSolenoid armController; //one solenoid connected to both arms
	//
	private boolean armState;
	public static final boolean ARM_OPEN = true;
	public static final boolean ARM_CLOSED = false;
	
	public Arms(RobotMap config){

		armController  = new DoubleSolenoid(config.ELEVATOR_ARM_SOLENOID_FWD,config.ELEVATOR_ARM_SOLENOID_REV);
		armState = ARM_OPEN;
	}
	
	 /**
	  *Toggles the arm state
	  *if the arms are closed they open, if they are open they close 
	  */
    public void toggleArms(){
    	if(armState == ARM_OPEN){
    		armController.set(Value.kReverse);
    	}
    	else{
    		armController.set(Value.kForward);
    	}
    	armState=!armState;
    }
    
	
	/**
     * Opens the arms on the grabber
     */
    public void openArms(){
    	armController.set(Value.kForward);
    	armState = ARM_OPEN;
    }
    
    /**
     * Closes the arms on the grabber
     */
    public void closeArms(){
		armController.set(Value.kReverse);
		armState = ARM_CLOSED;
    }
    
    /**
     * Returns true if arms are open, false otherwise.
     * @return isArmOpen - whether the arms are open
     */
    public boolean getArmState(){
    	return armState;
    }
    
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

