package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Sets the setpoint for the PID position control for the elevator
 * Ends and sets elevator brakes when setpoint is reached
 */
public class ElevatorMoveToSetpoint extends Command {
	
	private double setpoint; // desired elevator setpoint
	
	/**
	 * @param position the desired position in inches
	 */
    public ElevatorMoveToSetpoint(double position) {	
    	requires(Robot.elevator);
    	setpoint = position;
    }

    protected void initialize() {
    	
    	double calculatedSetpoint = setpoint - Robot.elevator.getBottomPosition();
    	SmartDashboard.putNumber("calculatedSetpoint", calculatedSetpoint);
    	
    	if(Robot.elevator.isPIDEnabled()){
    		Robot.elevator.setSetPoint(calculatedSetpoint);
    	}
    	else{
    		System.err.println("PID elevator control attempted while under manual mode");
    	}
    }

    protected void execute() {
    	// if elevator is at a limit, set flag to true
    	 
    }

    protected boolean isFinished() {
    	if(Robot.elevator.isAtSetPoint())
    		return true;
    	
    	if(Robot.elevator.isTouchingBottom())
    	{
    		Robot.elevator.setBottomPosition(Robot.elevator.getEncoderPosition());
    		return true;
    	}
    	
    	if(Robot.elevator.isTouchingTop())
    	{
    		Robot.elevator.setTopPosition(Robot.elevator.getEncoderPosition());
    		return true;
    	}
    		//end if the elevator is at the setpoint, or if a limit is reached
    	return false;
    }

    protected void end() {
    	if(Robot.elevator.isTouchingBottom() || Robot.elevator.isTouchingTop())//if a limit was reached, set to manual mode to prevent possible future damage
    	{
    		Robot.elevator.disablePID();
    		System.err.println("PID elevator control exceeded elevator limits");
    	}
    	Robot.elevator.activateBrake();
    }

    protected void interrupted() {
    }
    
    public boolean isInterruptible()
    {
    	return false;
    }
}
