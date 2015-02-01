package org.usfirst.frc.team449.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public final Joystick joystick1;
	public final Joystick joystick2;
	public final Joystick joystick3;
	public final Joystick joystick4;
	public final Button elevatorUp;
	public final Button elevatorDown;
	public final Button elavatorArmToggle;
	
	public OI(RobotMap config)
	{
		joystick1 = new Joystick(config.JOYSTICK_1);
		joystick2 = new Joystick(config.JOYSTICK_2);
		joystick3 = new Joystick(config.JOYSTICK_3);
		joystick4 = new Joystick(config.JOYSTICK_4);
		elevatorUp = new JoystickButton(joystick3, config.ELEVATOR_UP_BUTTON);
		elevatorDown = new JoystickButton(joystick3, config.ELEVATOR_DOWN_BUTTON);
		elavatorArmToggle = new JoystickButton(joystick3, config.ELEVATOR_ARMS_TOGGLE_BUTTON);
		
		
	}
	
	/**
	 * 
	 * @param joystick
	 * @return
	 */
	public double getJoystickAxisX(Joystick joystick)
	{
		return joystick.getAxis(Joystick.AxisType.kX);
	}
	
	public double getJoystickAxisY(Joystick joystick)
	{
		return joystick.getAxis(Joystick.AxisType.kY);
	}
	
	public double getJoystickAxisThrottle(Joystick joystick)
	{
		return joystick.getAxis(Joystick.AxisType.kThrottle);
	}
	
	
}//end class

