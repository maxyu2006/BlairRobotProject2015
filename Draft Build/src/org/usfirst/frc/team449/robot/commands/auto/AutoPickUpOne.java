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
        addParallel(new ArmSetGrabber(ArmSetGrabber.OPEN));
        addParallel(new AlignerSetArms(AlignerSetArms.OPEN));
    	addSequential(new ElevatorReset());		// elevator to bottom
    	
    	addSequential(new AutoDelay(1));
        
    	//addSequential(new DriveUntilContact());	// drive till we hit a tote
        //addSequential(new AlignerSetArms(AlignerSetArms.CLOSE));	// close aligner arms
        
    	addSequential(new ArmSetGrabber(ArmSetGrabber.CLOSE));		// close elevator arms
        //addSequential(new AlignerSetArms(AlignerSetArms.OPEN));		// open aligner arms
        addSequential(new AutoDelay(1));
        
    	addSequential(new ElevatorMoveBangBang(2));	// pick up the bin a bit
    	addSequential(new AutoDelay(.5));
    	addSequential(new AutoDrive(-38,5)); // drive foward
//    	addSequential(new AutoDrive(54,5)); // drive foward to get over scoring platform
    	

    }

}
