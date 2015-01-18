package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Elevator subsystem class.
 */
public class Elevator extends Subsystem {
	 
	private final DigitalInput 		limitTop;
	private final DigitalInput 		limitBottom;
	private final PIDMotor 	elevMotor;
    
	public Elevator(){
		limitTop    			 = new DigitalInput(RobotMap.elevLimitTop);
		limitBottom 			 = new DigitalInput(RobotMap.elevLimitBottom);
		elevMotor   			 = new PIDMotor(getName(), 0.005, 0, 0, RobotMap.maxInput/2,
				new Talon(RobotMap.talonPort), 
				new Encoder(RobotMap.enAChnl,RobotMap.enBChnl,false,CounterBase.EncodingType.k4X),
				PIDMotor.DISTANCE_BASE);
	}

    public void initDefaultCommand() {
    }
    
    // Returns 1 if elevator is touching top limit switch, 0 otherwise.
    public boolean isTouchingTop(){
    	return limitTop.get();
    }
    

    // Returns 1 if elevator is touching bottom limit switch, 0 otherwise.
    public boolean isTouchingBottom(){
    	return limitBottom.get();
    }
    
    /**
     * Sets the setpoint of the PID motor on the elevator
     * TODO units of measure (e.g. feet/inches/etc.)
     * @param setpoint setpoint of the motor
     */
    public void setSetPoint(double setpoint){
    	elevMotor.setSetpoint(setpoint);
    }
    
    /**
     * copy above javadoc
     * @return
     */
    public double getPosition() {
    	return elevMotor.getPosition();
    }
    
    // Gets elevator setpoint. TODO
    public double getSetpoint() {
    	return elevMotor.getSetpoint();
    }
    
    public PIDMotor getPIDMotor()
    {
    	return this.elevMotor;
    }
    
    public void enable() {
    	elevMotor.enable();
    }
    
}

