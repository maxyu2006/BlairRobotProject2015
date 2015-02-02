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
	/** the elevator control joystick */
	public final Joystick joystick3;
	public final Joystick joystick4;
	public final Button elevatorUp;
	public final Button elevatorDown;
	/** toggles the elevator arm between open and closed */
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
	 * gets the location of the joystick along the x axis as a value between -1 and 1, 
	 * where -1 is farthest to the left and 1is farthest to the right
	 * @param joystick the joystick in question
	 * @return the location of the joystick along the x axis, between -1 and 1
	 * @see #getJoystickAxisY(Joystick)
	 * @see #getJoystickAxisThrottle(Joystick)
	 */
	public double getJoystickAxisX(Joystick joystick)
	{
		return joystick.getAxis(Joystick.AxisType.kX);
	}
	
	/**
	 * gets the location of the joystick along the y axis as a value between -1 and 1, 
	 * where -1 is farthest to the back and 1 is farthest to the front
	 * @param joystick the joystick in question
	 * @return the location of the joystick along the y axis, between -1 and 1
	 * @see #getJoystickAxisX(Joystick)
	 * @see #getJoystickAxisThrottle(Joystick)
	 */
	public double getJoystickAxisY(Joystick joystick)
	{
		return joystick.getAxis(Joystick.AxisType.kY);
	}
	
	/**
	 * gets the value of the throttle between -1 and 1, where -1 is farthest from the joystick
	 * and 1is closest to it
	 * @param joystick the joystick in question
	 * @return the value of the throttle between -1 and 1
	 * @see #getJoystickAxisX(Joystick)
	 * @see #getJoystickAxisY(Joystick)
	 */
	public double getJoystickAxisThrottle(Joystick joystick)
	{
		return joystick.getAxis(Joystick.AxisType.kThrottle);
	}
	
	
}//end class

