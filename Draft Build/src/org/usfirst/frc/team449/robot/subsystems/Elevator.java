package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Elevator subsystem.
 */
public class Elevator extends Subsystem {

	// Elevator hardware fields
	private DigitalInput topLimit, bottomLimit;
	private DigitalInput leftArmLimit, rightArmLimit;
	private DoubleSolenoid leftSol, rightSol;
	private Victor[] motors = new Victor[2];
	private Encoder encoder;
	
	// Elevator conceptual fields
	private double setPoint;
	private double actualPosition;
	private boolean isArmOpen;
	private boolean[] limitSwitchStates = new boolean[4];
	private boolean isBrakeActivated;
	private boolean isManual;
	
	/**
	 * Elevator constructor
	 */
	public Elevator() {
		topLimit = new DigitalInput(RobotMap.elevTopLmChnl);
		bottomLimit = new DigitalInput(RobotMap.elevBotLmChnl);
		leftArmLimit = new DigitalInput(RobotMap.elevLeftLmChnl);
		rightArmLimit = new DigitalInput(RobotMap.elevRightLmChnl);
		leftSol = new DoubleSolenoid(RobotMap.elevLeftSolChnls[0],RobotMap.elevLeftSolChnls[1]);
		rightSol = new DoubleSolenoid(RobotMap.elevRightSolChnls[0],RobotMap.elevRightSolChnls[1]);
		motors[0] = new Victor(RobotMap.elevMotorChnls[0]);
		motors[1] = new Victor(RobotMap.elevMotorChnls[1]);
		encoder = new Encoder(RobotMap.elevEncoderAChnl, RobotMap.elevEncoderBChnl, false, EncodingType.k4X);
		
		//TODO find actual distancePerPulse
		encoder.setDistancePerPulse(1);
		encoder.reset();
		
		setPoint = 0;
		actualPosition = encoder.get();
		isArmOpen = true; 
	
		limitSwitchStates[0] = topLimit.get();
		limitSwitchStates[1] = bottomLimit.get();
		limitSwitchStates[2] = leftArmLimit.get();
		limitSwitchStates[3] = rightArmLimit.get();
		
		isBrakeActivated = false;
		isManual = false;

	}

	/**
	 * Elevator primary methods
	 */

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Toggles the open/closed state of the arms.
     */
    public void toggleArms(){
    	
    }
    
    /**
     * Releases the brake.
     */
    public void releaseBrake(){
    	
    }
    
    /**
     * Activates the brake.
     */
    public void activateBrake(){
    	
    }
    
    /**
     * Sets the speed of the motor.
     * @param speed - The speed the motor is being set at.
     */
    public void setMotorSpeed(double speed){
    	
    }
    
    /**
     * Resets the encoder value to 0.
     */
    public void resetEncoder(){
    	
    }
    
    /**
     * Elevator field getters and setters
     */
    
    /**
     * Returns the setPoint.
     * @return setPoint - The setPoint.
     */
    public double getSetPoint(){
    	return setPoint;
    }
    
    /**
     * Sets position for elevator to move to.
     * @param setPoint - Intended setPoint.
     */
    public void setSetPoint(double setPoint){
    	this.setPoint = setPoint;
    }
    
    /**
     * Returns the actual position of the elevator.
     * @return actualPosition - The actual position of the elevator.
     */
    public double getActualPosition(){
    	return actualPosition;
    }
    
    /**
     * Returns true if arm is open, false otherwise.
     * @return isArmOpen - Is arm open?
     */
    public boolean getArmState(){
    	return isArmOpen;
    }
    
    //TODO getLimitSwitchStates()
	}
    
    
    

