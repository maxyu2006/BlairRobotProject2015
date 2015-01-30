package org.usfirst.frc.team449.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {

	//======================Universal constants====================
	
	public final int ENCODER_PPR;

	//============================Drive Constants=======================
	/**
	 * motor controller channel for the left 1 drive motor
	 */
	public final int DRIVE_L1;

	/**
	 * motor controller channel for the left 1 drive motor
	 */
	public final int DRIVE_L2;

	/**
	 * motor controller channel for the right 1 drive motor
	 */
	public final int DRIVE_R1;

	/**
	 * motor controller channel for the right 1 drive motor
	 */
	public final int DRIVE_R2;
	
	/**
	 * Channel A for right encoder
	 */
	public final int DRIVE_ENCODER_RA;
	
	/**
	 * channel B for right encoder
	 */
	public final int DRIVE_ENCODER_RB;
	
	/**
	 * channel A for left encoder
	 */
	public final int DRIVE_ENCODER_LA;
	
	/**
	 * channel B for left encoder
	 */
	public final int DRIVE_ENCODER_LB;

	public final double DRIVE_P;
	
	public final double DRIVE_I;
	
	public final double DRIVE_D;
	
	public final int DRIVE_MAX_RATE;
	
	//===========================Controller Ports======================
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
	 * 
	 * @param configFile
	 */
	public RobotMap(String configFile)
	{
		this.ENCODER_PPR = 512;
		
		this.JOYSTICK_1 = 1;
		this.JOYSTICK_2 = 2;
		this.JOYSTICK_3 = 3;
		this.JOYSTICK_4 = 4;
		
		this.DRIVE_L1 = 0;
		this.DRIVE_L2 = 1;
		
		this.DRIVE_R1 = 2;
		this.DRIVE_R2 = 3;
				
		this.DRIVE_ENCODER_RA = 0;
		this.DRIVE_ENCODER_RB = 1;
		this.DRIVE_ENCODER_LA = 2;
		this.DRIVE_ENCODER_LB = 3;
		
		this.DRIVE_MAX_RATE = 512;
		
		this.DRIVE_P = 0.05;
		this.DRIVE_I = 0;
		this.DRIVE_D = 0;
	}//end RobotMap()
}//end class
