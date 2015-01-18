package org.usfirst.frc.team449.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ElevatorPIDCommand extends CommandGroup {
    
    public  ElevatorPIDCommand() {
        addSequential(new CalibrateElevatorPIDCommand());
        //addSequential(new MoveElevatorCommand());
    }
}
