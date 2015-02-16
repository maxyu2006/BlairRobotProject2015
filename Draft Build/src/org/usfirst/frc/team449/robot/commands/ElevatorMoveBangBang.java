package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *Bang bang control of the elevator
 */
public class ElevatorMoveBangBang extends Command {

	private double setpoint;
	private double throttle;
	private final double throttle_lim = .3;
	private final double tolerance = .25;
	private boolean lim_flag;
	/**
	 * @param position the desired position in inches
	 */
    public ElevatorMoveBangBang(double position) {
        requires(Robot.elevator);
        setpoint = position;
        throttle = Math.copySign(throttle_lim, (setpoint-Robot.elevator.getEncoderPosition()));
        lim_flag = false;
        
        Robot.elevator.disablePID();
        
        System.out.println("Elevator Move Bang Bang Initialized");

    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.elevator.setMotorManual(throttle);
    	lim_flag = (Robot.elevator.isTouchingBottom()||Robot.elevator.isTouchingTop());
    }

    protected boolean isFinished() {
    	if(lim_flag)
    	{
    		System.out.println("Bang Bang: Elevator Limit Reached");
    		return true;
    	}
    	if(Math.abs(Robot.elevator.getEncoderPosition()-setpoint)<tolerance)
    	{
    		System.out.println("Bang Bang: Setpoint Reached \t"+Robot.elevator.getEncoderPosition());
    		return true;
    	}
    	return false;
    }
    
    protected void end() {
    	Robot.elevator.setMotorManual(0);
    	Robot.elevator.activateBrake();
    	new ElevatorMoveDefault();
    }

    protected void interrupted() {
    }
}
