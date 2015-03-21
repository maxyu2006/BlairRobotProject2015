package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToggleMode extends Command {

    public DriveToggleMode() {
    	System.out.println("Drive Toggle Started");
    	requires(Robot.drive);
    }

    protected void initialize() {
    	Robot.drive.setThrottle(Robot.oi.getDriveAxisLeft(), Robot.oi.getDriveAxisRight());
		Robot.drive.toggleControlMode();
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    	Robot.drive.setThrottle(Robot.oi.getDriveAxisLeft(), Robot.oi.getDriveAxisRight());
    }
}
