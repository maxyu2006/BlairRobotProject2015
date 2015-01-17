package org.usfirst.frc.team449.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * A class that represents a PID system for distance-based motor control.
 * requires a motor controller, and a quad encoder
 * @author Max Yu
 *
 * @param <T> the type of motor controller used
 */
public class DistanceMotorPID<T> extends PIDSubsystem {

	private final T 		motorController;
	private final Encoder 	encoder;
	
    // Initialize your subsystem here
    public DistanceMotorPID(T motorController) {
    	super(0, 0, 0);
    	
    	this.motorController = motorController;
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
