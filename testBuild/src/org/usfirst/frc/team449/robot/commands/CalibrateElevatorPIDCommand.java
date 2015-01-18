package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;
import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CalibrateElevatorPIDCommand extends Command {

	private double maxVal;
	
	private int state;
	
	public static final int GOING_TO_BOTTOM = 0;
	public static final int GOING_TO_TOP = 1;
	public static final int GOING_TO_HALF = 2;
	public static final int FINISHED = 3;
	
	public static final double speed = 0.2;
	
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
    		else Robot.elevator.setMotor(speed);
    	}
    	if (state == GOING_TO_TOP) {
    		if (Robot.elevator.isTouchingTop()) {
    			state = GOING_TO_HALF;
    			maxVal = Robot.elevator.getPIDMotor().getEncoder().getDistance();
    			return;
    		}
    		Robot.elevator.setMotor(-speed);
    	}
    	if (state == GOING_TO_HALF) {
    		if (Robot.elevator.getPIDMotor().getEncoder().getDistance() <= maxVal/2) {
    			state = FINISHED;
    			Robot.elevator.setMotor(-speed);
    			System.out.println("finished");
    			//Robot.elevator.setMotor(0);
    			return;
    		}
    		SmartDashboard.putNumber("maxVal", maxVal);
        	Robot.elevator.setMotor(speed);
    	}
    	System.out.println("in execute, state: "+state+", motor: "+Robot.elevator.getMotorVal());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return state == FINISHED;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.maxInput = maxVal;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
