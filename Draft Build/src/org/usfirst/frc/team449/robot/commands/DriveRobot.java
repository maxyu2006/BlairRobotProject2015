package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRobot extends Command {

    public DriveRobot() {
    	requires(Robot.drive);
    	System.out.println("Drive Robot bueno");
    }

    protected void initialize() {
    }

    protected void execute() {
    	double leftThrottle =0;
    	double rightThrottle = 0;
    	
    	leftThrottle = Robot.OI.getDriveAxisLeft();
    	rightThrottle = Robot.OI.getDriveAxisRight();
    	
    	if(Robot.OI.isDriveStraightMode())
    	{
    		leftThrottle = rightThrottle;
    	}
    	//pushing forward on the stick gives -1 so it is negated
    	Robot.drive.setThrottle(leftThrottle, rightThrottle);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	Robot.drive.setThrottle(Robot.OI.getDriveAxisLeft(), Robot.OI.getDriveAxisRight());
    }
}