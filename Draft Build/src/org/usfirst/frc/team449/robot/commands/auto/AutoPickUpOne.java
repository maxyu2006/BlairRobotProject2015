package org.usfirst.frc.team449.robot.commands.auto;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.commands.AlignerSetArms;
import org.usfirst.frc.team449.robot.commands.ArmSetGrabber;
import org.usfirst.frc.team449.robot.commands.ElevatorMoveBangBang;
import org.usfirst.frc.team449.robot.commands.ElevatorReset;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPickUpOne extends CommandGroup {

    public AutoPickUpOne() {
        addSequential(new ElevatorReset());		// elevator to bottom
        addSequential(new DriveUntilContact());	// drive till we hit a tote
        addSequential(new AlignerSetArms(AlignerSetArms.CLOSE));	// close aligner arms
        addSequential(new ArmSetGrabber(ArmSetGrabber.CLOSE));		// close elevator arms
        addSequential(new AlignerSetArms(AlignerSetArms.OPEN));		// open aligner arms
        addSequential(new ElevatorMoveBangBang(Robot.elevator.ONE_TOTE_HEIGHT));	// pick up the tote a bit
        addSequential(new AutoTurn(90, 3));	// turn 90 deg clockwise (3 second timeout)
        addSequential(new AutoDrive(120, 5));	// go 10 feet forward (5 second timeout)
    }

}
