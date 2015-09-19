package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ElevatorMoveTwo extends CommandGroup {
    
    public  ElevatorMoveTwo() {
    	addSequential(new ElevatorMoveBangBang(Robot.elevator.TWO_TOTE_HEIGHT,.75));
    	addSequential(new ElevatorMoveBangBang(Robot.elevator.TWO_TOTE_HEIGHT,.1));
    }
}
