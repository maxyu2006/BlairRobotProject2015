package org.usfirst.frc.team449.robot.commands;


import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Moves the elevator based on the position of the joystick
 */
public class MoveElevatorCommand extends Command {
	
	/**
	 * scales the joystick range to the appropriate range for the PID setpoint
	 */
	private double setpoint;

    public MoveElevatorCommand() {
        requires(Robot.elevator);
    }

    protected void initialize() {
    	setpoint = .5;
    	Robot.elevator.enable();
    }

    protected void execute() {
    	String debug = "debug: ";
    	// ideal setpoint, ignoring elevator limits
    	setpoint = (Robot.oi.getElevJoyY() + 1)/2 * RobotMap.maxInput;
    	
    	// if touching top and still wanting to go up
    	if (Robot.elevator.isTouchingTop() && Robot.elevator.getPosition() <= setpoint) {
    		setpoint = Robot.elevator.getPosition();
    		debug += "topstop";
    	}
    	else if (Robot.elevator.isTouchingBottom() && Robot.elevator.getPosition() >= setpoint)
    	{
    		setpoint = Robot.elevator.getPosition();
    		debug += "bottomstop";
    	}
    	else {
    		debug += "normal";
    	}
    	
    	Robot.elevator.setSetPoint(setpoint);
    	
    	SmartDashboard.putBoolean("top limit ", Robot.elevator.isTouchingTop());
    	SmartDashboard.putBoolean("bottom limit ", Robot.elevator.isTouchingBottom());
    	SmartDashboard.putString("debugging data ", debug);
    	SmartDashboard.putNumber("setpoint ", setpoint);
    	SmartDashboard.putNumber("motor output", Robot.elevator.getPIDMotor().getMotorVal());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
