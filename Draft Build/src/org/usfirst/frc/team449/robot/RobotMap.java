package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.subsystems.Drive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//===================Physical Height Constants=================
	
	public static final double TOTE_HEIGHT;
	public static final double TOTE_GRAB_HEIGHT;
	public static final double PLATFORM_HEIGHT;
	public static final double COOPERTITION_HEIGHT;
	public static final double ELEVATOR_BOTTOM_HEIGHT;

	//======================Universal constants====================
	
	public static final int DRIVE_ENCODER_CPR;
	public static final int ELEVATOR_ENCODER_CPR;
	
	//======================Elevator Constants=====================
	/**
	 * Channel for the elevator's top limit switch.
	 */
	public static final int ELEVATOR_TOP_LIMIT;

	/**
	 * Channel for the elevator's bottom limit switch.
	 */
	public static final int ELEVATOR_BOTTOM_LIMIT;
	
	/**
	 * Channel for the elevator's left limit switch.
	 */
	public static final int ELEVATOR_LEFT_LIMIT;
	
	/**
	 * Channel for the elevator's right limit switch.
	 */
	public static final int ELEVATOR_RIGHT_LIMIT;
	
	/***
	 * analog channel for elevator ultrasonic sensor
	 */
	public static final int ELEVATOR_ULTRASONIC;
	
	/**
	 * Channels for the elevator's arm solenoid forward thing.
	 */
	public static final int ELEVATOR_ARM_SOLENOID_FWD;
	
	/**
	 * Channels for the elevator's arm solenoid reverse thing.
	 */
	public static final int ELEVATOR_ARM_SOLENOID_REV;
	
	/**
	 * Channels for the elevator's brake solenoid forward thing.
	 */
	public static final int ELEVATOR_BRAKE_SOLENOID_FWD;
	
	/**
	 * Channels for the elevator's brake solenoid reverse thing.
	 */
	public static final int ELEVATOR_BRAKE_SOLENOID_REV;

	/**
	 * Channel A for the elevator's encoder.
	 */
	public static final int ELEVATOR_ENCODER_CHANNEL_A;
	
	/**
	 * Channel B for the elevator's encoder.
	 */
	public static final int ELEVATOR_ENCODER_CHANNEL_B;
	
	public static final double ELEVATOR_P;
	public static final double ELEVATOR_I;
	public static final double ELEVATOR_D;
	
	//public static final int TOGGLE_ELEVATOR_PID_BUTTON;
	
	/**
	 * Port for the elevator's left motor
	 */
	public static final int ELEVATOR_LEFT_MOTOR;
	
	/**
	 * Port for the elevator's right motor
	 */
	public static final int ELEVATOR_RIGHT_MOTOR;
	
	public static final double ELEVATOR_PID_TOLERANCE_RANGE;
	
	/**
	 * initial encoder top count
	 */
	public static final double ELEVATOR_INITIAL_TOP_COUNT;
	
	public static final double ELEVATOR_SPROCKET_CIRCUMFERENCE;
	
	//============================Drive Constants=======================
	/**
	 * motor controller channel for the left 1 drive motor
	 */
	public static final int DRIVE_L1;

	/**
	 * motor controller channel for the left 1 drive motor
	 */
	public static final int DRIVE_L2;

	/**
	 * motor controller channel for the right 1 drive motor
	 */
	public static final int DRIVE_R1;

	/**
	 * motor controller channel for the right 2 drive motor
	 */
	public static final int DRIVE_R2;
	
	/**
	 * Channel A for right encoder
	 */
	public static final int DRIVE_ENCODER_RA;
	
	/**
	 * channel B for right encoder
	 */
	public static final int DRIVE_ENCODER_RB;
	
	/**
	 * channel A for left encoder
	 */
	public static final int DRIVE_ENCODER_LA;
	
	/**
	 * channel B for left encoder
	 */
	public static final int DRIVE_ENCODER_LB;

	/**
	 * Drive PID P term
	 */
	public static final double DRIVE_P;
	
	/**
	 * Drive PID I term
	 */
	public static final double DRIVE_I;
	
	/**
	 * Drive PID D term
	 */
	public static final double DRIVE_D;
	
	/**
	 * Drive PID F term for speed control
	 */
	public static final double DRIVE_F;

	/**
	 * Hard limit for Drive speed under PID control in Rotations per second
	 */
	public static final int DRIVE_MAX_RATE;
	
	/**
	 * default mode for drive control true = PID, false = Manual
	 */
	public static final boolean DRIVE_DEFAULT_MODE;
	
	//===========================Aligner constants========================
	/**
	 * Channel for the aligner's left limit switch.
	 */
	public static final int ALIGNER_LEFT_LIMIT;
	
	/**
	 * Channel for the aligner's right limit switch.
	 */
	public static final int ALIGNER_RIGHT_LIMIT;
	
	/**
	 * Channel for the aligner's left motor.
	 */
	public static final int ALIGNER_LEFT_MOTOR;
	
	/**
	 * Channel for the aligner's right motor.
	 */
	public static final int ALIGNER_RIGHT_MOTOR;
	
	public static final int ALIGNER_LED_PORT;
	
	/**
	 * left aligner forward solenoid channel
	 */
	public static final int ALIGNER_SOLENOID_FORWARD;
	
 	/**
	 * left aligner reverse solenoid channel
	 */
	public static final int ALIGNER_SOLENOID_REVERSE;
	
	public static final int ALIGNER_ULTRASONIC;
	public static final int OPERATOR_JOYSTICK;
	//===========================Controller Ports/Scheme======================
	/**
	 * Joystick usb port for Joystick 0
	 */
	public static final int JOYSTICK_0;
	
	/**
	 * Joystick usb port for Joystick 1
	 */
	public static final int JOYSTICK_1;
	
	/**
	 * Joystick usb port for Joystick 2
	 */
	public static final int JOYSTICK_2;
	
	/**
	 * Joystick usb port for Joystick 3
	 */
	public static final int JOYSTICK_3;
	
	/**
	 * the joystick with the button to toggle manual mode for the drive system
	 */
	public static final int DRIVE_MANUAL_TOGGLE_JOYSTICK;

	/**
	 * the button number on DRIVE_MANUAL_TOGGLE_JOYSTICK that toggles manual mode for the drive system
	 */
	public static final int DRIVE_MANUAL_TOGGLE_BUTTON;
	
	/**
	 * Button for moving elevator up.
	 */
	public static final int ELEVATOR_UP_BUTTON;
	
	/**
	 * Button for moving elevator down.
	 */
	public static final int ELEVATOR_DOWN_BUTTON;
	
	/**
	 * Button for moving the elevator all the way down.
	 */
	public static final int ELEVATOR_RESET_BUTTON;
	
	/**
	 * Button for slowing down the elevator.
	 */
	public static final int ELEVATOR_SLOW_BUTTON;

	/**
	 * Button to open the elevator arms
	 */
	public static final int ELEVATOR_ARMS_OPEN_BUTTON;

	/**
	 * Button to close the elevator arms
	 */
	public static final int ELEVATOR_ARMS_CLOSE_BUTTON;

	/**
	 * 
	 */
	public static final int CUSTOM_CONTROL;

	/**
	 * Button to move elevator to position 1 (Resets the elevator to the lowest point)
	 */
	public static final int ELEVATOR_MOVE_POS_1_BUTTON;
	
	/**
	 * Button to move elevator to position 2
	 */
	public static final int ELEVATOR_MOVE_POS_2_BUTTON;

	/**
	 * Button to move elevator to position 3
	 */
	public static final int ELEVATOR_MOVE_POS_3_BUTTON;
	
	public static final int DRIVE_LEFT_JOYSTICK;
	
	public static final int DRIVE_RIGHT_JOYSTICK;

	public static final double DRIVE_CONTROL_SENSITIVITY_FAST;
	public static final double DRIVE_CONTROL_SENSITIVITY_SLOW;
	
	public static final int ALIGNER_ARMS_OPEN;
	public static final int ALIGNER_ARMS_CLOSE;
	
	/**
	 * 
	 * @param configFile
	 */

	static {
		//===================Physical Height Constants=================
		
		TOTE_HEIGHT = 11.5;
		TOTE_GRAB_HEIGHT = 10;
		PLATFORM_HEIGHT = 7.125 * Math.sin(Math.toRadians(16));
		COOPERTITION_HEIGHT = 6.25;
		ELEVATOR_BOTTOM_HEIGHT = 9.5;

		//======================Universal constants====================
		
		System.out.println("RobotMap");
		DRIVE_ENCODER_CPR = 256;
		ELEVATOR_ENCODER_CPR = 512;
		
		//==================================================Elevator Constants ==================================================
		
		ELEVATOR_TOP_LIMIT 	= 9;
		ELEVATOR_BOTTOM_LIMIT 	= 8;
		
		ELEVATOR_LEFT_LIMIT 	= 10;
		ELEVATOR_RIGHT_LIMIT 	= 6;
		
		ELEVATOR_ULTRASONIC = 0;
		
		ELEVATOR_ARM_SOLENOID_FWD = 2;
		ELEVATOR_ARM_SOLENOID_REV = 3;
		
		ELEVATOR_BRAKE_SOLENOID_FWD = 1;
		ELEVATOR_BRAKE_SOLENOID_REV = 0;
		
		ELEVATOR_ENCODER_CHANNEL_A = 4;
		ELEVATOR_ENCODER_CHANNEL_B = 5;
		
		ELEVATOR_P = 0.005;
		ELEVATOR_I = 0;
		ELEVATOR_D = 0;
		
		ELEVATOR_LEFT_MOTOR = 2;
		ELEVATOR_RIGHT_MOTOR = 3;
		
		ELEVATOR_PID_TOLERANCE_RANGE = 0.15;
		
		ELEVATOR_INITIAL_TOP_COUNT = 2000;
		ELEVATOR_SPROCKET_CIRCUMFERENCE = 3*Math.PI;
		
		
		
		//==================================================Drive Constants ==================================================
		
		DRIVE_L1 = 6;
		DRIVE_L2 = 7;
		
		DRIVE_R1 = 4;
		DRIVE_R2 = 5;
		
		DRIVE_ENCODER_LA = 2;
		DRIVE_ENCODER_LB = 3;
		
		DRIVE_ENCODER_RA = 0;
		DRIVE_ENCODER_RB = 1;
		
		DRIVE_P = 0.005;
		DRIVE_I = 0;
		DRIVE_D = 0;
		DRIVE_F = 0;
		
		DRIVE_MAX_RATE = 4;
		DRIVE_DEFAULT_MODE = Drive.MANUAL;
		
		//==================================================Aligner Constants ==================================================
		
		ALIGNER_LEFT_LIMIT = 7;
		ALIGNER_RIGHT_LIMIT = 7;
		
		ALIGNER_LEFT_MOTOR = 8;
		ALIGNER_RIGHT_MOTOR = 8;
		ALIGNER_LED_PORT =9;
		
		ALIGNER_SOLENOID_FORWARD = 7;
		ALIGNER_SOLENOID_REVERSE = 6;
		
		ALIGNER_ULTRASONIC = 0;
		//==================================================Control Constants ==================================================
		
		JOYSTICK_0 = 0;
		JOYSTICK_1 = 1;
		JOYSTICK_2 = 2;
		JOYSTICK_3 = 3;
		
		DRIVE_MANUAL_TOGGLE_JOYSTICK 	= JOYSTICK_0;
		DRIVE_MANUAL_TOGGLE_BUTTON		= 1;
		
		ELEVATOR_UP_BUTTON = 2;
		ELEVATOR_DOWN_BUTTON = 3;
		ELEVATOR_RESET_BUTTON = 8;
		ELEVATOR_SLOW_BUTTON = 5;
		
		ELEVATOR_ARMS_OPEN_BUTTON = 3;
		ELEVATOR_ARMS_CLOSE_BUTTON = 1;
		
		CUSTOM_CONTROL = JOYSTICK_2;

		ELEVATOR_MOVE_POS_1_BUTTON = 9;
		ELEVATOR_MOVE_POS_2_BUTTON = 4;
		ELEVATOR_MOVE_POS_3_BUTTON = 3;
		
		DRIVE_LEFT_JOYSTICK 	= JOYSTICK_0;
		DRIVE_RIGHT_JOYSTICK 	= JOYSTICK_1;
		
		DRIVE_CONTROL_SENSITIVITY_FAST = 0.5;
		DRIVE_CONTROL_SENSITIVITY_SLOW = 0.25;
		
		OPERATOR_JOYSTICK = JOYSTICK_3;
		ALIGNER_ARMS_CLOSE = 4;
		ALIGNER_ARMS_OPEN = 2;
	}// end static initializer
}//end class
