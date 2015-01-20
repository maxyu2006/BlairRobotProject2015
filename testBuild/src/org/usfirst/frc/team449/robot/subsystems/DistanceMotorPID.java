package org.usfirst.frc.team449.robot.subsystems;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase;
>>>>>>> origin/master
=======
import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase;
>>>>>>> origin/master
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * A class that represents a PID system for distance-based motor control.
 * requires a motor controller, and a quad encoder
 * @author Max Yu
 *
 * @param <T> the type of motor controller used
 */
public class DistanceMotorPID extends PIDSubsystem {

	private double Kp = 0.0;
    private double Ki = 0.0;
    private double Kd = 0.0;
	
	private final Talon 	motorController;
	private final Encoder 	encoder;
	
    /**
     * The DistanceMotorPID constructor.
     * 
     * @param motorController The type of motor on the elevator.
     * @param elevatorencoder 		  The type of encoder on the elevator.
     * @param minimumInput 	  The minimum expected input value from the encoder.
     * @param maximumInput    The maximum expected input value from the encoder.
     */
    public DistanceMotorPID(double minimumInput, double maximumInput) {
    	super(0.005, 0, 0); // super(Kp, Ki, Kd)
    	
    	this.motorController = new Talon(RobotMap.talonPort);
    	this.encoder 		 = new Encoder(RobotMap.enAChnl,RobotMap.enBChnl,false,CounterBase.EncodingType.k4X);
    	this.setInputRange(minimumInput, maximumInput);
    	this.setSetpoint((minimumInput+maximumInput) / 2);
    	this.setOutputRange(-0.2, 0.2);
    }
    
    public Encoder getEncoder() {
    	return this.encoder;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return encoder.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	motorController.set(-output);
    }
    
    /**
     * Sets the p element if the subsystem is not in PID controlled mode.
     * @param newP the new P value
     * @return true if successfully set the new value. False if failed and value did not change
     */
    public boolean setKp(double newP)
    {
        if(!this.isManual())
            return false;
        
        this.Kp = newP;
        super.getPIDController().setPID(this.Kp, this.Ki, this.Kd);
        
        return true;
    }
   
     /**
     * Sets the i element if the subsystem is not in PID controlled mode.
     * @param newI the new I value
     * @return true if successfully set the new value. False if failed and value did not change
     */
    public boolean setKi(double newI)
    {
        if(!this.isManual())
            return false;
        
        this.Ki = newI;
        super.getPIDController().setPID(this.Kp, this.Ki, this.Kd);
        
        return true;
    }
    
     /**
     * Sets the d element if the subsystem is not in PID controlled mode.
     * @param newD the new D value
     * @return true if successfully set the new value. False if failed and value did not change
     */
    public boolean setKd(double newD)
    {
        if(!this.isManual())
            return false;
        
        this.Kd = newD;
        super.getPIDController().setPID(this.Kp, this.Ki, this.Kd);
        
        return true;
    }
    
    /**
     * returns if this subsystem is running in manual mode or PID controlled mode
     * @return true if in manual mode, false if in PID controlled mode
     */
    public boolean isManual()
    {
        return !this.getPIDController().isEnable();
    }
    
    /**
     * DONT USE THIS METHOD. ONLY SUPPOSED TO BE USED IN "CalibrateElevatorPIDCommand.java"
     * @param speed -1 to 1
     */
    public void setMotor(double throttle) {
    	if (this.isManual())
    		motorController.set(throttle);
    }
    
    /**
     * Get last throttle set to the elevator motor
     * @return throttle setting
     */
    public double getMotorVal() {
    	return motorController.get();
    }
}
