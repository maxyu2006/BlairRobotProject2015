/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.bulb.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.bulb.RobotMap;

/**
 *
 * @author emmaj_000
 */
public class Transition extends CommandBase {
    long startTime;
    
    public Transition() {
        requires(roller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        roller.setSolenoid(DoubleSolenoid.Value.kReverse);
        roller.setMotor(RobotMap.ROLLER_MK);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - startTime >= 500;
    }

    // Called once after isFinished returns true
    protected void end() {
        Command down = new Down();
        down.start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
