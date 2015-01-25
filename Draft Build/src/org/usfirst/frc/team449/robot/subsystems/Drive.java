package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Drive subsystem.
 */
public class Drive extends Subsystem {
    
	//left drive motors
	private final Victor leftMotor1;
	private final Victor leftMotor2;
	
	//right drive motors
	private final Victor rightMotor1;
	private final Victor rightMotor2;
	
	private final Encoder leftEncoder;
	private final Encoder rightEncoder;
	/**
	 * 
	 * @param config
	 */
	public Drive(RobotMap config){
		leftMotor1 = new Victor(config.DRIVE_L1);
		leftMotor2 = new Victor(config.DRIVE_L2);
		
		rightMotor1 = new Victor(config.DRIVE_R1);
		rightMotor2 = new Victor(config.DRIVE_R2);
		
		leftEncoder = new Encoder
	}
	
	/**
	 * Sends power to the three left and right three motors on the drive frame.
	 * @param leftVolts - The amount of volts to supply to the three left motors, from -1 to 1
	 * @param rightVolts - The amount of volts to supply to the three right motors, from -1 to 1
	 */
	public void setThrottle(double leftVolts, double rightVolts){
	
		//set voltage
		rightMotor1.set(rightVolts);
		rightMotor2.set(rightVolts);
		
		leftMotor1.set(leftVolts);
		leftMotor2.set(leftVolts);
		
	}//end move()
	
	/**
	 * @return the amount of volts going to the left motors
	 */
	public double getLeftVel(){
		return encoder.getRate();
	}
	
	/**
	 * @return the amount of volts going to the right motors
	 */
	public double getRightVel(){
		return rightMotor1.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

