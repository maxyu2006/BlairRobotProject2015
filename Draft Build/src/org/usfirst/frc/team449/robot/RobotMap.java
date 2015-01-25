package org.usfirst.frc.team449.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {

	// Elevator Constants
	public final int elevTopLmChnl;
	public final int elevBotLmChnl;
	public final int elevLeftLmChnl;
	public final int elevRightLmChnl;
	public final int elevLeftMotorChnl;
	public final int elevRightMotorChnl;
	public final int[] elevLeftSolChnls;
	public final int[] elevRightSolChnls;
	public final int elevEncoderAChnl;
	public final int elevEncoderBChnl;
	
	// Drive Constants
	public final int[] leftMotorChannels = {0,0,0};//somebody should give this real values
	public final int[] rightMotorChannels = {0,0,0};//somebody should give this real values
	public final int encoderLA;
	public final int encoderLB;
	public final int encoderRA;
	public final int encoderRB;
	
	// Intake Constants
	public final int intakeLeftLmChnl;
	public final int intakeRightLmChnl;
	public final int intakeLeftMotor;
	public final int intakeRightMotor;
	
	
	/**
	 * Joystick port for Joystick 1
	 */
	public final int JOYSTICK_1;
	
	/**
	 * Joystick port for Joystick 2
	 */
	public final int JOYSTICK_2;
	
	/**
	 * Joystick port for Joystick 3
	 */
	public final int JOYSTICK_3;
	
	/**
	 * Joystick port for Joystick 4
	 */
	public final int JOYSTICK_4;
	
	/**
	 * motor controller channel for the left 1 drive motor
	 */
	public final int DRIVE_L1;

	/**
	 * motor controller channel for the left 1 drive motor
	 */
	public final int DRIVE_L2;

	/**
	 * motor controller channel for the left 1 drive motor
	 */
	public final int DRIVE_L3;

	/**
	 * motor controller channel for the right 1 drive motor
	 */
	public final int DRIVE_R1;

	/**
	 * motor controller channel for the right 1 drive motor
	 */
	public final int DRIVE_R2;
	
	/**
	 * motor controller channel for the right 1 drive motor
	 */
	public final int DRIVE_R3;
	
	
	/**
	 * 
	 * @param configFile
	 */
	public RobotMap(String configFile)
	{
		this.JOYSTICK_1 = 1;
		this.JOYSTICK_2 = 2;
		this.JOYSTICK_3 = 3;
		this.JOYSTICK_4 = 4;
		
		this.DRIVE_L1 = 0;
		this.DRIVE_L2 = 1;
		this.DRIVE_L3 = 2;
		
		this.DRIVE_R1 = 3;
		this.DRIVE_R2 = 4;
		this.DRIVE_R3 = 5;
	}
}
