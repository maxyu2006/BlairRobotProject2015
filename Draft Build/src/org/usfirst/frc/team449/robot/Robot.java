
package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.commands.DriveRobot;
import org.usfirst.frc.team449.robot.commands.ElevatorMoveDirect;
import org.usfirst.frc.team449.robot.subsystems.Drive;
import org.usfirst.frc.team449.robot.subsystems.Elevator;
import org.usfirst.frc.team449.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//sometime should check if these could be made private
	public static final RobotMap robotMap = new RobotMap("config.txt");

	public static final OI 			OI 			= new OI(Robot.robotMap);
//	public static final Intake		intake		= new Intake(Robot.robotMap);
	public static final Elevator	elevator	= new Elevator(Robot.robotMap);
//	public static final Drive		drive		= new Drive(Robot.robotMap);
	
	public static final Compressor c = new Compressor();
	
	Command autonomousCommand;
	//initial teleop commands
	Command driveCommand;
	Command elevatorCommand;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		// instantiate the command used for the autonomous period
        autonomousCommand = null;
        c.start();
        
//        this.driveCommand = new DriveRobot();
        this.elevatorCommand = new ElevatorMoveDirect();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
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
        
//        this.driveCommand.start();
        this.elevatorCommand.start();
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
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
