package org.usfirst.frc.team449.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
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
		leftMain = new PIDMotor("left", 0.05, 0, 0, 0, new Jaguar(channel), new Encoder(), PIDMotor.SPEED_BASE);
		leftMain.enable();
		leftMain.addSlave(new Jaguar(0));
		leftMain.addSlave(new Jaguar(channel));
	}
	
	/**
	 * 
	 * @param rpm
	 */
	public void setSpeed(double rpm)
	{
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
    }
}

