package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Just activates the brake, isFinished is set to return true.
 * Note: This assumes that the brakes work; if the brakes can receive a message to move,
 * but nothing physically happens, it will still end as if it did work.
 * @author eyob-- 2/1/15
 */
public class ActivateBrake extends Command {

    public ActivateBrake() {
        requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.activateBrake();
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
