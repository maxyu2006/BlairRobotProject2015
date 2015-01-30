package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.subsystems.AnalogUltrasonic;
import org.usfirst.frc.team449.robot.subsystems.Elevator;
import org.usfirst.frc.team449.robot.subsystems.SensorBoard;
import org.usfirst.frc.team449.robot.subsystems.SpeedBaseDrive;



import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//public static final SensorBoard sensorBoard = new SensorBoard();
	//public static final Elevator elevator = new Elevator();
	public static OI oi;
	public static Timer t;
	private AnalogUltrasonic ultrasonicSensor;
	//public static Elevator elevator;
	public static SpeedBaseDrive drive;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	//elevator = new Elevator();
		drive = new SpeedBaseDrive();

    	
    	oi = new OI();
		t = new Timer();

		this.ultrasonicSensor = new AnalogUltrasonic(1);
		System.out.println("robot init");
		
		SmartDashboard.putNumber("kp", drive.getPIDMotor().getPIDController().getP());
		SmartDashboard.putNumber("ki", drive.getPIDMotor().getPIDController().getI());
		SmartDashboard.putNumber("kd", drive.getPIDMotor().getPIDController().getD());
		SmartDashboard.putNumber("DeadBand", 0.0);
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
        if (autonomousCommand != null) autonomousCommand.cancel();
        //t.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	//ultrasonicSensor = null;
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
       // if (t.get() >= 1) {
      /*  	SmartDashboard.putBoolean("limit switch ", sensorBoard.getDigital());
        	SmartDashboard.putNumber("pot ", sensorBoard.getPotValue());
        	SmartDashboard.putNumber("accel x ", sensorBoard.getAccelX());
        	SmartDashboard.putNumber("accel y ", sensorBoard.getAccelY());
        	SmartDashboard.putNumber("accel z ", sensorBoard.getAccelZ());*/
       // 	t.reset();
       // }
        
        SmartDashboard.putNumber("Ultrasonic Voltage", ultrasonicSensor.readAverage());
        SmartDashboard.putNumber("Ultrasonic Distance", ultrasonicSensor.readDistance());
        
        SmartDashboard.putNumber("Encoder speed", drive.measureSpeed());
        SmartDashboard.putNumber("SetPoint speed", drive.getPIDMotor().getSetpoint());
        
        drive.getPIDMotor().setKp(SmartDashboard.getNumber("kp"));
        drive.getPIDMotor().setKi(SmartDashboard.getNumber("ki"));
        drive.getPIDMotor().setKd(SmartDashboard.getNumber("kd"));
        drive.getPIDMotor().setAbsoluteTolerance(SmartDashboard.getNumber("DeadBand"));
        
    	//SmartDashboard.putNumber("en \"position\" ", Robot.elevator.getPosition());
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}