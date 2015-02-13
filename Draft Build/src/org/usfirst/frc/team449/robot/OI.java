package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.commands.ElevatorReset;
import org.usfirst.frc.team449.robot.commands.ArmSetGrabber;
import org.usfirst.frc.team449.robot.commands.DriveToggleMode;
import org.usfirst.frc.team449.robot.commands.IntakeSetArms;

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
	
	private final int ELEVATOR_MOVE_JOYSTICK;
	private final int DRIVE_LEFT_JOYSTICK;
	private final int DRIVE_RIGHT_JOYSTICK;
	
	private final double DRIVE_SENSITIVITY;
	
	/**
	 * this 
	 */
	public final JoystickButton driveManualToggle;
	public final JoystickButton elevatorUp;
	public final JoystickButton elevatorDown;
	public final JoystickButton elevatorArmToggle;
	public final JoystickButton elevatorResetButton;
	public final JoystickButton intakeArmsClose;
	public final JoystickButton intakeArmsOpen;
	
	public OI(RobotMap config)
	{
		System.out.println("OI started");
		joysticks[0] = new Joystick(config.JOYSTICK_0);
		joysticks[1] = new Joystick(config.JOYSTICK_1);
		joysticks[2] = new Joystick(config.JOYSTICK_2);
		joysticks[3] = new Joystick(config.JOYSTICK_3);
		
		this.DRIVE_LEFT_JOYSTICK 	= config.DRIVE_LEFT_JOYSTICK;
		this.DRIVE_RIGHT_JOYSTICK 	= config.DRIVE_RIGHT_JOYSTICK;
		
		this.ELEVATOR_MOVE_JOYSTICK = config.ELEVATOR_MOVE_JOYSTICK;

		this.DRIVE_SENSITIVITY = config.DRIVE_CONTROL_SENSITIVITY;
		
		elevatorUp = new JoystickButton(joysticks[this.ELEVATOR_MOVE_JOYSTICK], config.ELEVATOR_UP_BUTTON);
		elevatorDown = new JoystickButton(joysticks[this.ELEVATOR_MOVE_JOYSTICK], config.ELEVATOR_DOWN_BUTTON);
		
		elevatorArmToggle = new JoystickButton(joysticks[this.ELEVATOR_MOVE_JOYSTICK], config.ELEVATOR_ARMS_TOGGLE_BUTTON);
		elevatorArmToggle.whenPressed(new ArmSetGrabber(ArmSetGrabber.TOGGLE));
		elevatorResetButton = new JoystickButton(joysticks[this.ELEVATOR_MOVE_JOYSTICK], 8);
		elevatorResetButton.whenPressed(new ElevatorReset());
		
		driveManualToggle = new JoystickButton(joysticks[config.DRIVE_MANUAL_TOGGLE_JOYSTICK],config.DRIVE_MANUAL_TOGGLE_BUTTON);
		
		System.out.println("3");
		intakeArmsClose = new JoystickButton(joysticks[config.INTAKE_JOYSTICK], config.INTAKE_ARMS_CLOSE);
		intakeArmsClose.whenPressed(new IntakeSetArms(IntakeSetArms.CLOSE));
		intakeArmsOpen = new JoystickButton(joysticks[config.INTAKE_JOYSTICK], config.INTAKE_ARMS_OPEN);
		intakeArmsOpen.whenPressed(new IntakeSetArms(IntakeSetArms.OPEN));
		
		System.out.println("OI ended");
	}
	
	/**
	 * get the axis assigned to the left side of the drive
	 * @return a double between -1 and 1
	 */
	public double getDriveAxisLeft()
	{
		//inverted due to joystick direction
		return -this.DRIVE_SENSITIVITY*this.joysticks[this.DRIVE_LEFT_JOYSTICK].getAxis(Joystick.AxisType.kY);
	}
	
	/**
	 * get the axis assigned to the right side of the drive
	 * @return a double between -1 and 1
	 */
	public double getDriveAxisRight()
	{
		//inverted due to joystick direction
		return -this.DRIVE_SENSITIVITY*this.joysticks[this.DRIVE_RIGHT_JOYSTICK].getAxis(Joystick.AxisType.kY);
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
		return joysticks[this.ELEVATOR_MOVE_JOYSTICK].getAxis(Joystick.AxisType.kY);
	}
	
	
}//end class

