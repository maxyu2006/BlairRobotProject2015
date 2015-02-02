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

	private boolean setOpen;
	
    public ElevatorSetGrabber(boolean setOpen) {
        requires(Robot.elevator);
        this.setOpen = setOpen;
    }

    protected void initialize() {
    	if (setOpen)
    		Robot.elevator.openArms();
    	else
    		Robot.elevator.closeArms();
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
