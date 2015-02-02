package org.usfirst.frc.team449.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Chain of commands to "re-calibrate" the encoder on the elevator.
 * It calls ReleaseBrake, ResetElevator, and ActivateBrake in sequence.
 * For more info on each of these. Check the JavaDocs for them.
 * @author eyob-- 2/1/15
 */
public class ElevatorResetSequence extends CommandGroup {
    
    public ElevatorResetSequence() {
        addSequential(new ElevatorReleaseBrake());
        addSequential(new ElevatorReset());
        addSequential(new ElevatorActivateBrake());
    }
}
