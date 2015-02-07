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
	
	/***
	 * analog channel for elevator ultrasonic sensor
	 */
	public final int ELEVATOR_ULTRASONIC;
	
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
	
	/**
	 * Port for the elevator's left motor
	 */
	public final int ELEVATOR_LEFT_MOTOR;
	
	/**
	 * Port for the elevator's right motor
	 */
	public final int ELEVATOR_RIGHT_MOTOR;
	
	public final double ELEVATOR_PID_TOLERANCE_RANGE;
	
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
	
	public final double DRIVE_F;
	public final double DRIVE_MAX_RATE;
	public final boolean DRIVE_DEFAULT_MODE;
	
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
	
	/**
	 * left intake forward solenoid channel
	 */
	public final int INTAKE_LSOLENOID_FORWARD;
	
	/**
	 * left intake reverse solenoid channel
	 */
	public final int INTAKE_LSOLENOID_REVERSE;
	
	/**
	 * right intake forward solenoid channel
	 */
	public final int INTAKE_RSOLENOID_FORWARD;
	
	/**
	 * right intake reverse solenoid channel
	 */
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
	public final int JOYSTICK_0;
	
	/**
	 * Button for moving elevator up.
	 */
	public final int ELEVATOR_UP_BUTTON;
	
	/**
	 * Button for moving elevator down.
	 */
	public final int ELEVATOR_DOWN_BUTTON;
	
	/**
	 * Button to toggle the elevator arms
	 */
	public final int ELEVATOR_ARMS_TOGGLE_BUTTON;
	
	public final int DRIVE_MANUAL_TOGGLE_JOYSTICK;
	public final int DRIVE_MANUAL_TOGGLE_BUTTON;
	/**
	 * 
	 * @param configFile
	 */
	public RobotMap(String configFile)
	{
		//Joystick Mappings
		this.JOYSTICK_0 = 1;
		this.JOYSTICK_1 = 2;
		this.JOYSTICK_2 = 3;
		this.JOYSTICK_3 = 4;
		
		this.ELEVATOR_ARMS_TOGGLE_BUTTON = 1;
		
		this.DRIVE_MANUAL_TOGGLE_JOYSTICK =1;
		this.DRIVE_MANUAL_TOGGLE_BUTTON =1;
		
		//analog mapping
		this.ELEVATOR_ULTRASONIC =1;
		
		//motor mappings
		this.DRIVE_L1 = 0;
		this.DRIVE_L2 = 1;
		this.DRIVE_R1 = 2;
		this.DRIVE_R2 = 3;
		
		this.ELEVATOR_LEFT_MOTOR = 2;
		this.ELEVATOR_RIGHT_MOTOR = 3;
		
		this.INTAKE_LEFT_MOTOR = 6;
		this.INTAKE_RIGHT_MOTOR =7;
		//digital input mappings
		this.ENCODER_PPR = 512;
		
		this.DRIVE_ENCODER_RA = 0;
		this.DRIVE_ENCODER_RB = 1;
		this.DRIVE_ENCODER_LA = 2;
		this.DRIVE_ENCODER_LB = 3;
		
		this.ELEVATOR_ENCODER_CHANNEL_A = 4;
		this.ELEVATOR_ENCODER_CHANNEL_B = 5;
		
		this.ELEVATOR_TOP_LIMIT = 9;
		this.ELEVATOR_BOTTOM_LIMIT = 8;
		//at this point we're on MXP ports
		this.ELEVATOR_LEFT_LIMIT = 7; 
		this.ELEVATOR_RIGHT_LIMIT = 6;
		
		this.INTAKE_LEFT_LIMIT = 15;
		this.INTAKE_RIGHT_LIMIT = 17;
		//Solenoid Mappings
		this.ELEVATOR_ARM_SOLENOID_FWD = 2;
		this.ELEVATOR_ARM_SOLENOID_REV = 3;
		this.ELEVATOR_BRAKE_SOLENOID_FWD = 0;
		this.ELEVATOR_BRAKE_SOLENOID_REV = 1;
		this.INTAKE_LSOLENOID_FORWARD=4;
		this.INTAKE_LSOLENOID_REVERSE=5;
		this.INTAKE_RSOLENOID_FORWARD=6;
		this.INTAKE_RSOLENOID_REVERSE=7;
		
		//assorted PID and button assignments
		this.ELEVATOR_P = 0.05;
		this.ELEVATOR_I = 0;
		this.ELEVATOR_D = 0;
		
		this.ELEVATOR_PID_TOLERANCE_RANGE = 0.001;
		
		this.ELEVATOR_UP_BUTTON = 3;
		this.ELEVATOR_DOWN_BUTTON = 2;
		
		this.DRIVE_MAX_RATE = 512;
		this.DRIVE_DEFAULT_MODE = false;
		
		this.DRIVE_P = 0.05;
		this.DRIVE_I = 0;
		this.DRIVE_D = 0;
		this.DRIVE_F = 0;
	}//end RobotMap()
}//end class
