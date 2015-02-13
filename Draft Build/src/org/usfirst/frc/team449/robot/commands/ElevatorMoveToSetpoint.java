package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the setpoint for the PID position control for the elevator
 * Ends and sets elevator brakes when setpoint is reached
 */
public class ElevatorMoveToSetpoint extends Command {
	
	/**
	 * ElevatorMoveAuto constructor
	 * @param position: The elevator desired position. Units are normalized length (0 to 1)
	 */
	
	private double setpoint; // desired elevator setpoint
	private boolean finalposition;
    public ElevatorMoveToSetpoint(double position) {	
    	requires(Robot.elevator);
    	setpoint = position;
    }

    protected void initialize() {
    	if(Robot.elevator.isPIDEnabled()){
    		Robot.elevator.setSetPoint(setpoint);
    	}
    	else{
    		System.err.println("PID elevator control attempted while under manual mode");
    	}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	return Robot.elevator.isAtSetPoint();
    }

    protected void end() {
    	Robot.elevator.activateBrake();
    }

    protected void interrupted() {
    }
}
