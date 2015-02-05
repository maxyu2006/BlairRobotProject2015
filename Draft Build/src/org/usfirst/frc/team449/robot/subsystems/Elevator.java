package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TalonSRX;
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
	
	private final DoubleSolenoid armController; //one solenoid connected to both arms
	private final DoubleSolenoid brakeController;
	
	private final PIDMotor motors;
	
	// Elevator conceptual fields
	private double setPoint;
	private double position;
	private boolean isArmOpen;
	private boolean isManual;
	
	public static final boolean UP = true;
	public static final boolean DOWN = false;
	
	public static final double ELEVATOR_FIRST_POSITION = 0;
	public static final double ELEVATOR_SECOND_POSITION = 0.5;
	public static final double ELEVATOR_THIRD_POSITION = 1;
	
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
		TalonSRX 	leftMotor   = new TalonSRX(config.ELEVATOR_LEFT_MOTOR);
		TalonSRX 	rightMotor  = new TalonSRX(config.ELEVATOR_RIGHT_MOTOR);
		Encoder encoder 	= new Encoder(config.ELEVATOR_ENCODER_CHANNEL_A, config.ELEVATOR_ENCODER_CHANNEL_B, false, EncodingType.k4X);
		
		//this PIDMotor should be operating in Position based control mode for elevator position
		motors = new PIDMotor(config, config.ELEVATOR_P, config.ELEVATOR_I, config.ELEVATOR_D, 0, leftMotor, encoder, PIDMotor.POSITION_BASE);
		motors.addSlave(rightMotor,true);
		
		
		setPoint = 0;
		isArmOpen = true;
		position = ELEVATOR_FIRST_POSITION;
	}//end Elevator();

	//============================Elevator Primary Methods=======================

    public void initDefaultCommand() {
    }
    
    /**
     * @deprecated
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
     * Opens the arms on the grabber
     */
    public void openArms(){
    	armController.set(Value.kForward);
    	isArmOpen = true;
    }
    
    /**
     * Closes the arms on the grabber
     */
    public void closeArms(){
		armController.set(Value.kReverse);
		isArmOpen = false;
    }
    
    /**
     * Releases the brakes on the elevator
     */
    public void releaseBrake(){
    	brakeController.set(Value.kReverse);
    }
    
    /**
     * Activates the brakes on the elevator
     */
    public void activateBrake(){
    	brakeController.set(Value.kForward);
    	
    }
    
    /**
     * Resets the encoder value to 0.
     */
    public void resetEncoder(){
    	motors.getEncoder().reset();
    }
    
    //============================Elevator Field Getters and Setters=======================
    
    /**
     * Returns the setPoint of the elevator, regardless of whether PID mode is enabled.
     * @return setPoint - a double ranging from 0 to 1, 0 being the bottom of the elevator.
     */
    public double getSetPoint(){
    	setPoint = motors.getSetpoint();
    	return setPoint;
    }
    
    /**
     * Sets the position for the elevator to move to via PID. If PID is disabled, this will not physically do
     * anything, but the set point will be kept for when the PID is re-enabled. 
     * @param setPoint - a double from 0 to 1, where 0 represents the bottom of the elevator.
     */
    public void setSetPoint(double setPoint){
    	this.setPoint = setPoint;
    	motors.setSetpoint(setPoint);
    }
    
    /**
     * Returns the actual position of the elevator as specified by the encoder.
     * @return the "position" of the elevator as a double from 0 to 1, 0 being the bottom of the elevator.
     */
    public double getActualPosition(){
    	return motors.getPosition();
    }
    
    /**
     * Sets the conceptual position of the elevator to the bottom. Only to be used in the ResetElevator
     * command after the carriage is manually driven back to the bottom of the elevator.
     */
    public void resetPosition() {
    	position = ELEVATOR_FIRST_POSITION;
    }
    
    /**
     * Sets the set point of the elevator to be the position directly above where the carriage is currently.
     */
    public void raisePosition() {
    	if (position < ELEVATOR_THIRD_POSITION) {
    		position += 0.5;
    		setSetPoint(position);
    	}
    }
    
    /**
     * Sets the set point of the elevator to be the position directly below where the carriage is currently.
     */
    public void lowerPosition() {
    	if (position > ELEVATOR_FIRST_POSITION) {
    		position -= 0.5;
    		setSetPoint(position);
    	}
    }
    
    /**   
     * Get the conceptual position of the elevator
     * @return position - one of the elevator constants ELEVATOR_FIRST/SECOND/THIRD_POSITION,
     *  first being bottom
     */
    public double getPosition(){
		return position;
    }
    
    /**
     * Returns true if arms are open, false otherwise.
     * @return isArmOpen - whether the arms are open
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
    
    /**
     * Returns whether elevator control state is in PID mode
     * @return true if control state is PID, false otherwise 
     */
    public boolean isPIDEnabled() {
    	return isManual = false;
    }
    
    /**
     * Enables PID mode on the elevator
     */
    public void enablePID() {
    	motors.enable();
    	isManual = false;
    }
    
    /**
     * Disables the PID mode on the elevator and enables manual mode
     */
    public void disablePID() {
    	motors.disable(); // doesn't actually disable motor, only disables PID control
    	isManual = true;
    }
    
    /**
     * Manually sets the motor output provided that the elevator is in manual mode
     * @author hazheng 2/1/15
     * @param throttle
     */
    public void setMotorManual(double throttle){
    	if (isManual)
    		this.motors.setMotorVoltage(throttle);
    }
}
