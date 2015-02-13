package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Autonomouse drive command
 * Drive requested distance using bang bang control
 * TODO: Implement a time limit as well. 
 */
public class AutoDrive extends Command {
	
	private double setpoint; // desired distance to be traveled
	private double throttle;
	private double t_limit; // time limit 
	
	private boolean isFoward; //is the distance positive or negative
	
	private final double throttle_limit = .25; // Arbitrary throttle limit
    public AutoDrive(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	
    	Robot.drive.setControlMode(Drive.MANUAL);
    	
    	setpoint = this.avgEnc()+distance;
    	if(distance>0)
    	{
    		throttle = this.throttle_limit;
    		isFoward = true;
    	}
    	else // if negative distance, have neagtive throttle
    	{
    		throttle = -this.throttle_limit;
    		isFoward = false;
    	}
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.setThrottle(throttle, throttle);
    }

    /**
     * returns true once you hit your desired setpoint
     */
    protected boolean isFinished() {
    	if(isFoward)
    	{
    		if(this.avgEnc()>this.setpoint)
    			return true;
    	}
    	else // aka if you're going backwards
    	{
    		if(this.avgEnc()<this.setpoint)
    			return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.setThrottle(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    /**
     * averages the drive encoder values
     */
    private double avgEnc(){
    	double left_d;
    	double right_d;
    	left_d = Robot.drive.getLeftDis();
    	right_d = Robot.drive.getRightDis();
    	return (left_d+right_d)/2;
    }
}
