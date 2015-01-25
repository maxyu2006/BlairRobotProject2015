package org.usfirst.frc.team449.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {

	/**
	 * ELEVATOR CONSTANTS
	 */
	
	public final int ELEVATOR_TOP_LIMIT;
	
	public final int ELEVATOR_BOTTOM_LIMIT;
	
	public final int ELEVATOR_LEFT_LIMIT;
	
	public final int ELEVATOR_RIGHT_LIMIT;
	
	public final int[] ELEVATOR_RIGHT_SOLENOIDS;
	
	public final int[] ELEVATOR_BRAKE_SOLENOIDS;
	
	public final int ELEVATOR_ENCODER_CHANNEL_A;
	
	public final int ELEVATOR_ENCODER_CHANNEL_B;
	
	/**
	 * DRIVE CONSTANTS
	 */
	
	public final int[] DRIVE_LEFT_MOTORS = {0,0,0};//somebody should give this real values
	
	public final int[] DRIVE_RIGHT_MOTORS = {0,0,0};//somebody should give this real values
	
	/**
	 * INTAKE CONSTANTS
	 */
	
	public final int INTAKE_LEFT_LIMIT;
	
	public final int INTAKE_RIGHT_LIMIT;
	
	public final int INTAKE_LEFT_MOTOR;
	
	public final int INTAKE_RIGHT_MOTOR;
	
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
