package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.OI;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Joystick;
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
    		Robot.drive.setThrottle(Robot.OI.getJoystickAxisY(Robot.OI.joystick1), Robot.OI.getJoystickAxisY(Robot.OI.joystick2));
    		
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
    }
}
