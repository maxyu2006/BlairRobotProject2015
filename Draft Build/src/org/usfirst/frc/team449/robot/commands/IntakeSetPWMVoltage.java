package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * Rescales raw ultrasonic voltage and outputs it to the pwm.
 */
public class IntakeSetPWMVoltage extends Command {
	
	public double currentVoltage;
	private VictorSP pwm = new VictorSP(9);

    public IntakeSetPWMVoltage() {
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentVoltage = Robot.intake.getUltraRawVoltage();
    	
    	currentVoltage = ((2/5) * currentVoltage) + -1;
    	
    	pwm.set(currentVoltage);
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
