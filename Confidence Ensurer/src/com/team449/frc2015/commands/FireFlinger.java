/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2015.commands;

import com.team449.frc2015.RobotMap;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Harrison
 */
public class FireFlinger extends CommandBase {
    
    private Timer t;
    public FireFlinger() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(flinger);
        requires(roller);
        t = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println(roller.check_arm());
        if(roller.check_arm())
            flinger.set_flinger_solenoid(true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(t.get()>RobotMap.fire_time||!roller.check_arm())
            return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        flinger.set_flinger_solenoid(false);
        t.stop();
        t.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
