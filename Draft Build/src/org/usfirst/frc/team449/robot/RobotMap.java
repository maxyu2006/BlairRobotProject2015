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
	 * motor controller channel for the right 2 drive motor
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

	/**
	 * Drive PID P term
	 */
	public final double DRIVE_P;
	
	/**
	 * Drive PID I term
	 */
	public final double DRIVE_I;
	
	/**
	 * Drive PID D term
	 */
	public final double DRIVE_D;
	
	/**
	 * Drive PID F term for speed control
	 */
	public final double DRIVE_F;

	/**
	 * Hard limit for Drive speed under PID control in Rotations per second
	 */
	public final int DRIVE_MAX_RATE;
	
	/**
	 * default mode for drive control true = PID, false = Manual
	 */
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
	
	//===========================Controller Ports/Scheme======================
	/**
	 * Joystick usb port for Joystick 0
	 */
	public final int JOYSTICK_0;
	
	/**
	 * Joystick usb port for Joystick 1
	 */
	public final int JOYSTICK_1;
	
	/**
	 * Joystick usb port for Joystick 2
	 */
	public final int JOYSTICK_2;
	
	/**
	 * Joystick usb port for Joystick 3
	 */
	public final int JOYSTICK_3;
	
	/**
	 * the joystick with the button to toggle manual mode for the drive system
	 */
	public final int DRIVE_MANUAL_TOGGLE_JOYSTICK;
	

	/**
	 * the button number on DRIVE_MANUAL_TOGGLE_JOYSTICK that toggles manual mode for the drive system
	 */
	public final int DRIVE_MANUAL_TOGGLE_BUTTON;
	
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

	/**
	 * 
	 * @param configFile
	 */
	public RobotMap(String configFile)
	{

	}//end RobotMap()
}//end class
