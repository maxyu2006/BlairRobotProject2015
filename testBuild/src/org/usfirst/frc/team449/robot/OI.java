package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.commands.DriveRobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private int Annaspowerlevel = Integer.MAX_VALUE;
	
	public int coolio(){
		return 2;
	}
	
	private Joystick elevJoy = new Joystick(RobotMap.joyPort);
	private Button elevJoyTrigger = new JoystickButton(elevJoy, 1);
	
	
	public OI() {
	}
	
	public double getElevJoyY() {
		return deadBand(elevJoy.getAxis(AxisType.kY));
	}
	
	public double getElevJoyThrottle()
	{
		System.out.println("I got the axis value now " + elevJoy.getAxis(AxisType.kThrottle));
		return deadBand(elevJoy.getAxis(AxisType.kThrottle));
	}
	
	private static double deadBand(double val) {
		if (Math.abs(val) < 0.05) return 0;
		return val;
	}
	
}

