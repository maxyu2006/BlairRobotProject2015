package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.commands.DriveRobot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SpeedBaseDrive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final PIDMotor leftMain;
	
	
	public SpeedBaseDrive()
	{
		leftMain = new PIDMotor(0.05, 0, 0, 0, new Victor(4), new Encoder(0, 1), PIDMotor.SPEED_BASE);
		leftMain.addSlave(new Victor(5));
		
		leftMain.enable();
	}
	
	/**
	 * 
	 * @param rpm
	 */
	public void setSpeed(double rpm)
	{
		System.out.println("Setting setpoint " + rpm);
		leftMain.setSetpoint(rpm);
		
	}
	
	/**
	 * returns the speed of the drive in RPM
	 * @return
	 */
	public double measureSpeed()
	{
		return leftMain.measureSpeed();
	}
	
	/**
	 * 
	 * @param throttle
	 */
	public void setThrottle(double throttle)
	{
		leftMain.setMotorVoltage(throttle);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveRobot());
    }

	public PIDMotor getPIDMotor() {
		// TODO Auto-generated method stub
		return this.leftMain;
	}
}

