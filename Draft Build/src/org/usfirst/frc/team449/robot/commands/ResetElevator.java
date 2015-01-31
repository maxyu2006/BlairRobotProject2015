package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.subsystems.Elevator;

import org.usfirst.frc.team449.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetElevator extends Command {

    public ResetElevator() {
        requires(Robot.elevator);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.releaseBrake();
    	Robot.elevator.setSetPoint(Elevator.ELEVATOR_FIRST_POSITION/2.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getActualPosition() == Robot.elevator.getSetPoint();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.resetPosition();
    	Robot.elevator.activateBrake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
