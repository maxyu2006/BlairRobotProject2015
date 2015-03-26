package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlignerSetArms extends Command {
	private int armState; 
	public static final int OPEN = 0;
	public static final int CLOSE = 1;
	public static final int TOGGLE = 2;

    public AlignerSetArms(int setState) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.aligner);
    	armState = setState;
        System.out.println("initialized setArmsCommand");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("eyyy lmao");
    	switch(this.armState)
    	{
    	case OPEN:
    		Robot.aligner.openArms();
    		break;
    	case CLOSE:
    		Robot.aligner.closeArms();
    		break;
    	default:
    		System.out.println("You done fucked up");
    	}
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
    	new AlignerSetPWMVoltage();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
