package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private final double joystick_scale =1; //assumes joystick vals are -1 to 1;
	private double joystick_val; //scaled joystick value
	private boolean override; // brake override flag
	
    public ElevatorMoveDefault() {
    	requires(Robot.elevator);
    	override = false;
    }

    protected void initialize() {
    	this.override = false;
    }

    protected void execute() {
    	if(Robot.elevator.isPIDEnabled()) 
    		return;
    	
    	joystick_val = joystick_scale*Robot.OI.getJoystickAxisY(Robot.OI.joysticks[0]);// arbitrary assignment

    	override = Robot.OI.joysticks[0].getTrigger();
    	
    	if(Math.abs(joystick_val) < deadband && override==false)//if input is under deadband and no override 
    	{
    		Robot.elevator.setMotorManual(0);
    		Robot.elevator.activateBrake();
    	}
    	else // otherwise joystick is above deadband or there is an override
    	{
    		SmartDashboard.putBoolean("NotIsTouchingTop", !(Robot.elevator.isTouchingTop()));
    		SmartDashboard.putBoolean("NotIsTouchingBottom", !(Robot.elevator.isTouchingBottom()));

            SmartDashboard.putBoolean("TopLimit", Robot.elevator.isTouchingTop());
            SmartDashboard.putBoolean("BottomLimit", Robot.elevator.isTouchingBottom());
            
    		if(joystick_val < 0 && !(Robot.elevator.isTouchingTop()) || joystick_val > 0 && !(Robot.elevator.isTouchingBottom()))
    		{
    			SmartDashboard.putString("motion", "is moving up");
        		Robot.elevator.releaseBrake();
    			Robot.elevator.setMotorManual(joystick_val);	
    		}//endif
    		else
    		{
        		Robot.elevator.setMotorManual(0);
        		Robot.elevator.activateBrake();
    		}//endif
    	}//endif
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
