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
	
	private double bottomPosition;
	private double topPosition;
	
	private int controlState;
	
	public static final int MANUAL  	= 0;
	public static final int PID			= 1;
	
	public static final boolean UP = true;
	public static final boolean DOWN = false;
	
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
		Encoder encoder 	= new Encoder(config.ELEVATOR_ENCODER_CHANNEL_A, config.ELEVATOR_ENCODER_CHANNEL_B, true, EncodingType.k4X);
		
		encoder.setDistancePerPulse(config.ELEVATOR_SPROCKET_CIRCUMFERENCE/config.ELEVATOR_ENCODER_CPR);
		
		//this PIDMotor should be operating in Position based control mode for elevator position
		motors = new PIDMotor(config, config.ELEVATOR_P, config.ELEVATOR_I, config.ELEVATOR_D, 0, config.ELEVATOR_PID_TOLERANCE_RANGE, leftMotor, encoder, PIDMotor.POSITION_BASE);
		motors.addSlave(rightMotor,true);
		motors.setDistancePerPulse(config.ELEVATOR_SPROCKET_CIRCUMFERENCE/config.ELEVATOR_ENCODER_CPR);
		
		this.controlState = MANUAL;
		
		setPoint = 0;
		
		encoder.reset();
		topPosition = config.ELEVATOR_INITIAL_TOP_COUNT;
		System.out.println("Elevator init finished");
		
		
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
     * @return setPoint - a double representing the position of the elevator in inches
     */
    public double getSetPoint(){
    	setPoint = motors.getSetpoint();
    	return setPoint;
    }
    
    /**
     * Sets the position for the elevator to move to via PID. If PID is disabled, this will not physically do
     * anything, but the set point will be kept for when the PID is re-enabled. 
     * @param setPoint - a double representing the position of the elevator in inches
     */
    public void setSetPoint(double setPoint){
    	this.setPoint = setPoint;
    	motors.setSetpoint(setPoint);
    }
    
    public void setBBSetpoint(double setPoint) {
    	this.setPoint = setPoint;
    }
    
    /**
     * Returns the normalized position of the elevator as specified by the encoder.
     * @return the "position" of the elevator as a double from 0 to 1, 0 being the bottom of the elevator.
     */
    public double getNormalizedPosition(){
    	return (motors.getEncoderPosition()-bottomPosition)/(topPosition-bottomPosition);
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
    	if (controlState == MANUAL)
    		this.motors.setMotorVoltage(throttle);
    	
    	//System.out.println("setting motorThrottle");
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

	/**
	 * @return the encoder position with units
	 */
	public double getEncoderPosition()
	{
		return this.motors.getEncoderPosition();
	}
	
	/**
	 * @return the value of the encoder when it hits the bottom
	 */
	public double getBottomPosition() {
		return bottomPosition;
	}

	/**
	 * @param bottomCount set the position of the encoder when it hits the bottom
	 */
	public void setBottomPosition(double bottomPosition) {
		this.bottomPosition = bottomPosition;
	}

	public double getTopPosition() {
		return topPosition;
	}

	public void setTopPosition(double topPosition) {
		this.topPosition = topPosition;
	}
}//end class

