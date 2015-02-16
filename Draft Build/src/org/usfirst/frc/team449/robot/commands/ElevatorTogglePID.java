package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorTogglePID extends Command {

    public ElevatorTogglePID() {
    	requires(Robot.elevator);
    }

    protected void initialize() {
    	if(Robot.elevator.isPIDEnabled())
    		Robot.elevator.disablePID();
    	else
    		Robot.elevator.enablePID();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	System.out.println(Robot.elevator.getEncoderReading());
    	Robot.elevator.setSetPoint(Robot.elevator.getEncoderReading());
    }

    protected void interrupted() {
    }
}
