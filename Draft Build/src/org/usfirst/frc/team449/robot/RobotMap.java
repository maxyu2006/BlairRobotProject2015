package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.subsystems.Drive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {

	//======================Universal constants====================
	
	public final int DRIVE_ENCODER_CPR;
	public final int ELEVATOR_ENCODER_CPR;
	
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
	
	/**
	 * initial encoder top count
	 */
	public final double ELEVATOR_INITIAL_TOP_COUNT;
	
	public final double ELEVATOR_SPROCKET_CIRCUMFERENCE;
	
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
	
	public final int INTAKE_LED_PORT;
	
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

	public final int INTAKE_ULTRASONIC;
	public final int INTAKE_JOYSTICK;
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
	 * Button to open the elevator arms
	 */
	public final int ELEVATOR_ARMS_OPEN_BUTTON;

	/**
	 * Button to close the elevator arms
	 */
	public final int ELEVATOR_ARMS_CLOSE_BUTTON;

	/**
	 * 
	 */
	public final int ELEVATOR_MOVE_JOYSTICK;
	
	public final int DRIVE_LEFT_JOYSTICK;
	
	public final int DRIVE_RIGHT_JOYSTICK;
	
	public final double DRIVE_CONTROL_SENSITIVITY;
	
	public final int INTAKE_ARMS_OPEN;
	public final int INTAKE_ARMS_CLOSE;
	
	/**
	 * 
	 * @param configFile
	 */
	public RobotMap(String configFile)
	{
		System.out.println("RobotMap");
		this.DRIVE_ENCODER_CPR = 256;
		this.ELEVATOR_ENCODER_CPR = 512;
		
		//==================================================Elevator Constants ==================================================
		
		this.ELEVATOR_TOP_LIMIT 	= 9;
		this.ELEVATOR_BOTTOM_LIMIT 	= 8;
		
		this.ELEVATOR_LEFT_LIMIT 	= 10;
		this.ELEVATOR_RIGHT_LIMIT 	= 6;
		
		this.ELEVATOR_ULTRASONIC = 0;
		
		this.ELEVATOR_ARM_SOLENOID_FWD = 2;
		this.ELEVATOR_ARM_SOLENOID_REV = 3;
		
		this.ELEVATOR_BRAKE_SOLENOID_FWD = 1;
		this.ELEVATOR_BRAKE_SOLENOID_REV = 0;
		
		this.ELEVATOR_ENCODER_CHANNEL_A = 4;
		this.ELEVATOR_ENCODER_CHANNEL_B = 5;
		
		this.ELEVATOR_P = 0.005;
		this.ELEVATOR_I = 0;
		this.ELEVATOR_D = 0;
		
		this.ELEVATOR_LEFT_MOTOR = 2;
		this.ELEVATOR_RIGHT_MOTOR = 3;
		
		this.ELEVATOR_PID_TOLERANCE_RANGE = 0.15;
		
		this.ELEVATOR_INITIAL_TOP_COUNT = 2000;
		this.ELEVATOR_SPROCKET_CIRCUMFERENCE = 3*Math.PI;
		
		//==================================================Drive Constants ==================================================
		
		this.DRIVE_L1 = 6;
		this.DRIVE_L2 = 7;
		
		this.DRIVE_R1 = 4;
		this.DRIVE_R2 = 5;
		
		this.DRIVE_ENCODER_LA = 2;
		this.DRIVE_ENCODER_LB = 3;
		
		this.DRIVE_ENCODER_RA = 0;
		this.DRIVE_ENCODER_RB = 1;
		
		this.DRIVE_P = 0.005;
		this.DRIVE_I = 0;
		this.DRIVE_D = 0;
		this.DRIVE_F = 0;
		
		this.DRIVE_MAX_RATE = 4;
		this.DRIVE_DEFAULT_MODE = Drive.MANUAL;
		
		//==================================================Intake Constants ==================================================
		
		this.INTAKE_LEFT_LIMIT = 7;
		this.INTAKE_RIGHT_LIMIT = 7;
		
		this.INTAKE_LEFT_MOTOR = 8;
		this.INTAKE_RIGHT_MOTOR = 8;
		this.INTAKE_LED_PORT =9;
		
		this.INTAKE_LSOLENOID_FORWARD = 4;
		this.INTAKE_LSOLENOID_REVERSE = 5;
		
		this.INTAKE_RSOLENOID_FORWARD = 7;
		this.INTAKE_RSOLENOID_REVERSE = 6;
		
		this.INTAKE_ULTRASONIC = 0;
		//==================================================Control Constants ==================================================
		
		this.JOYSTICK_0 = 0;
		this.JOYSTICK_1 = 1;
		this.JOYSTICK_2 = 2;
		this.JOYSTICK_3 = 3;
		
		this.DRIVE_MANUAL_TOGGLE_JOYSTICK 	= 0;
		this.DRIVE_MANUAL_TOGGLE_BUTTON		= 1;
		
		this.ELEVATOR_UP_BUTTON = 2;
		this.ELEVATOR_DOWN_BUTTON = 3;
		
		this.ELEVATOR_ARMS_OPEN_BUTTON = 1;
		this.ELEVATOR_ARMS_CLOSE_BUTTON = 3;
		
		this.ELEVATOR_MOVE_JOYSTICK = 2;
		
		this.DRIVE_LEFT_JOYSTICK 	= 0;
		this.DRIVE_RIGHT_JOYSTICK 	= 1;
		
		this.DRIVE_CONTROL_SENSITIVITY = 0.5;
		
		this.INTAKE_JOYSTICK = 3;
		this.INTAKE_ARMS_CLOSE = 1;
		this.INTAKE_ARMS_OPEN = 2;
	}//end RobotMap()
}//end class
