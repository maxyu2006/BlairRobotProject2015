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
public class ElevatorMoveAuto extends Command {
	
	/**
	 * UP for the state in which the elevator is going up
	 */
	public static final boolean UP = true;
	
	/**
	 * DOWN for the state in which the elevator is going down
	 */
	public static final boolean DOWN = false;
	
	private boolean state;
	private double tolerance;
	
	/**
	 * ElevatorMoveAuto constructor
	 * @param config is an instance of RobotMap
	 * @param upOrDown is the state of going up or down. Use the public static final booleans
	 */
    public ElevatorMoveAuto(RobotMap config, boolean upOrDown) {	//hehehe
        requires(Robot.elevator);
        state = upOrDown;
        tolerance = config.ELEVATOR_PID_TOLERANCE_RANGE;
    }

    protected void initialize() {
    	if (state) {
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
//        return Math.abs(Robot.elevator.getActualPosition() - Robot.elevator.getSetPoint()) < tolerance;
    	return Robot.elevator.isAtSetpoint();
    }

    protected void end() {
    	Robot.elevator.disablePID();
    }

    protected void interrupted() {
    }
}
