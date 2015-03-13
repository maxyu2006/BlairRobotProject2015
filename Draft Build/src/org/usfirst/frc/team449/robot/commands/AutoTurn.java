package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {

	/**
	 * throttle for the left. negate this for the right
	 */
	private double throttle;
	/**
	 * angle to turn to, in radians
	 */
	private double angle;
	private double setpoint;
	private double currentAngle;
	private double initTim;
	private double timeLim;
	private boolean isClockwise;
	private final double throttle_limit = .5; // Arbitrary throttle limit
	private Timer t;// timer for time checking
	private double ltenc;
	private double rtenc;

	/**
	 * Diamater of rotation of robot.
	 */
	public static double DIAMATER = 24.5;


	/**
	 * 
	 * @param angle positive is clockwise, in degrees
	 */
	public AutoTurn(double angle, double time) {
		requires(Robot.drive);
		this.angle = angle*Math.PI/180;
		this.currentAngle = 0;
		this.initTim = time;
		Robot.drive.setControlMode(Drive.MANUAL);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if(angle>0)
		{
			throttle = this.throttle_limit;
			isClockwise = true;
		}
		else // if negative distance, have neagtive throttle
		{
			throttle = -this.throttle_limit;
			isClockwise = false;
		}

		timeLim = initTim;
		ltenc = Robot.drive.getLeftDis();
		rtenc = Robot.drive.getRightDis();
		t = new Timer();
		t.reset();
		t.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drive.setThrottle(throttle, -throttle);
		System.out.println(Robot.drive.getLeftDis() +" "+Robot.drive.getRightDis());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//check if time limit has been exceeded
		if(t.get()>timeLim)
			return true; 
		if(isClockwise)
		{
			if(this.getAngle()>this.setpoint)
				return true;
		}
		else // aka if you're going backwards
		{
			if(this.getAngle()<this.setpoint)
				return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		t.stop();
		Robot.drive.setThrottle(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	/**
	 * @return the angle, in radians, the robot has rotated since this command begun
	 */
	private double getAngle() {
		double lt = Robot.drive.getLeftDis() - ltenc;
		double rt = Robot.drive.getLeftDis() - rtenc;
		double radius = DIAMATER/2;
		return ((lt+rt)/2)/radius;
	}
}
