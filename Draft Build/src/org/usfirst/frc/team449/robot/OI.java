package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.commands.ElevatorMoveBangBang;
import org.usfirst.frc.team449.robot.commands.ElevatorMoveToSetpoint;
import org.usfirst.frc.team449.robot.commands.ElevatorReset;
import org.usfirst.frc.team449.robot.commands.ArmSetGrabber;
import org.usfirst.frc.team449.robot.commands.DriveToggleMode;
import org.usfirst.frc.team449.robot.commands.ElevatorTogglePID;
import org.usfirst.frc.team449.robot.commands.IntakeSetArms;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public final Joystick[] joysticks = new Joystick[4];
	
	private final int ELEVATOR_MOVE_JOYSTICK;
	private final int DRIVE_LEFT_JOYSTICK;
	private final int DRIVE_RIGHT_JOYSTICK;
	
	private final double DRIVE_SENSITIVITY;
	
	public final JoystickButton elevatorArmOpen;
	public final JoystickButton elevatorArmClose;
	public final JoystickButton elevatorResetButton;
	public final JoystickButton intakeArmsClose;
	public final JoystickButton intakeArmsOpen;
	public final JoystickButton elevatorPos1;
	public final JoystickButton elevatorPos2;
	public final JoystickButton elevatorPos3;
	public final JoystickButton elevatorPos4;
	
	public OI(RobotMap config)
	{
		System.out.println("OI init started");
		joysticks[0] = new Joystick(config.JOYSTICK_0);
		joysticks[1] = new Joystick(config.JOYSTICK_1);
		joysticks[2] = new Joystick(config.JOYSTICK_2);
		joysticks[3] = new Joystick(config.JOYSTICK_3);
		
		this.DRIVE_LEFT_JOYSTICK 	= config.DRIVE_LEFT_JOYSTICK;
		this.DRIVE_RIGHT_JOYSTICK 	= config.DRIVE_RIGHT_JOYSTICK;
		this.ELEVATOR_MOVE_JOYSTICK = config.ELEVATOR_MOVE_JOYSTICK;
		this.DRIVE_SENSITIVITY		= config.DRIVE_CONTROL_SENSITIVITY;
		
		elevatorArmOpen = new JoystickButton(joysticks[this.ELEVATOR_MOVE_JOYSTICK], config.ELEVATOR_ARMS_OPEN_BUTTON);
		elevatorArmOpen.whenPressed(new ArmSetGrabber(ArmSetGrabber.OPEN));
		elevatorArmClose = new JoystickButton(joysticks[this.ELEVATOR_MOVE_JOYSTICK], config.ELEVATOR_ARMS_CLOSE_BUTTON);
		elevatorArmClose.whenPressed(new ArmSetGrabber(ArmSetGrabber.CLOSE));
		elevatorResetButton = new JoystickButton(joysticks[this.ELEVATOR_MOVE_JOYSTICK], 8);
		elevatorResetButton.whenPressed(new ElevatorReset());
		
		intakeArmsClose = new JoystickButton(joysticks[config.INTAKE_JOYSTICK], config.INTAKE_ARMS_CLOSE);
		intakeArmsClose.whenPressed(new IntakeSetArms(IntakeSetArms.CLOSE));
		intakeArmsOpen = new JoystickButton(joysticks[config.INTAKE_JOYSTICK], config.INTAKE_ARMS_OPEN);
		intakeArmsOpen.whenPressed(new IntakeSetArms(IntakeSetArms.OPEN));
		
		// temporary
		elevatorPos1 = new JoystickButton(joysticks[this.ELEVATOR_MOVE_JOYSTICK], 2);
		elevatorPos1.whenPressed(new ElevatorMoveBangBang(0.25*40));
		
		elevatorPos2 = new JoystickButton(joysticks[this.ELEVATOR_MOVE_JOYSTICK], 4);
		elevatorPos2.whenPressed(new ElevatorMoveBangBang(0.5*40));
		
		elevatorPos3 = new JoystickButton(joysticks[this.ELEVATOR_MOVE_JOYSTICK], 5);
		elevatorPos3.whenPressed(new ElevatorMoveBangBang(0.75*40));
		
		elevatorPos4 = new JoystickButton(joysticks[this.ELEVATOR_MOVE_JOYSTICK], 6);
		elevatorPos4.whenPressed(new ElevatorMoveBangBang(1*40));
		
		
		System.out.println("OI init ended");
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
	 * sees if the drivers are requesting drive staright mode
	 * @return
	 */
	public boolean isDriveStraightMode()
	{
		return (this.joysticks[this.DRIVE_RIGHT_JOYSTICK].getTrigger()||this.joysticks[this.DRIVE_LEFT_JOYSTICK].getTrigger());
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
		// negated because pushing the joystick forward should lower the elevator
		return -joysticks[this.ELEVATOR_MOVE_JOYSTICK].getAxis(Joystick.AxisType.kY);
	}
	
	
}//end class

