package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**MoveDirect: Manual control for the elevator
 *note: it directly sets the brake.
 *sets the motor throttle based on direct joystick response
 *if the joystick is below the deadband, activate brake and set motor output to zero
 *if an override is depressed, force the brake to be turned off
 *(this is why I did direct brake access)
 * stated: hazheng 2/1/14
 */
public class ElevatorMoveDirect extends Command {
	
	private final double deadband = .1; //deadband for joystick response
	private final double joystick_scale =1; //assumes joystick vals are -1 to 1;
	private double joystick_val; //scaled joystick value
	private boolean override; // brake override flag
	
    public ElevatorMoveDirect() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	override = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.override = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//TODO: Write a flag in elevator to determine if PID is enabled
    	Robot.elevator.disablePID();//this is to ensure that some other thread didn't accidentally call PID
    	joystick_val = joystick_scale*Robot.OI.getJoystickAxisY(Robot.OI.joystick3);// arbitrary assignment
    	override = Robot.OI.joystick3.getTrigger();
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

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // will terminate once it is interrupted
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
