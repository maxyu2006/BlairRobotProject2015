package org.usfirst.frc.team449.robot.commands;


import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.RobotMap;
import org.usfirst.frc.team449.robot.subsystems.DistanceMotorPID;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the elevator based on the position of the joystick
 */
public class MoveElevatorCommand extends Command {
	
	private static final double joyToTalonFactor = RobotMap.maxInput/2;
	private double setpoint;

    public MoveElevatorCommand() {
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setpoint = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.elevator.isTouchingTop() && Robot.elevator.getPosition() <= Robot.elevator.getSetpoint())
    		setpoint = Robot.elevator.getPosition();
    	else if (Robot.elevator.isTouchingBottom() && Robot.elevator.getPosition() >= Robot.elevator.getSetpoint())
    		setpoint = Robot.elevator.getPosition();
    	else
    		setpoint = (Robot.oi.getElevJoyY() + 1) * joyToTalonFactor;
    	Robot.elevator.setSetPoint(setpoint);
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
