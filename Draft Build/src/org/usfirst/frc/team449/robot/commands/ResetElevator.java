package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetElevator extends Command {

	private double tolerance;
	
    public ResetElevator(RobotMap config) {
        requires(Robot.elevator);
        tolerance = config.ELEVATOR_PID_ACCEPTABILITY_RANGE;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.releaseBrake();
    	Robot.elevator.resetPosition();
    	Robot.elevator.enablePID();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.elevator.getActualPosition() - Robot.elevator.getSetPoint()) < tolerance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.activateBrake();
    	Robot.elevator.disablePID();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
