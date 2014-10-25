package com.team449.frc2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public abstract class RobotMap {
    public static final double deadband = .1;
    public static final int reverseButtonPos = 1;
    public static final int talonPort = 3;
    public static final int enAChnl = 1;
    public static final int enBChnl = 2;
    public static final int enDIOMod = 1;
    public static final double enDPP = 0.0020453;
    public static final int enMinRt = 0;
    public static final int enNumSamp = 1;
    public static final double multiplier = 1;
    public static final double setValue = 10.5;
    
    public static final double kP = 0.5;
    public static final double kD = 0.5;
}
