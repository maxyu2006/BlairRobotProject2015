package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseIntakeArms extends Command {

	private boolean isCommandFinished;
	
    public CloseIntakeArms() {
        requires(Robot.intake);
        
        isCommandFinished = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	// If the intake arms are already closed, this command is finished.
    	if(!Robot.intake.areArmsOpen())
    		isCommandFinished = true;
    	
    	// If the intake arms are open, close them.
    	else
    		Robot.intake.toggleArms();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// If the intake arms are closed, this command is finished.
    	if(!Robot.intake.areArmsOpen())
    		isCommandFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCommandFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
