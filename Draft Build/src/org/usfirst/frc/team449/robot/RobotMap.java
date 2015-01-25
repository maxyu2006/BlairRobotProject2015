package org.usfirst.frc.team449.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Elevator Constants
	public final int elevTopLmChnl = 0;
	public final int elevBotLmChnl = 0;
	public final int elevLeftLmChnl = 0;
	public final int elevRightLmChnl = 0;
	public final int elevLeftMotorChnl = 0;
	public final int elevRightMotorChnl = 0;
	public final int[] elevLeftSolChnls = {0,0};
	public final int[] elevRightSolChnls = {0,0};
	public final int elevEncoderAChnl = 0;
	public final int elevEncoderBChnl = 0;
	
	// Drive Constants
	public final int[] leftMotorChannels = {0,0,0};//somebody should give this real values
	public final int[] rightMotorChannels = {0,0,0};//somebody should give this real values
	
	// Intake Constants
	public final int intakeLeftLmChnl = 0;
	public final int intakeRightLmChnl = 0;
	public final int intakeLeftMotor = 0;
	public final int intakeRightMotor = 0;
}
