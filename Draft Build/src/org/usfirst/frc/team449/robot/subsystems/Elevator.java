package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;
import org.usfirst.frc.team449.robot.commands.ElevatorMoveDefault;

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
	
	private final DoubleSolenoid brakeController;
	
	private final PIDMotor motors;
	
	// Elevator conceptual fields
	private double setPoint;
	private double position;
	private boolean controlState;
	
	public static final boolean MANUAL  = true;
	public static final boolean PID		= false;
	
	public static final boolean UP = true;
	public static final boolean DOWN = false;
	
	public static final double ELEVATOR_FIRST_POSITION = 0;
	public static final double ELEVATOR_SECOND_POSITION = 0.5;
	public static final double ELEVATOR_THIRD_POSITION = 1;
	
	/**
	 * Elevator constructor
	 */
	public Elevator(RobotMap config) {
		System.out.println("Elevator init started");
		
		topLimit 		= new DigitalInput(config.ELEVATOR_TOP_LIMIT);
		bottomLimit 	= new DigitalInput(config.ELEVATOR_BOTTOM_LIMIT);
		
		brakeController = new DoubleSolenoid(config.ELEVATOR_BRAKE_SOLENOID_FWD, config.ELEVATOR_BRAKE_SOLENOID_REV);
		
		
		//initialize temporary variables to pass into the PID motor
		TalonSRX 	leftMotor   = new TalonSRX(config.ELEVATOR_LEFT_MOTOR);
		TalonSRX 	rightMotor  = new TalonSRX(config.ELEVATOR_RIGHT_MOTOR);
		Encoder encoder 	= new Encoder(config.ELEVATOR_ENCODER_CHANNEL_A, config.ELEVATOR_ENCODER_CHANNEL_B, false, EncodingType.k4X);
		
		//this PIDMotor should be operating in Position based control mode for elevator position
		motors = new PIDMotor(config, config.ELEVATOR_P, config.ELEVATOR_I, config.ELEVATOR_D, 0, config.ELEVATOR_PID_TOLERANCE_RANGE, leftMotor, encoder, PIDMotor.POSITION_BASE);
		motors.addSlave(rightMotor,true);
		
		this.controlState = MANUAL;
		
		setPoint = 0;
		position = ELEVATOR_FIRST_POSITION;
		
		encoder.reset();
		System.out.println("Elevator Initialized");
		
	}//end Elevator();

	//============================Elevator Primary Methods=======================

    public void initDefaultCommand() {
    	
    	this.setDefaultCommand(new ElevatorMoveDefault());
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
    	motors.resetEncoder();
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
     * Returns whether the limit switch at the top of the elevator is being pressed
     * @return see description
     */
    public boolean isTouchingTop() {
    	return !topLimit.get();			//wiring is reversed
    }
    
    /**
     * Returns whether the limit switch at the bottom of the elevator is being pressed
     * @return see description
     */
    public boolean isTouchingBottom() {
    	return !bottomLimit.get();			//wiring is reversed
    }

    
    /**
     * Returns whether elevator control state is in PID mode
     * @return true if control state is PID, false otherwise 
     */
    public boolean isPIDEnabled() {
    	return controlState == PID;
    }
    
    /**
     * Enables PID mode on the elevator
     */
    public void enablePID() {
    	motors.enable();
    	controlState = PID;
    }
    
    /**
     * Disables the PID mode on the elevator and enables manual mode
     */
    public void disablePID() {
    	motors.disable(); // doesn't actually disable motor, only disables PID control
    	controlState = MANUAL;
    }
    
    /**
     * Manually sets the motor output provided that the elevator is in manual mode
     * @author hazheng 2/1/15
     * @param throttle
     */
    public void setMotorManual(double throttle){
    	if (controlState)
    		this.motors.setMotorVoltage(throttle);
    }

    /**
     * @return true if the error is within the percentage of the total input range, determined by setTolerance in the elevator's motors.
     */
	public boolean isAtSetPoint() {
		return this.motors.onTarget();
	}
	
	/**
	 * @return the encoder count
	 */
	public double getEncoderReading()
	{
		return this.motors.getEncoderCount();
	}
}//end class

