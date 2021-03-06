package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command acts as a "re-calibrator" for the encoder on the elevator.
 * It drives the carriage down (in manual mode on 15%) until the bottom limit switch is pressed.
 * Additionally, it will also end if the command has taken longer than 2 seconds to complete
 * (in the case that the limit switch isn't working).
 * When the command finishes, the encoder will be reset back to 0.
 * @author eyob-- AliAnwar7477 1/31/15
 */
public class ElevatorReset extends Command {
	
	private Timer t;	// timer to keep track of how long the command has been running

    public ElevatorReset() {
        requires(Robot.elevator);
        t = new Timer();
    }

    protected void initialize() {
    	Robot.elevator.releaseBrake();
    	Robot.elevator.disablePID();			// switch to manual mode (turn PID off)
    	Robot.elevator.setMotorManual(0.3);	// drive back at a constant 15%
    	t.start();								// start the runtime timer
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	// stop if you hit the limit switch or it has taken longer than 3 seconds
        return Robot.elevator.isTouchingBottom() || t.get() > 5;
    }

    protected void end() {
    	Robot.elevator.setMotorManual(0);
    	Robot.elevator.disablePID();	// just make sure PID is disabled at the end.
    	Robot.elevator.activateBrake();
    	Robot.elevator.resetEncoder();
    	Robot.elevator.setBottomPosition(Robot.elevator.getEncoderPosition());
    	System.out.println("Elevator Reset");
    }

    protected void interrupted() {
    }
    
    public boolean isInterruptible()
    {
    	return true;//false;
    }
}
