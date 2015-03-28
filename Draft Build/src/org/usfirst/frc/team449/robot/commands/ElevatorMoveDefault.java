package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * MoveDirect: Manual control for the elevator
 * note: it directly sets the brake.
 * sets the motor throttle based on direct joystick response
 * if the joystick is below the deadband, activate brake and set motor output to zero
 * if an override is depressed, force the brake to be turned off
 * (this is why I did direct brake access)
 *  started: hazheng 2/1/15
 */
public class ElevatorMoveDefault extends Command {
	
	private final double deadband = .1; //deadband for joystick response
	private double joystick_scale =1; //assumes joystick vals are -1 to 1;
	
	
    public ElevatorMoveDefault() {
    	requires(Robot.elevator);
    	System.out.println("Elevator Move  Default Initialized");
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(Robot.elevator.isPIDEnabled()) 
    		return;
    	
    	if (Robot.oi.isElevatorThrottleSlow())
    		joystick_scale = 0.75;
    	else
    		joystick_scale = 1;
    	
    	double joystickValue = joystick_scale*Robot.oi.getElevatorJoystickAxisY();// arbitrary assignment
    	
    	double motorSetValue = 0;
    	
    	if(Math.abs(joystickValue) > deadband)//if input is over deadband and no override 
    	{
            //if limit switches aren't triggered in direction to move in
    		if(joystickValue < 0 && !(Robot.elevator.isTouchingTop()) || joystickValue > 0 && !(Robot.elevator.isTouchingBottom()))
    			motorSetValue = joystickValue;
    	}//endif
    	
    	//activate if motor isn't supposed to move
    	if(motorSetValue == 0)
    		Robot.elevator.activateBrake();
    	else
    		Robot.elevator.releaseBrake();
    	
    	Robot.elevator.setMotorManual(motorSetValue);
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
