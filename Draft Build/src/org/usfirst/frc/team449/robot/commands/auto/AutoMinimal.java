package org.usfirst.frc.team449.robot.commands.auto;

import org.usfirst.frc.team449.robot.commands.ElevatorReset;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMinimal extends CommandGroup {
    
    public  AutoMinimal() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addParallel(new ElevatorReset());
    	addSequential(new AutoDrive(48,5));
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
