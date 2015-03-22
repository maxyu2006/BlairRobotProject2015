package org.usfirst.frc.team449.robot.commands.auto;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to make the robot drive at half-speed until the limit switch on the aligner is pressed
 * @author eyob-- 3/22/15
 */
public class DriveUntilContact extends Command {

    public DriveUntilContact() {
        requires(Robot.drive);
        requires(Robot.aligner);
    }

    protected void initialize() {
    	Robot.drive.setThrottle(0.5, 0.5);	// go at half speed
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return Robot.aligner.getSwitchState();	// go until you hit something (a tote)
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
