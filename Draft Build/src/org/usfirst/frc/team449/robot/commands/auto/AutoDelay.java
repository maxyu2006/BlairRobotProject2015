package org.usfirst.frc.team449.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDelay extends Command {
	
	private Timer t;
	private double init_time;
	private double t_lim;
	
    public AutoDelay(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	t_lim = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	t = new Timer();
    	t.reset();
    	t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(t.get()>t_lim)
        	return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}