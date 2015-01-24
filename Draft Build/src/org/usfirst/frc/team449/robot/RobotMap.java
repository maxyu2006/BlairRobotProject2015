package org.usfirst.frc.team449.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int[] leftMotorChannels = {0,0,0};//somebody should give this real values
	public static final int[] rightMotorChannels = {0,0,0};//somebody should give this real values

	// Elevator Constants
	public static final int elevTopLmChnl = 0;
	public static final int elevBotLmChnl = 0;
	public static final int elevLeftLmChnl = 0;
	public static final int elevRightLmChnl = 0;
	public static final int[] elevMotorChnls = {0,0};
	
	// Intake Constants
	public static final int intakeLeftLmChnl = 0;
	public static final int intakeRightLmChnl = 0;
	public static final int[] intakeMotorChnls = {0,0};
}
