/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2015.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Harrison
 */
public class LowerRoller extends CommandBase {
    private Timer t;
    private static final double motor_speed = .4;
    private final double roll_time = 1; //time in miliseconds
    
    public LowerRoller() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(roller);
        t = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        roller.extend_pistons();
        roller.setRollerMotor(this.motor_speed);
        System.out.println(t.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(t.get()>this.roll_time)
            return true;
        else
            return false;
    }

    // Called once after isFinished returns true
    //stop the roller from continuing to roll
    protected void end() {
        System.out.println("Done");
        roller.setRollerMotor(0);
        t.stop();
        t.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        roller.extend_pistons();
    }
}
