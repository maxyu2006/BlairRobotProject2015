package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.RobotMap;
import org.usfirst.frc.team449.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeRunMotors extends Command {
	Joystick intakeJoystick;

    public IntakeRunMotors() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	System.out.println("Set Motor Started");
    	requires(Robot.intake);
    	intakeJoystick= Robot.OI.joysticks[3];
    	System.out.println("Set motor Done");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.setLMotor(Robot.OI.getJoystickAxisY(intakeJoystick));
    	Robot.intake.setRMotor(-Robot.OI.getJoystickAxisY(intakeJoystick));
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
