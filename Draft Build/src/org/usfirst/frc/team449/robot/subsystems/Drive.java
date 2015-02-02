package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Drive subsystem.
 */
public class Drive extends Subsystem {
    
	//drive PID motor systems
	private final PIDMotor leftMotors;
	private final PIDMotor rightMotors;
	
	private final int maxRate;
	
	private boolean manual;
	
	/**
	 * control mode manual - drivers in direct control
	 */
	public static final boolean MANUAL 	= true;
	
	/**
	 * control mode PID - PID system is in control
	 */
	public static final boolean PID		= false;
	
	/**
	 * 
	 * @param config
	 */
	public Drive(RobotMap config){
		//temporary intializations
		Victor leftMotor1 = new Victor(config.DRIVE_L1);
		Victor leftMotor2 = new Victor(config.DRIVE_L2);
		
		Victor rightMotor1 = new Victor(config.DRIVE_R1);
		Victor rightMotor2 = new Victor(config.DRIVE_R2);
		
		Encoder leftEncoder 	= new Encoder(config.DRIVE_ENCODER_LA,config.DRIVE_ENCODER_LB);
		Encoder rightEncoder	= new Encoder(config.DRIVE_ENCODER_RA,config.DRIVE_ENCODER_RB);

		this.maxRate = config.DRIVE_MAX_RATE;
		
		leftMotors = new PIDMotor(config, config.DRIVE_P, config.DRIVE_I, config.DRIVE_D, 0, leftMotor1, leftEncoder, PIDMotor.SPEED_BASE);
		leftMotors.addSlave(leftMotor2);
		
		rightMotors = new PIDMotor(config, config.DRIVE_P, config.DRIVE_I, config.DRIVE_D, 0, rightMotor1, rightEncoder, PIDMotor.SPEED_BASE);
		rightMotors.addSlave(rightMotor2);
		
		leftMotors.enable();
		rightMotors.enable();
		this.manual = false;
	}//end drive
	
	/**
	 * Sends power to the three left and right three motors on the drive frame.
	 * @param leftVolts - The amount of volts to supply to the three left motors, from -1 to 1
	 * @param rightVolts - The amount of volts to supply to the three right motors, from -1 to 1
	 */
	public void setThrottle(double leftVolts, double rightVolts){

		if(getControlState() == MANUAL)
		{
			rightMotors.setMotorVoltage(rightVolts);
			leftMotors.setMotorVoltage(leftVolts);
		}
		
		if(getControlState() == PID)
		{
			rightMotors.setSetpoint(rightVolts * this.maxRate);
			leftMotors.setSetpoint(leftVolts * this.maxRate);
		}
		
	}//end move()
	
	/**
	 * @return the amount of volts going to the left motors
	 */
	public double getLeftVel(){
		return leftMotors.getRate();
	}
	
	/**
	 * @return the amount of volts going to the right motors
	 */
	public double getRightVel(){
		return rightMotors.getRate();
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveRobot());
    }
    
    /**
     * 
     * @return
     */
    public boolean getControlState()
    {
    	return this.manual;
    }
    
    /**
     * set the control state
     * @param controlState
     */
    public void setControlState(boolean controlState)
    {
    	if(controlState == Drive.MANUAL)
    	{
    		leftMotors.disable();
    		rightMotors.disable();
    	}//end if
    	
    	if(controlState == Drive.PID)
    	{
    		leftMotors.enable();
    		rightMotors.enable();
    	}//endif
    	
    	this.manual = controlState;
    }//end setState()
}//end class

