package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Just releases the brake, isFinished is set to return true.
 * Note: This assumes that the brakes work; if the brakes can receive a message to move,
 * but nothing physically happens, it will still end as if it did work.
 * @author eyob-- 2/1/15
 */
public class ElevatorReleaseBrake extends Command {

    public ElevatorReleaseBrake() {
        requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.releaseBrake();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
