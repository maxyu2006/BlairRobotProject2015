package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Includes the entire sequence for moving the elevator up or down one level.
 * It calls ReleaseBrake, then MoveElevator, then ActivateBrake.
 * The boolean parameter should be either Elevator.UP or Elevator.DOWN and is used for the MoveElevator command.
 * Read the docs on listed commands for more info.
 * @author eyob-- 2/1/15
 */
public class ElevatorMoveSequence extends CommandGroup {
    
    public ElevatorMoveSequence(RobotMap config, boolean goingUp) {
        addSequential(new ElevatorReleaseBrake());
        addSequential(new ElevatorMoveAuto(config, goingUp));
        addSequential(new ElevatorActivateBrake());
    }
}
