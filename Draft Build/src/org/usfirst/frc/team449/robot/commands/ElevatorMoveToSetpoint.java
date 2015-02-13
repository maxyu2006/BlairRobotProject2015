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
	private boolean isLimitReached; // flag to detect if limit swith has been hit
	
    public ElevatorMoveToSetpoint(double position) {	
    	requires(Robot.elevator);
    	setpoint = position;
    	isLimitReached = false;
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
    	// if elevator is at a limit, set flag to true
    	isLimitReached = (Robot.elevator.isTouchingBottom()||Robot.elevator.isTouchingTop()); 
    }

    protected boolean isFinished() {
    	//end if the elevator is at the setpoint, or if a limit is reached
    	return (Robot.elevator.isAtSetPoint()||isLimitReached);
    }

    protected void end() {
    	if(isLimitReached)//if a limit was reached, set to manual mode to prevent possible future damage
    	{
    		Robot.elevator.disablePID();
    		System.err.println("PID elevator control exceeded elevator limits");
    	}
    	Robot.elevator.activateBrake();
    }

    protected void interrupted() {
    }
}
