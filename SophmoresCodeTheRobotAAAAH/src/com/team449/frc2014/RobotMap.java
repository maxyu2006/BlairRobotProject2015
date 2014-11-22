package com.team449.frc2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public abstract class RobotMap {
    public static final double deadband = .15;
    public static final int reverseButtonPos = 1;
    
    public static final int talonPort = 1;
    public static final int joyPort = 2;
    
    /**
     * 512 pulses per rotation, so one distance per rotation
     */
    public static final double enDPP = 1.0/512;
    public static final int enAChnl = 2;
    public static final int enBChnl = 3;
    public static final int enDIOMod = 1;
    public static final int enMinRt = 0;
    public static final int enNumSamp = 1;
    public static final double multiplier = 1;
    public static final double setValue = 15;
    
    public static double kP = 0.5;
    public static double kD = 0;
    
    public static final int encoderPPR = 512;
    
    public static final int resetButtonPos = 3;
}
