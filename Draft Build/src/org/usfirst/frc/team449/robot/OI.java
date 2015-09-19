package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.commands.AlignerSetArms;
import org.usfirst.frc.team449.robot.commands.ArmSetGrabber;
import org.usfirst.frc.team449.robot.commands.ElevatorEstop;
import org.usfirst.frc.team449.robot.commands.ElevatorMoveOne;
import org.usfirst.frc.team449.robot.commands.ElevatorMoveTwo;
import org.usfirst.frc.team449.robot.commands.ElevatorReset;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public final Joystick operatorJoystick, customControlJoystick, driveLeftJoystick, driveRightJoystick;
	
	public double DRIVE_SENSITIVITY_FAST;
	public double DRIVE_SENSITIVITY_SLOW;
	
	public final JoystickButton elevatorArmOpen;
	public final JoystickButton elevatorArmClose;
	public final JoystickButton elevatorResetButton;
	public final JoystickButton elevatorSpeedDown;
	public final JoystickButton alignerArmsClose;
	public final JoystickButton alignerArmsOpen;
	public final JoystickButton elevatorPos1;
	public final JoystickButton elevatorPos2;
	public final JoystickButton elevatorPos3;
//	public final JoystickButton elevatorPos4;
//	public final JoystickButton elevatorPos5;
	public final JoystickButton elevatorEstop;
	
	public OI()
	{
		System.out.println("OI init started");
		driveLeftJoystick = new Joystick(RobotMap.DRIVE_LEFT_JOYSTICK);
		driveRightJoystick = new Joystick(RobotMap.DRIVE_RIGHT_JOYSTICK);
		operatorJoystick = new Joystick(RobotMap.OPERATOR_JOYSTICK);
		customControlJoystick = new Joystick(RobotMap.CUSTOM_CONTROL);
		
		elevatorArmOpen = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_ARMS_OPEN_BUTTON);
		elevatorArmOpen.whenPressed(new ArmSetGrabber(ArmSetGrabber.OPEN));
		elevatorArmClose = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_ARMS_CLOSE_BUTTON);
		elevatorArmClose.whenPressed(new ArmSetGrabber(ArmSetGrabber.CLOSE));
		elevatorResetButton = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_RESET_BUTTON);
		elevatorResetButton.whenPressed(new ElevatorReset());
		elevatorSpeedDown = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_SLOW_BUTTON);
		
		alignerArmsClose = new JoystickButton(operatorJoystick, RobotMap.ALIGNER_ARMS_CLOSE);
		alignerArmsClose.whenPressed(new AlignerSetArms(AlignerSetArms.CLOSE));
		alignerArmsOpen = new JoystickButton(operatorJoystick, RobotMap.ALIGNER_ARMS_OPEN);
		alignerArmsOpen.whenPressed(new AlignerSetArms(AlignerSetArms.OPEN));
		
		// TEST THESE
		elevatorPos1 = new JoystickButton(customControlJoystick, 9);
		elevatorPos1.whenPressed(new ElevatorReset());
		
		elevatorPos2 = new JoystickButton(customControlJoystick, 4);
		elevatorPos2.whenPressed(new ElevatorMoveOne());
		
		elevatorPos3 = new JoystickButton(customControlJoystick, 3);
		elevatorPos3.whenPressed(new ElevatorMoveTwo());
		
//		elevatorPos4 = new JoystickButton(customControlJoystick, 2);
//		elevatorPos4.whenPressed(new ElevatorMoveBangBang(Robot.elevator.PLATFORM_HEIGHT));
//		
//		elevatorPos5 = new JoystickButton(customControlJoystick, 1);
//		elevatorPos5.whenPressed(new ElevatorMoveBangBang(Robot.elevator.COOPERTITION_HEIGHT));
		
		elevatorEstop = new JoystickButton(customControlJoystick, 1);
		elevatorEstop.whenPressed(new ElevatorEstop());
		
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
		if(isDriveSlowMode())
			return -DRIVE_SENSITIVITY_SLOW*driveLeftJoystick.getAxis(Joystick.AxisType.kY);
		return -DRIVE_SENSITIVITY_FAST*driveLeftJoystick.getAxis(Joystick.AxisType.kY);
	}
	
	/**
	 * get the axis assigned to the right side of the drive
	 * @return a double between -1 and 1
	 */
	public double getDriveAxisRight()
	{
		//inverted due to joystick direction
		if(isDriveSlowMode())
			return -DRIVE_SENSITIVITY_SLOW*driveRightJoystick.getAxis(Joystick.AxisType.kY);
		return -DRIVE_SENSITIVITY_FAST*driveRightJoystick.getAxis(Joystick.AxisType.kY);
	}
	
	/**
	 * sees if the drivers are requesting drive staright mode
	 * @return
	 */
	public boolean isDriveStraightMode()
	{
		return (driveRightJoystick.getTrigger());
	}
	
	/**
	 * sees if drives are requesting drive to be slow
	 * @return status of left drive joystick trigger
	 */
	public boolean isDriveSlowMode() {
		return (driveLeftJoystick.getTrigger());
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
		return -operatorJoystick.getAxis(Joystick.AxisType.kY);
	}
	
	
}//end class

