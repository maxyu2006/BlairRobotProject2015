package com.team449.frc2015;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //Drivebase PWM ports
    public static final int left1motor = 1;
    public static final int left2motor = 2;
    public static final int left3motor = 3;
    public static final int right1motor = 4;
    public static final int right2motor = 5;
    public static final int right3motor = 6;
    
    //Constants for the flinger
    public static final int flinger_sol = 1; //flinger solenoid port
    public static final double fire_time = .5; //time in miliseconds
    
    //constants for the roller
    public static final int roller_sol_1 = 2; //roller solenoid ports (double stage solenoid)
    public static final int roller_sol_2 = 3;
    public static final int roller_motor = 7; //roller motor PWM port
    
    //OI constants (Joystick USB constants)
    public static final int j1port = 1;
    public static final int j2port = 2;
    public static final int j3port = 3;
    public static final int j4port = 4;
    
    //constants for the compressor
    public static final int c_spike = 1; //relay port 
    public static final int p_switch = 4; // DIO port for the pressure switch
    public static final int module = 2;
    
    public static final double deadBandCap = 0.1;
}
