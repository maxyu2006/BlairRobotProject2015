package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.commands.ElevatorReset;
import org.usfirst.frc.team449.robot.commands.ElevatorSetGrabber;
import org.usfirst.frc.team449.robot.commands.DriveToggleMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public final Joystick[] joysticks = new Joystick[4];
	
	private final int Elevator_Move_Joystick;
	private final int Drive_Left_Joystick;
	private final int Drive_Right_Joystick;
	
	/**
	 * this 
	 */
	public final JoystickButton driveManualToggle;
	public final JoystickButton elevatorUp;
	public final JoystickButton elevatorDown;
	public final JoystickButton elevatorArmToggle;
	public final JoystickButton elevatorResetButton;
	
	public OI(RobotMap config)
	{
		System.out.println("OI started");
		joysticks[0] = new Joystick(config.JOYSTICK_0);
		joysticks[1] = new Joystick(config.JOYSTICK_1);
		joysticks[2] = new Joystick(config.JOYSTICK_2);
		joysticks[3] = new Joystick(config.JOYSTICK_3);
		
		this.Drive_Left_Joystick 	= config.DRIVE_LEFT_JOYSTICK;
		this.Drive_Right_Joystick 	= config.DRIVE_RIGHT_JOYSTICK;
		
		this.Elevator_Move_Joystick = config.ELEVATOR_MOVE_JOYSTICK;

		elevatorUp = new JoystickButton(joysticks[this.Elevator_Move_Joystick], config.ELEVATOR_UP_BUTTON);
		elevatorDown = new JoystickButton(joysticks[this.Elevator_Move_Joystick], config.ELEVATOR_DOWN_BUTTON);
		
		elevatorArmToggle = new JoystickButton(joysticks[this.Elevator_Move_Joystick], config.ELEVATOR_ARMS_TOGGLE_BUTTON);
		elevatorArmToggle.whenPressed(new ElevatorSetGrabber(ElevatorSetGrabber.TOGGLE));
		elevatorResetButton = new JoystickButton(joysticks[this.Elevator_Move_Joystick], 8);
		elevatorResetButton.whenPressed(new ElevatorReset());
		
		driveManualToggle = new JoystickButton(joysticks[config.DRIVE_MANUAL_TOGGLE_JOYSTICK],config.DRIVE_MANUAL_TOGGLE_BUTTON);
	}
	
	/**
	 * get the axis assigned to the left side of the drive
	 * @return a double between -1 and 1
	 */
	public double getDriveAxisLeft()
	{
		return 0.5*this.joysticks[this.Drive_Left_Joystick].getAxis(Joystick.AxisType.kY);
	}
	
	/**
	 * get the axis assigned to the right side of the drive
	 * @return a double between -1 and 1
	 */
	public double getDriveAxisRight()
	{
		return 0.5*this.joysticks[this.Drive_Right_Joystick].getAxis(Joystick.AxisType.kY);
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

	public double getElevatorJoystickAxisY() {
		// TODO Auto-generated method stub
		return joysticks[this.Elevator_Move_Joystick].getAxis(Joystick.AxisType.kY);
	}
	
	
}//end class

