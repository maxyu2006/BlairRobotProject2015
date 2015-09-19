package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ElevatorMoveOne extends CommandGroup {
    
    public  ElevatorMoveOne() {
        addSequential(new ElevatorMoveBangBang(Robot.elevator.ONE_TOTE_HEIGHT+1,.5));
        addSequential(new ElevatorMoveBangBang(0,.2));
    }
}
