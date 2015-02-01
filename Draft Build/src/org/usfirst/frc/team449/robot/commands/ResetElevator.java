package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetElevator extends Command {
	
	private Timer t;

    public ResetElevator() {
        requires(Robot.elevator);
        t = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.releaseBrake();
    	Robot.elevator.disablePID();
    	Robot.elevator.setMotorManual(-0.15);
    	t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// stop if you hit the limit switch or it has taken longer than 2 seconds
        return Robot.elevator.isTouchingBottom() || t.get() > 2;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.activateBrake();
    	Robot.elevator.disablePID();
    	Robot.elevator.resetEncoder();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
