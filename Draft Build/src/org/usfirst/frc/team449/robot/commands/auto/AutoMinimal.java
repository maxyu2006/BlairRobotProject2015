package org.usfirst.frc.team449.robot.commands.auto;

import org.usfirst.frc.team449.robot.commands.ElevatorReset;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Just drives back either 4 or 4.5 feet depending on whether the robot
 * needs to drive over the scoring platform. Simultaneously resets the elevator
 * during this command.
 */
public class AutoMinimal extends CommandGroup {
    
    public  AutoMinimal(boolean driveOverPlatform) {
    	addParallel(new ElevatorReset());			// reset elevator while...
    	if (driveOverPlatform)
    		addSequential(new AutoDrive(-54, 5));	// driving back 4.5 feet (w/ 5s timeout)
    	else
    		addSequential(new AutoDrive(-42, 5));	// driving back 4 feet (w/ 5s timeout)
    }
}
