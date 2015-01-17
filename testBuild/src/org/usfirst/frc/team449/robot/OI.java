package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.commands.MoveElevatorCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick elevJoy = new Joystick(RobotMap.joyPort);
	private Button elevJoyTrigger = new JoystickButton(elevJoy, 1);
	
	public OI() {
		elevJoyTrigger.whenPressed(new MoveElevatorCommand());
	}
	
	public double getElevJoyY() {
		return -deadBand(elevJoy.getAxis(AxisType.kY));
	}
	
	private static double deadBand(double val) {
		if (Math.abs(val) < 0.05) return 0;
		return val;
	}
	
}

