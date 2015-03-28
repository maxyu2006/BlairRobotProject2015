package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.commands.AlignerSetArms;
import org.usfirst.frc.team449.robot.commands.ArmSetGrabber;
import org.usfirst.frc.team449.robot.commands.ElevatorMoveBangBang;
import org.usfirst.frc.team449.robot.commands.ElevatorReset;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public final Joystick[] joysticks = new Joystick[4];
	
	public final int OPERATOR_JOYSTICK;
	public final int DRIVE_LEFT_JOYSTICK;
	public final int DRIVE_RIGHT_JOYSTICK;
	
	public final double DRIVE_SENSITIVITY;
	
	public final JoystickButton elevatorArmOpen;
	public final JoystickButton elevatorArmClose;
	public final JoystickButton elevatorResetButton;
	public final JoystickButton elevatorSpeedDown;
	public final JoystickButton alignerArmsClose;
	public final JoystickButton alignerArmsOpen;
	public final JoystickButton elevatorPos1;
	public final JoystickButton elevatorPos2;
	public final JoystickButton elevatorPos3;
	public final JoystickButton elevatorPos4;
	public final JoystickButton elevatorPos5;
	
	public OI(RobotMap config)
	{
		System.out.println("OI init started");
		joysticks[0] = new Joystick(config.JOYSTICK_0);
		joysticks[1] = new Joystick(config.JOYSTICK_1);
		joysticks[2] = new Joystick(config.JOYSTICK_2);
		joysticks[3] = new Joystick(config.JOYSTICK_3);
		
		this.DRIVE_LEFT_JOYSTICK 	= config.DRIVE_LEFT_JOYSTICK;
		this.DRIVE_RIGHT_JOYSTICK 	= config.DRIVE_RIGHT_JOYSTICK;
		this.OPERATOR_JOYSTICK		= config.OPERATOR_JOYSTICK;
		this.DRIVE_SENSITIVITY		= config.DRIVE_CONTROL_SENSITIVITY;
		
		elevatorArmOpen = new JoystickButton(joysticks[config.OPERATOR_JOYSTICK], 3);
		elevatorArmOpen.whenPressed(new ArmSetGrabber(ArmSetGrabber.OPEN));
		elevatorArmClose = new JoystickButton(joysticks[config.OPERATOR_JOYSTICK], 1);
		elevatorArmClose.whenPressed(new ArmSetGrabber(ArmSetGrabber.CLOSE));
		elevatorResetButton = new JoystickButton(joysticks[config.OPERATOR_JOYSTICK], 8);
		elevatorResetButton.whenPressed(new ElevatorReset());
		elevatorSpeedDown = new JoystickButton(joysticks[config.OPERATOR_JOYSTICK], 5);
		
		alignerArmsClose = new JoystickButton(joysticks[config.OPERATOR_JOYSTICK], 4);
		alignerArmsClose.whenPressed(new AlignerSetArms(AlignerSetArms.CLOSE));
		alignerArmsOpen = new JoystickButton(joysticks[config.OPERATOR_JOYSTICK], 2);
		alignerArmsOpen.whenPressed(new AlignerSetArms(AlignerSetArms.OPEN));
		
		// TEST THESE
		elevatorPos1 = new JoystickButton(joysticks[config.CUSTOM_CONTROL], 9);
		elevatorPos1.whenPressed(new ElevatorMoveBangBang(Robot.elevator.BOTTOM_HEIGHT));
		
		elevatorPos2 = new JoystickButton(joysticks[config.CUSTOM_CONTROL], 4);
		elevatorPos2.whenPressed(new ElevatorMoveBangBang(Robot.elevator.ONE_TOTE_HEIGHT));
		
		elevatorPos3 = new JoystickButton(joysticks[config.CUSTOM_CONTROL], 3);
		elevatorPos3.whenPressed(new ElevatorMoveBangBang(Robot.elevator.TWO_TOTE_HEIGHT));
		
		elevatorPos4 = new JoystickButton(joysticks[config.CUSTOM_CONTROL], 2);
		elevatorPos4.whenPressed(new ElevatorMoveBangBang(Robot.elevator.PLATFORM_HEIGHT));
		
		elevatorPos5 = new JoystickButton(joysticks[config.CUSTOM_CONTROL], 1);
		elevatorPos5.whenPressed(new ElevatorMoveBangBang(Robot.elevator.COOPERTITION_HEIGHT));
		
		
		System.out.println("OI init ended");
	}
	
	public boolean isElevatorThrottleSlow() {
		return elevatorSpeedDown.get();
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
		return -joysticks[this.OPERATOR_JOYSTICK].getAxis(Joystick.AxisType.kY);
	}
	
	
}//end class

