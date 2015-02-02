package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeMoveArms extends Command {

	private final boolean OPEN = true;
	private final boolean CLOSED = false;

	private boolean desiredArmState;
	
    public IntakeMoveArms(boolean desiredArmState) {
    	requires(Robot.intake);
    	
        this.desiredArmState = desiredArmState;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	if(desiredArmState == OPEN)
    		Robot.intake.openArms();
    	else
    		Robot.intake.closeArms();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
