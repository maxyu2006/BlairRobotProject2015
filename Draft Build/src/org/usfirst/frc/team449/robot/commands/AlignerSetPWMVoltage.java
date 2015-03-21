package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Rescales raw ultrasonic voltage and outputs it to the pwm.
 */
public class AlignerSetPWMVoltage extends Command {

	private final double v_scale = 2/5;

    public AlignerSetPWMVoltage() {
    	requires(Robot.aligner);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double output = 0;
    	
    	output = (v_scale * Robot.aligner.getUltraRawVoltage()) + -1;
    	
    	Robot.aligner.setLED(output);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
