package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggles the grabber on the elevator carriage.
 * If the arms are open, they get closed. Otherwise, they are opened.
 * @author Eyob Tsegaye
 */
public class ToggleGrabber extends Command {

    public ToggleGrabber() {
        requires(Robot.elevator);
    }

    protected void initialize() {
    	if (Robot.elevator.getArmState())
    		Robot.elevator.closeArms();
    	else
    		Robot.elevator.openArms();
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
