package org.usfirst.frc.team449.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick elevJoy = new Joystick(RobotMap.joyPort);
	
	public OI() {
		
	}
	
	public double getElevJoyY() {
		return deadBand(elevJoy.getAxis(AxisType.kY));
	}
	
	private static double deadBand(double val) {
		if (Math.abs(val) < 0.05) return 0;
		return val;
	}
	
}
