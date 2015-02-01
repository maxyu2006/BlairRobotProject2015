package org.usfirst.frc.team449.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ResetElevatorSequence extends CommandGroup {
    
    public ResetElevatorSequence() {
        addSequential(new ReleaseBrake());
        addSequential(new ResetElevator());
        addSequential(new ActivateBrake());
    }
}
