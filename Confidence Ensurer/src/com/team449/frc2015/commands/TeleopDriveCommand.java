/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2015.commands;

import com.team449.frc2015.RobotMap;
import com.team449.lib.util.Util;

/**
 *
 * @author Eyob
 */
public class TeleopDriveCommand extends CommandBase {
    
    public static boolean teleopEnabled = false;
    
    public TeleopDriveCommand() {
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        teleopEnabled = true;
        drive.setAll(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.setLeft(Util.deadBand(oi.getJ2Axis()));
        drive.setRight(Util.deadBand(oi.getJ1Axis()));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // The main class will kill this command manually when it needs to
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drive.setAll(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
