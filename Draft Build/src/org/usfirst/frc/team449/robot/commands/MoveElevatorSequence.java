package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveElevatorSequence extends CommandGroup {
    
    public MoveElevatorSequence(RobotMap config, boolean goingUp) {
        addSequential(new ReleaseBrake());
        addSequential(new MoveElevator(config, goingUp));
        addSequential(new ActivateBrake());
    }
}
