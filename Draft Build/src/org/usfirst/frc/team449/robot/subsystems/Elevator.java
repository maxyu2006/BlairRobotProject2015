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
	private final DigitalInput topLimit;
	private final DigitalInput bottomLimit;
	private final DigitalInput leftArmLimit;
	private final DigitalInput rightArmLimit;
	
	private final DoubleSolenoid armController;//one solenoidconnected toboth arms
	private final DoubleSolenoid brakeController;
	
	private final PIDMotor motors;
	
	// Elevator conceptual fields
	private double setPoint;
	private int position;
	private double actualPosition;
	private boolean isArmOpen;
	private boolean isBrakeActivated;
	private boolean isManual;
	
	public static final boolean UP = true;
	public static final boolean DOWN = false;
	public static final int ELEVATOR_FIRST_POSITION = 0;
	public static final int ELEVATOR_SECOND_POSITION = 1;
	public static final int ELEVATOR_THIRD_POSITION = 2;
	
	/**
	 * Elevator constructor
	 */
	public Elevator(RobotMap config) {
		topLimit 		= new DigitalInput(config.ELEVATOR_TOP_LIMIT);
		bottomLimit 	= new DigitalInput(config.ELEVATOR_BOTTOM_LIMIT);
		
		leftArmLimit 	= new DigitalInput(config.ELEVATOR_LEFT_LIMIT);
		rightArmLimit 	= new DigitalInput(config.ELEVATOR_RIGHT_LIMIT);
		
		armController  = new DoubleSolenoid(config.ELEVATOR_ARM_SOLENOID_FWD,config.ELEVATOR_ARM_SOLENOID_REV);
		
		brakeController = new DoubleSolenoid(config.ELEVATOR_BRAKE_SOLENOID_FWD, config.ELEVATOR_BRAKE_SOLENOID_REV);
		
		
		//initialize temporary variables to pass into the PID motor
		Victor 	leftMotor   = new Victor(config.INTAKE_LEFT_MOTOR);
		Victor 	rightMotor  = new Victor(config.INTAKE_RIGHT_MOTOR);
		Encoder encoder 	= new Encoder(config.ELEVATOR_ENCODER_CHANNEL_A, config.ELEVATOR_ENCODER_CHANNEL_B, false, EncodingType.k4X);
		
		//this PIDMotor should be operating in Position based control mode for elevator position
		motors = new PIDMotor(config, config.ELEVATOR_P, config.ELEVATOR_I, config.ELEVATOR_D, 0, leftMotor, encoder, PIDMotor.POSITION_BASE);
		motors.addSlave(rightMotor);
		
		
		setPoint = 0;
		position = 0;
		actualPosition = encoder.get();
		isArmOpen = true; 
		
		isBrakeActivated = false;
		isManual = false;
	}//end Elevator();

	//============================Elevator Primary Methods=======================

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Toggles the open/closed state of the arms.
     */
    public void toggleArms(){
    	if(isArmOpen){
    		armController.set(Value.kReverse);
    	}
    	else{
    		armController.set(Value.kForward);
    	}
    	isArmOpen=!isArmOpen;
    }
    /**
     * Open the arms
     */
    public void openArms(){
    	armController.set(Value.kForward);
    	isArmOpen = true;
    }
    /**
     * Close the arms
     */
    public void closeArms(){
		armController.set(Value.kReverse);
		isArmOpen = false;
    }
    /**
     * Releases the brake.
     */
    public void releaseBrake(){
    	brakeController.set(Value.kReverse);
    	
    }
    
    /**
     * Activates the brake.
     */
    public void activateBrake(){
    	brakeController.set(Value.kForward);
    	
    }
    
    /**
     * Sets the speed of the motor.
     * @param speed - The speed the motor is being set at.
     */
    public void setMotorSpeed(double speed){
    	motors.setSetpoint(speed);
    }
    
    /**
     * Resets the encoder value to 0.
     */
    public void resetEncoder(){
    	motors.getEncoder().reset();
    }
    
    //============================Elevator Field Getters and Setters=======================
    
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
     * Sets the position back to the bottom
     */
    public void resetPosition() {
    	position = ELEVATOR_FIRST_POSITION;
    }
    
    /**
     * Sets the conceptual position to be the position directly above where it is currently
     */
    public void raisePosition() {
    	if (position < ELEVATOR_THIRD_POSITION)
    		position++;
    }
    
    /**
     * Sets the conceptual position to be the position directly below where it is currently
     */
    public void lowerPosition() {
    	if (position > ELEVATOR_FIRST_POSITION)
    		position--;
    }
    
    /**   
     * Get the conceptual position of the elevator
     * @return position - ints from 0-2, where two is the highest position on the elevator
     */
    public int getPosition(){
		return position;
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
    
    public void enablePID() {
    	motors.enable();
    }
    
    public void disablePID() {
    	motors.disable();
    }
}
    
    
    

