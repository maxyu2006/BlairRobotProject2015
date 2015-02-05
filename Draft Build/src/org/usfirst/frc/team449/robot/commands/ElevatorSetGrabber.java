package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the grabber to a specified state (either open or closed) based on the parameter fed into the constructor.
 * Note: assumes that the grabber works. If the Solenoid on the grabber accepts data but doesn't physically do
 * anything, the command will still exit since isFinished is set to always return true.
 * @author eyob-- 2/1/15
 */
public class ElevatorSetGrabber extends Command {
	public int armState; 
	public static final int OPEN = 0;
	public static final int CLOSED = 1;
	public static final int TOGGLE = 2;
	
	
    public ElevatorSetGrabber(int setOpen) {
        requires(Robot.grabber);
        this.armState = setOpen;
    }

    protected void initialize() {
    	if (armState == OPEN)
    		Robot.grabber.openArms();
    	else if(armState == CLOSED)
    		Robot.grabber.closeArms();
    	else
    		Robot.grabber.toggleArms();
    }

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
