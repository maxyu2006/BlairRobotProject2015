package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.commands.auto.AutoDoNothing;
import org.usfirst.frc.team449.robot.commands.auto.AutoMinimal;
import org.usfirst.frc.team449.robot.commands.auto.AutoPickUpOne;
import org.usfirst.frc.team449.robot.subsystems.Aligner;
import org.usfirst.frc.team449.robot.subsystems.Arms;
import org.usfirst.frc.team449.robot.subsystems.Drive;
import org.usfirst.frc.team449.robot.subsystems.Elevator;

import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//sometime should check if these could be made private
	
	public static final Elevator	elevator	= new Elevator();
	public static final Arms		elevatorArm	= new Arms();
	public static final Drive		drive		= new Drive();
	public static final Aligner 	aligner		= new Aligner();
	
	public static final OI 			oi 			= new OI();
	
	public static final Compressor c = new Compressor();
	
	SendableChooser autoChooser;
	
	Command autonomousCommand;
	
    int session;
    Image frame;

	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	System.out.println("Robot Init Started");
    	
    	CameraServer.getInstance().setQuality(50);
    	CameraServer.getInstance().startAutomaticCapture("cam0");
    	
    	System.out.println("Camera init");
    	
		// instantiate the command used for the autonomous period
//    	autoChooser = new SendableChooser();
//    	autoChooser.addDefault("Bin clear path", new AutoPickUpOne(false, false));
//    	autoChooser.addObject("Bin clear path and drop", new AutoPickUpOne(false, true));
//    	autoChooser.addObject("Bin over platform", new AutoPickUpOne(true, false));
//    	autoChooser.addObject("Just drive clear path", new AutoMinimal(false));
//    	autoChooser.addObject("Just drive over platform", new AutoMinimal(true));
//    	autoChooser.addObject("Do nothing", new AutoDoNothing());
//    	autonomousCommand = new AutoMinimal(); 
//    	autonomousCommand = new AutoPickUpOne();
    	SmartDashboard.putData("Auto chooser", autoChooser);
    	
        c.start();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	System.out.println("auto");
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autoChooser.getSelected();
        if (autonomousCommand != null); autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();


    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putBoolean("elevator arm", elevatorArm.getArmState());
        
        SmartDashboard.putBoolean("stationary arm", aligner.getSwitchState());
        
        SmartDashboard.putBoolean("Drive straight", oi.isDriveStraightMode());
        
        SmartDashboard.putBoolean("coopertition platform", elevator.getHeight() == elevator.COOPERTITION_HEIGHT);
        SmartDashboard.putBoolean("2 totes", elevator.getHeight() == elevator.TWO_TOTE_HEIGHT);
        SmartDashboard.putBoolean("1 tote", elevator.getHeight() == elevator.ONE_TOTE_HEIGHT);
        SmartDashboard.putBoolean("scoring platform", elevator.getHeight() == elevator.PLATFORM_HEIGHT);
        SmartDashboard.putBoolean("bottom", elevator.getHeight() == elevator.BOTTOM_HEIGHT);
        
        SmartDashboard.putBoolean("bottom limit", elevator.isTouchingBottom());
        SmartDashboard.putBoolean("top limit", elevator.isTouchingTop());
        
        SmartDashboard.putNumber("elev encoder", elevator.getEncoderPosition());
        SmartDashboard.putNumber("elev count", elevator.getEncoderReading());
        
        SmartDashboard.putBoolean("motor 00", drive.getLeftCluster().getFunctioning()[0]);
        SmartDashboard.putBoolean("motor 01", drive.getLeftCluster().getFunctioning()[1]);
        SmartDashboard.putBoolean("motor 10", drive.getRightCluster().getFunctioning()[0]);
        SmartDashboard.putBoolean("motor 11", drive.getRightCluster().getFunctioning()[1]);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}