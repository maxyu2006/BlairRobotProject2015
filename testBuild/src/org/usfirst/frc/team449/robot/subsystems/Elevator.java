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
	private final DistanceMotorPID 	elevMotor;
	private final Talon 			elevMotorController;
	private final Encoder 			elevEncoder;
    
	public Elevator(){
		limitTop    = new DigitalInput(RobotMap.elevLimitTop);
		limitBottom = new DigitalInput(RobotMap.elevLimitBottom);
		this.elevMotorController = new Talon(RobotMap.talonPort);
		this.elevEncoder = new Encoder(RobotMap.enAChnl,RobotMap.enBChnl,true,CounterBase.EncodingType.k4X);
		elevMotor   = new DistanceMotorPID(elevMotorController, elevEncoder, RobotMap.minInput, RobotMap.maxInput);
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
    
    // Sets elevator setpoint.
    public void setSetPoint(double setpoint){
    	elevMotor.setSetpoint(setpoint);
    }
    
    // Gets elevator position.
    public double getPosition() {
    	return elevMotor.getPosition();
    }
    
    // Gets elevator setpoint.
    public double getSetpoint() {
    	return elevMotor.getSetpoint();
    }
}

