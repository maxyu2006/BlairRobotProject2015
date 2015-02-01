package org.usfirst.frc.team449.robot.commands;
import java.sql.Time;

import org.usfirst.frc.team449.robot.Robot;


import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveDirect extends Command {
	public long startTime;
	public double joyBuffer = 0.001;
	public int inactiveLimit = 300000; //milliseconds
	
    public MoveDirect() {
        requires(Robot.elevator);
        startTime = System.currentTimeMillis(); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double joyY = Robot.OI.getJoystickAxisY(Robot.OI.joystick1); //not sure which joystick so going with joystick 1
    	Robot.elevator.releaseBrake();
    	if(joyY > joyBuffer || joyY < -joyBuffer){
    		Robot.elevator.setMotorSpeed(joyY); 
    		startTime = System.currentTimeMillis();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return startTime - System.currentTimeMillis() >= inactiveLimit;
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
