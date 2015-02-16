package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the grabber to a specified state (either open or closed) based on the parameter fed into the constructor.
 * Note: assumes that the grabber works. If the Solenoid on the grabber accepts data but doesn't physically do
 * anything, the command will still exit since isFinished is set to always return true.
 * @author eyob-- 2/1/15
 */
public class ArmSetGrabber extends Command {
	private int armState; 
	public static final int OPEN = 0;
	public static final int CLOSE = 1;
	public static final int TOGGLE = 2;
	
	
    public ArmSetGrabber(int setOpen) {
        requires(Robot.elevatorArm);
        this.armState = setOpen;
        System.out.println("initialized setGrabberCommand");
    }

    protected void initialize() {
    	switch(this.armState)
    	{
    	case OPEN:
    		Robot.elevatorArm.openArms();
    		break;
    	case CLOSE:
    		Robot.elevatorArm.closeArms();
    		break;
    	case TOGGLE:
    		Robot.elevatorArm.toggleArms();
    		break;
    	default:
    		System.out.println("You done fucked up");
    	}//end switch
    }//end initialize

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
