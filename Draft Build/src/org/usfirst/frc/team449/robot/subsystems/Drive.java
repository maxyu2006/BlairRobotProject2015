package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;
import org.usfirst.frc.team449.robot.commands.DriveRobot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Drive subsystem.
 */
public class Drive extends Subsystem {
    
	//drive PID motor systems
	private final MotorCluster leftMotors;
	private final MotorCluster rightMotors;
	
	private final Encoder leftEncoder;
	private final Encoder rightEncoder;
	
	private final PIDController leftController;
	private final PIDController rightController;
	
	private final int maxRate;
	
	private boolean currentMode;
	
	/**
	 * control mode manual - drivers in direct control
	 */
	public static final boolean MANUAL 	= false;
	
	/**
	 * control mode PID - PID system is in control
	 */
	public static final boolean PID		= true;
	
	/**
	 * Initialize the Drive subsystem
	 * @param config the RobotMap containint all constants
	 */
	public Drive(RobotMap config){

		//initialize motor clusters and add slaves
		this.leftMotors = new MotorCluster(new VictorSP(config.DRIVE_L1)); 	//first motor
		this.leftMotors.addSlave(new VictorSP(config.DRIVE_L2));				//attach second motor
		
		this.rightMotors = new MotorCluster(new VictorSP(config.DRIVE_R1)); 	//first motor
		this.rightMotors.addSlave(new VictorSP(config.DRIVE_R2));				//attach second motor
		
		this.leftEncoder 	= new Encoder(config.DRIVE_ENCODER_LA,config.DRIVE_ENCODER_LB);
		this.rightEncoder	= new Encoder(config.DRIVE_ENCODER_RA,config.DRIVE_ENCODER_RB);
		
		this.leftEncoder.setDistancePerPulse(config.ENCODER_PPR);
		this.rightEncoder.setDistancePerPulse(config.ENCODER_PPR);
		
		
		this.leftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
		this.rightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);

		this.leftController = new PIDController(config.DRIVE_P, config.DRIVE_I, config.DRIVE_D, config.DRIVE_F, leftEncoder, this.leftMotors);
		this.rightController = new PIDController(config.DRIVE_P, config.DRIVE_I, config.DRIVE_D, config.DRIVE_F, rightEncoder, this.rightMotors);
		
		
		this.maxRate = config.DRIVE_MAX_RATE;

		this.setControlMode(config.DRIVE_DEFAULT_MODE);
	}//end drive
	
	/**
	 * Sends power to the two left and right two motors on the drive frame. If in PID control, it is fraction of max absolute speed set in RobotMap.
	 * If in Manual, it is fraction of maximum power.
	 * @param leftVolts - The fraction of power to supply to the two left motors, from -1 to 1
	 * @param rightVolts - The fraction of power to supply to the two right motors, from -1 to 1
	 */
	public void setThrottle(double leftPower, double rightPower){

		rightPower = -rightPower;	//negated because left motors clusters are reversed
		
		if(this.getControlMode() == MANUAL)
		{
			this.leftMotors.set(leftPower);
			this.rightMotors.set(-rightPower);
		}
		
		if(this.getControlMode() == PID)
		{
			this.leftController.setSetpoint(this.maxRate * leftPower);
			this.rightController.setSetpoint(this.maxRate * -rightPower);
		}
	}//end move()

	/**
	 * @return the current rate of the left side wheels in RPS
	 */
	public double getLeftVel(){
		return this.leftEncoder.getRate();
	}

	/**
	 * @return the current rate of the right side wheels in RPS
	 */
	public double getRightVel(){
		return this.rightEncoder.getRate();
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    	setDefaultCommand(new DriveRobot());
    }
    

    /**
     * toggle the control mode
     */
    public void toggleControlMode()
    {
    	this.setControlMode(!this.getControlMode());
    }
    
    /**
     * set the control mode of this
     * @param mode Drive.MANUAL or Drive.PID
     */
    public void setControlMode(boolean mode)
    {
    	if(mode == Drive.MANUAL)
    	{
    		this.leftController.disable();
    		this.rightController.disable();
    	}
    	
    	if(mode == Drive.PID)
    	{
    		this.leftController.enable();
    		this.rightController.enable();
    	}
    	
    	this.currentMode = mode;
    }
    
    /**
     * returns the mode the drive is in
     * @return Drive.MANUAL or Drive.PID
     */
    public boolean getControlMode()
    {
    	return this.currentMode;
    }
}//end class

