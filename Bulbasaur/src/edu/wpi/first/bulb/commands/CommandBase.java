package edu.wpi.first.bulb.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.bulb.OI;
import edu.wpi.first.bulb.subsystems.Roller;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Roller roller = new Roller();

    public static void init() {
        oi = new OI();
        
        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(roller);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
