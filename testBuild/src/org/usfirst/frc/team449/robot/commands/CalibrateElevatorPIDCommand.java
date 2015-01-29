package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CalibrateElevatorPIDCommand extends Command {

	private double maxPosition;
	
	private int state;
	
	public static final int GOING_TO_BOTTOM = 0;
	public static final int GOING_TO_TOP = 1;
	public static final int GOING_TO_HALF = 2;
	public static final int FINISHED = 3;
	
	public static final double throttle = 0.2;
	
    public CalibrateElevatorPIDCommand() {
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	state = GOING_TO_BOTTOM;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (state == GOING_TO_BOTTOM) {
    		if (Robot.elevator.isTouchingBottom()) {
    			state = GOING_TO_TOP;
    			Robot.elevator.getPIDMotor().getEncoder().reset();
    			return;
    		}
    		else Robot.elevator.getPIDMotor().setMotorVoltage(throttle);
    	}
    	if (state == GOING_TO_TOP) {
    		if (Robot.elevator.isTouchingTop()) {
    			state = GOING_TO_HALF;
    			maxPosition = Robot.elevator.getPIDMotor().getEncoder().getDistance();
    			return;
    		}
    		Robot.elevator.getPIDMotor().setMotorVoltage(-throttle);
    	}
    	if (state == GOING_TO_HALF) {
    		if (Robot.elevator.getPIDMotor().getEncoder().getDistance() <= maxPosition/2) {
    			state = FINISHED;
    			Robot.elevator.getPIDMotor().setMotorVoltage(0);
    			System.out.println("finished");
    			//Robot.elevator.getPIDMotor().setMotor(0);
    			return;
    		}
    		SmartDashboard.putNumber("maxVal", maxPosition);
        	Robot.elevator.getPIDMotor().setMotorVoltage(throttle);
    	}
    	System.out.println("in execute, state: "+state+", motor: "+Robot.elevator.getPIDMotor().getMotorVal());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return state == FINISHED;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// NOTE: extremely bad practice to modify RobotMap values - mayu & hazheng
    	RobotMap.maxInput = maxPosition;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
