package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Autonomouse drive command
 * Drive requested distance using bang bang control
 * Also will terminate once a specified time limit is exceeded 
 */
public class AutoDrive extends Command {

	private double initDist;
	private double initTim;
	private double setpoint; // desired distance to be traveled
	private double throttle;
	private double time_lim; // time limit, should be specified in seconds 
	private final double throttle_limit = .5; // Arbitrary throttle limit

	private boolean isFoward; //is the distance positive or negative

	private Timer t;// timer for time checking
	public AutoDrive(double distance, double time) {
		requires(Robot.drive);
		this.initDist = distance;
		this.initTim = time;
		Robot.drive.setControlMode(Drive.MANUAL);
	}

	protected void initialize() {
		setpoint = this.avgEnc()+initDist;
		if(initDist>0)
		{
			throttle = this.throttle_limit;
			isFoward = true;
		}
		else // if negative distance, have neagtive throttle
		{
			throttle = -this.throttle_limit;
			isFoward = false;
		}

		time_lim = initTim;
		t = new Timer();
		t.reset();
		t.start();
	}

	protected void execute() {
		Robot.drive.setThrottle(throttle, throttle);
		System.out.println(Robot.drive.getLeftDis() +" "+Robot.drive.getRightDis());
	}

	/**
	 * returns true once you hit your desired setpoint
	 */
	protected boolean isFinished() {
		//check if time limit has been exceeded
		if(t.get()>time_lim)
			return true; 
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

	protected void end() {
		t.stop();
		Robot.drive.setThrottle(0, 0);
	}

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
