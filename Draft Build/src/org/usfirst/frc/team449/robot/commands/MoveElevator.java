package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the elevator up or down. 
 */
public class MoveElevator extends Command {
	
	private boolean goingUp;

    public MoveElevator(boolean upOrDown) {	//hehehe
        requires(Robot.elevator);
        goingUp = upOrDown;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.releaseBrake();
    	if (goingUp) {
    		Robot.elevator.raisePosition();
    	}
    	else {
    		Robot.elevator.lowerPosition();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    protected boolean isFinished() {
    	// this needs an incompetence diminisher
        return Robot.elevator.getActualPosition() == Robot.elevator.getSetPoint();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.activateBrake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
