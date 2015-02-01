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
	
	//======================Elevator Constants=====================
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
	 * Channels for the elevator's arm solenoid forward thing.
	 */
	public final int ELEVATOR_ARM_SOLENOID_FWD;
	
	/**
	 * Channels for the elevator's arm solenoid reverse thing.
	 */
	public final int ELEVATOR_ARM_SOLENOID_REV;
	
	
	
	/**
	 * Channels for the elevator's brake solenoid forward thing.
	 */
	public final int ELEVATOR_BRAKE_SOLENOID_FWD;
	
	/**
	 * Channels for the elevator's brake solenoid reverse thing.
	 */
	public final int ELEVATOR_BRAKE_SOLENOID_REV;
	
	
	/**
	 * Channel A for the elevator's encoder.
	 */
	public final int ELEVATOR_ENCODER_CHANNEL_A;
	
	/**
	 * Channel B for the elevator's encoder.
	 */
	public final int ELEVATOR_ENCODER_CHANNEL_B;
	
	public final double ELEVATOR_P;
	public final double ELEVATOR_I;
	public final double ELEVATOR_D;
	
	public final int ELEVATOR_LEFT_MOTOR;
	public final int ELEVATOR_RIGHT_MOTOR;
	
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
	//===========================Intake constants========================
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
	
	public final int INTAKE_LSOLENOID_FORWARD;
	
	public final int INTAKE_LSOLENOID_REVERSE;
	
	public final int INTAKE_RSOLENOID_FORWARD;
	
	public final int INTAKE_RSOLENOID_REVERSE;
	
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
		
		this.ELEVATOR_TOP_LIMIT = 0;
		this.ELEVATOR_BOTTOM_LIMIT = 1;
		this.ELEVATOR_LEFT_LIMIT = 2;
		this.ELEVATOR_RIGHT_LIMIT = 3;
		
		this.ELEVATOR_ARM_SOLENOID_FWD = 0;
		this.ELEVATOR_ARM_SOLENOID_REV = 1;
		this.ELEVATOR_BRAKE_SOLENOID_FWD = 2;
		this.ELEVATOR_BRAKE_SOLENOID_REV = 3;
		
		
		this.ELEVATOR_ENCODER_CHANNEL_A = 0;
		this.ELEVATOR_ENCODER_CHANNEL_B = 1;
		
		this.ELEVATOR_P = 0.05;
		this.ELEVATOR_I = 0;
		this.ELEVATOR_D = 0;

		this.ELEVATOR_LEFT_MOTOR = 0;
		this.ELEVATOR_RIGHT_MOTOR = 1;
		
		this.DRIVE_ENCODER_RA = 0;
		this.DRIVE_ENCODER_RB = 1;
		this.DRIVE_ENCODER_LA = 2;
		this.DRIVE_ENCODER_LB = 3;
		
		this.DRIVE_MAX_RATE = 512;
		
		this.DRIVE_P = 0.05;
		this.DRIVE_I = 0;
		this.DRIVE_D = 0;
		
		this.INTAKE_LEFT_LIMIT = 0;
		this.INTAKE_RIGHT_LIMIT = 1;
		this.INTAKE_LEFT_MOTOR = 2;
		this.INTAKE_RIGHT_MOTOR = 3;
		
		this.INTAKE_LSOLENOID_FORWARD=0;
		
		this.INTAKE_LSOLENOID_REVERSE=1;
		
		this.INTAKE_RSOLENOID_FORWARD=2;
		
		this.INTAKE_RSOLENOID_REVERSE=3;
	}//end RobotMap()
}//end class
