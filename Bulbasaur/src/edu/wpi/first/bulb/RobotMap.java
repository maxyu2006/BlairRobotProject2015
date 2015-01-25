package edu.wpi.first.bulb;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //roller stuff
    public static final int JOY_PORT = 1; //joystick port
    public static final int BUTTON_UP = 2; //button for the above joystick
    public static final int BUTTON_DOWN = 3; //button for the above joystick
    public static final int MOTOR_PORT = 7; //motor port
    public static final double ROLLER_MK = .5; //motor speed during Transition
    public static final int R_FWD_CHANNEL = 2; //the roller's solenoid's forward channel
    public static final int R_REV_CHANNEL = 3; // the roller's solenoid's reverse channel
}
