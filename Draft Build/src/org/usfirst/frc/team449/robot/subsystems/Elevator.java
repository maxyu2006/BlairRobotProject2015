package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
	private DoubleSolenoid brakeSol;
	private Victor leftMotor, rightMotor;
	private Encoder encoder;
	
	// Elevator conceptual fields
	private double setPoint;
	private double actualPosition;
	private boolean isArmOpen;
	private boolean isBrakeActivated;
	private boolean isManual;
	
	/**
	 * Elevator constructor
	 */
	public Elevator(RobotMap config) {
		topLimit 		= new DigitalInput(config.elevTopLmChnl);
		bottomLimit 	= new DigitalInput(config.elevBotLmChnl);
		leftArmLimit 	= new DigitalInput(config.elevLeftLmChnl);
		rightArmLimit 	= new DigitalInput(config.elevRightLmChnl);
		
		leftSol  = new DoubleSolenoid(config.elevLeftSolChnls[0],config.elevLeftSolChnls[1]);
		rightSol = new DoubleSolenoid(config.ELEVATOR_RIGHT_SOLENOIDS[0],config.ELEVATOR_RIGHT_SOLENOIDS[1]);
		
		brakeSol = new DoubleSolenoid(config.ELEVATOR_BRAKE_SOLENOIDS[0], config.ELEVATOR_BRAKE_SOLENOIDS[1]);
		
		leftMotor   = new Victor(config.elevLeftMotorChnl);
		rightMotor  = new Victor(config.elevRightMotorChnl);
		
		encoder = new Encoder(config.ELEVATOR_ENCODER_A, config.elevEncoderBChnl, false, EncodingType.k4X);
		
		//TODO find actual distancePerPulse
		encoder.setDistancePerPulse(1);
		encoder.reset();
		
		setPoint = 0;
		actualPosition = encoder.get();
		isArmOpen = true; 
		
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
    	if(isArmOpen){
    		leftSol.set(Value.kReverse);
    		rightSol.set(Value.kReverse);
    	}
    	else{
    		leftSol.set(Value.kForward);
    		rightSol.set(Value.kForward);
    	}
    }
    
    /**
     * Releases the brake.
     */
    public void releaseBrake(){
    	brakeSol.set(Value.kReverse);
    }
    
    /**
     * Activates the brake.
     */
    public void activateBrake(){
    	brakeSol.set(Value.kForward);
    }
    
    /**
     * Sets the speed of the motor.
     * @param speed - The speed the motor is being set at.
     */
    public void setMotorSpeed(double speed){
    	leftMotor.set(speed);
    	rightMotor.set(speed);
    }
    
    /**
     * Resets the encoder value to 0.
     */
    public void resetEncoder(){
    	encoder.reset();
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
    
    /**
     * Returns whether the limit switch at the top of the elevator is being pressed
     * @return see description
     */
    public boolean isTouchingTop() {
    	return topLimit.get();
    }
    
    /**
     * Returns whether the limit switch at the bottom of the elevator is being pressed
     * @return see description
     */
    public boolean isTouchingBottom() {
    	return bottomLimit.get();
    }
    
    /**
     * Returns whether the limit switch on the left arm is being pressed
     * @return see description
     */
    public boolean isTouchingLeftArm() {
    	return leftArmLimit.get();
    }
    
    /**
     * Returns whether the limit switch on the right arm is being pressed
     * @return see description
     */
    public boolean isTouchingRightArm() {
    	return rightArmLimit.get();
    }
}
    
    
    

