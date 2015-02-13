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
 * 
 */
public class ElevatorMoveToSetpoint extends Command {
	
	/**
	 * UP for the state in which the elevator is going up
	 */
	public static final int UP = 0;
	
	/**
	 * DOWN for the state in which the elevator is going down
	 */
	public static final int DOWN = 1;
	
	private int state;
	private double tolerance;
	
	/**
	 * ElevatorMoveAuto constructor
	 * @param config is an instance of RobotMap
	 * @param upOrDown is the state of going up or down. Use the public static final ints
	 */
    public ElevatorMoveToSetpoint(int direction) {	
    	requires(Robot.elevator);
        state = direction;
    }

    protected void initialize() {
    	switch (state) {
    	case UP:
    		Robot.elevator.raisePosition();
    		break;
    	case DOWN:
    		Robot.elevator.lowerPosition();
    		break;
    	}
    	Robot.elevator.enablePID();
    	
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	return Robot.elevator.isAtSetPoint();
    }

    protected void end() {
    	Robot.elevator.disablePID();
    	Robot.elevator.activateBrake();
    }

    protected void interrupted() {
    }
}
