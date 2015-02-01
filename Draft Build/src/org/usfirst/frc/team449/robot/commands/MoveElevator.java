package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the elevator up or down one level based on a boolean fed into the constructor.
 * This boolean should be either Elevator.UP or Elevator.DOWN.
 * It will successfully stop if the carriage is within tolerance range of the set point (specified by RobotMap).
 * Note: PID mode is enabled at the initialization of this command and disabled at once the command is finished.
 * @author eyob-- AliAnwar7477 1/31/15
 */
public class MoveElevator extends Command {
	
	private boolean goingUp;
	private double tolerance;

    public MoveElevator(RobotMap config, boolean upOrDown) {	//hehehe
        requires(Robot.elevator);
        goingUp = upOrDown;
        tolerance = config.ELEVATOR_PID_TOLERANCE_RANGE;
    }

    protected void initialize() {
    	if (goingUp) {
    		Robot.elevator.raisePosition();
    	}
    	else {
    		Robot.elevator.lowerPosition();
    	}
    	Robot.elevator.enablePID();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return Math.abs(Robot.elevator.getActualPosition() - Robot.elevator.getSetPoint()) < tolerance;
    }

    protected void end() {
    	Robot.elevator.disablePID();
    }

    protected void interrupted() {
    }
}
