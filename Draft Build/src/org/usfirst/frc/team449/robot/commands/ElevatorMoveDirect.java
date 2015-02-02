package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**MoveDirect: Manual control for the elevator
 *note: it directly sets the brake.
 *sets the motor throttle based on direct joystick response
 *if the joystick is below the deadband, activate brake and set motor output to zero
 *if an override is depressed, force the brake to be turned off
 *(this is why I did direct brake access)
 * started: hazheng 2/1/15
 */
public class ElevatorMoveDirect extends Command {
	
	private final double deadband = .1; //deadband for joystick response
	private final double joystick_scale =1; //assumes joystick vals are -1 to 1;
	private double joystick_val; //scaled joystick value
	private boolean override; // brake override flag
	
    public ElevatorMoveDirect() {
    	requires(Robot.elevator);
    	override = false;
    }

    protected void initialize() {
    	this.override = false;
    }

    protected void execute() {
    	if(Robot.elevator.isPIDEnabled())
    	{
    		Robot.elevator.disablePID();//this is to ensure that some other thread didn't accidentally call PID
    	}
    	joystick_val = joystick_scale*Robot.OI.getJoystickAxisY(Robot.OI.joysticks[2]);// arbitrary assignment
    	override = Robot.OI.joysticks[2].getTrigger();
    	if(Math.abs(joystick_val) < deadband && override==false)//if input is under deadband and no override 
    	{
    		Robot.elevator.setMotorManual(0);
    		Robot.elevator.activateBrake();
    	}
    	else // otherwise joystick is above deadband or there is an override
    	{
    		Robot.elevator.releaseBrake();
    		Robot.elevator.setMotorManual(joystick_val);
    	}
    }

    protected boolean isFinished() {
        return false; // will terminate once it is interrupted
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
