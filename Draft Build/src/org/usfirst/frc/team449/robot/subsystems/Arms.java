package org.usfirst.frc.team449.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team449.robot.RobotMap;

/**
 *
 */
public class Arms extends Subsystem {
	private final DoubleSolenoid armController; //one solenoid connected to both arms
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private boolean isArmOpen;
	public Arms(RobotMap config){

		armController  = new DoubleSolenoid(config.ELEVATOR_ARM_SOLENOID_FWD,config.ELEVATOR_ARM_SOLENOID_REV);
		isArmOpen = true;
	}
	
	 /**
	  * 
	  */
    public void toggleArms(){
    	if(isArmOpen){
    		armController.set(Value.kReverse);
    	}
    	else{
    		armController.set(Value.kForward);
    	}
    	isArmOpen=!isArmOpen;
    }
    
	
	/**
     * Opens the arms on the grabber
     */
    public void openArms(){
    	armController.set(Value.kForward);
    	isArmOpen = true;
    }
    
    /**
     * Closes the arms on the grabber
     */
    public void closeArms(){
		armController.set(Value.kReverse);
		isArmOpen = false;
    }
    
    /**
     * Returns true if arms are open, false otherwise.
     * @return isArmOpen - whether the arms are open
     */
    public boolean getArmState(){
    	return isArmOpen;
    }
    
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

