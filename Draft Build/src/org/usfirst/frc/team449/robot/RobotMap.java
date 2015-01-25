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
	
	/**
	 * Channel for the elevator's top limit switch.
	 */
	public final int ELEVATOR_TOP_LIMIT;
	
	/**
	 * Channel for the elevator's bottom limit switch.
	 */
	public final int ELEVATOR_BOTTOM_LIMIT;
	
	/**
	 * Channel for the elevator's left limit switch.
	 */
	public final int ELEVATOR_LEFT_LIMIT;
	
	/**
	 * Channel for the elevator's right limit switch.
	 */
	public final int ELEVATOR_RIGHT_LIMIT;
	
	/**
	 * Channels for the elevator's left solenoids.
	 */
	public final int[] ELEVATOR_LEFT_SOLENOIDS;
	
	/**
	 * Channels for the elevator's right solenoids.
	 */
	public final int[] ELEVATOR_RIGHT_SOLENOIDS;
	
	/**
	 * Channels for the elevator's brake solenoids.
	 */
	public final int[] ELEVATOR_BRAKE_SOLENOIDS;

	/**
	 * Channel A for the elevator's encoder.
	 */
	public final int ELEVATOR_ENCODER_CHANNEL_A;
	
	/**
	 * Channel B for the elevator's encoder.
	 */
	public final int ELEVATOR_ENCODER_CHANNEL_B;
	
	/**
	 * DRIVE CONSTANTS
	 */
	
	/**
	 * Channels for the drive's left motors.
	 */
	public final int[] DRIVE_LEFT_MOTORS = {0,0};//somebody should give this real values
	
	/**
	 * Channels for the drive's right motors.
	 */
	public final int[] DRIVE_RIGHT_MOTORS = {0,0};//somebody should give this real values
	
	/**
	 * Channel A for right encoder
	 */
	public final int DRIVE_RIGHT_ENCODER_A;
	
	/**
	 * channel B for right encoder
	 */
	public final int DRIVE_RIGHT_ENCODER_B;
	
	/**
	 * channel A for left encoder
	 */
	public final int DRIVE_LEFT_ENCODER_A;
	
	/**
	 * channel B for left encoder
	 */
	public final int DRIVE_LEFT_ENCODER_B;
	
	/**
	 * Channel A for drive's left encoder.
	 */
	public final int DRIVE_LEFT_ENCODER_CHANNEL_A = 0;
	
	/**
	 * Channel B for drive's left encoder.
	 */
	public final int DRIVE_LEFT_ENCODER_CHANNEL_B = 0;
	
	/**
	 * Channel A for drive's left encoder.
	 */
	public final int DRIVE_RIGHT_ENCODER_CHANNEL_A = 0;
	
	/**
	 * Channel B for drive's right encoder.
	 */
	public final int DRIVE_RIGHT_ENCODER_CHANNEL_B = 0;
	
	/**
	 * INTAKE CONSTANTS
	 */
	
	/**
	 * Channel for the intake's left limit switch.
	 */
	public final int INTAKE_LEFT_LIMIT;
	
	/**
	 * Channel for the intake's right limit switch.
	 */
	public final int INTAKE_RIGHT_LIMIT;
	
	/**
	 * Channel for the intake's left motor.
	 */
	public final int INTAKE_LEFT_MOTOR;
	
	/**
	 * Channel for the intake's right motor.
	 */
	public final int INTAKE_RIGHT_MOTOR;
	
	/**
	 * CONTROLLER PORTS
	 */

	
	
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
