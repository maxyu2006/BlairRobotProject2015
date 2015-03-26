package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *Bang bang control of the elevator
 */
public class ElevatorMoveBangBang extends Command {

	private double setpoint;
	private double throttle;
	private final double throttle_lim = .75;
	//private final double tolerance = .25;
	/**
	 * @param position the desired position in inches
	 */
    public ElevatorMoveBangBang(double position) {
        requires(Robot.elevator);
        setpoint = position;
        
        System.out.println("Elevator Move Bang Bang Initialized");

    }

    protected void initialize() {
        Robot.elevator.releaseBrake();
        throttle = Math.copySign(throttle_lim, (Robot.elevator.getEncoderPosition()-setpoint));
        Robot.elevator.disablePID();
    }

    protected void execute() {
    	Robot.elevator.setMotorManual(throttle);
//    	System.out.println("Set throttle to " + throttle + " at " + Robot.elevator.getEncoderPosition());
    }

    protected boolean isFinished() {
    	if((throttle<0 && Robot.elevator.isTouchingTop()) || (throttle>0 && Robot.elevator.isTouchingBottom()))
    	{
    		System.out.println("Bang Bang: Elevator Limit Reached");
    		return true;
    	}
    	if((throttle<0 && Robot.elevator.getEncoderPosition()>setpoint) || (throttle>0 && Robot.elevator.getEncoderPosition()<setpoint))
    	{
    		System.out.println("Bang Bang: Setpoint Reached \t"+Robot.elevator.getEncoderPosition()+" "+setpoint);
    		return true;
    	}
    	return false;
    }
    
    protected void end() {
    	Robot.elevator.setMotorManual(0);
    	Robot.elevator.activateBrake();
    	new ElevatorMoveDefault();
    	Robot.elevator.setHeight(setpoint);
    }

    protected void interrupted() {
    }
}
