package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRobot extends Command {

    public DriveRobot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//pushing forward on the stick gives -1 so it is negated
    	Robot.drive.setThrottle(-Robot.OI.getDriveAxis1(), -Robot.OI.getDriveAxis2());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.setThrottle(-Robot.OI.getDriveAxis1(), -Robot.OI.getDriveAxis2());
    }
}