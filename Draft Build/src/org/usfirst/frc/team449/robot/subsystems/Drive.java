package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Drive subsystem.
 */
public class Drive extends Subsystem {
    
	//left drive motors
	private final Victor leftMotor1;
	private final Victor leftMotor2;
	private final Victor leftMotor3;
	
	//right drive motors
	private final Victor rightMotor1;
	private final Victor rightMotor2;
	private final Victor rightMotor3;
	
	/**
	 * 
	 * @param config
	 */
	public Drive(RobotMap config){
		leftMotor1 = new Victor(config.DRIVE_L1);
		leftMotor2 = new Victor(config.DRIVE_L2);
		leftMotor3 = new Victor(config.DRIVE_L3);
		
		rightMotor1 = new Victor(config.DRIVE_R1);
		rightMotor2 = new Victor(config.DRIVE_R2);
		rightMotor3 = new Victor(config.DRIVE_R3);
	}
	
	/**
	 * 
	 * @param leftVolts
	 * @param rightVolts
	 */
	public void setThrottle(double leftVolts, double rightVolts){
		
		//set voltage
		rightMotor1.set(rightVolts);
		rightMotor2.set(rightVolts);
		rightMotor3.set(rightVolts);
		
		leftMotor1.set(rightVolts);
		leftMotor2.set(rightVolts);
		leftMotor3.set(rightVolts);
		
	}//end move()
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

