/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team449.frc2014;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.team449.frc2014.commands.CommandBase;

/**
 * Code for tiny test rig (pre-season 2015)
 * as of 10/4/2014 practice PID code
 */
public class Cyclops extends IterativeRobot {

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        
        System.out.println("robot init");
        // Initialize all subsystems
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        System.out.println("auto init");
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        System.out.println("auto periodic");
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        System.out.println("teleop init");
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        System.out.println("teleop periodic");
        Scheduler.getInstance().run();
        CommandBase.motor.setMotor(CommandBase.oi.getSpeed());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        System.out.println("test periodic");
        LiveWindow.run();
    }
}
