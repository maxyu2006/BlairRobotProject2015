/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * motor subsystem with an embedded pid controller based on an encoder
 * @author Max Yu
 */
public class PIDMotor extends PIDSubsystem {

    private double Kp = 0.0;
    private double Ki = 0.0;
    private double Kd = 0.0;

    private final Talon 	motor;
    private final Encoder 	encoder;
    private final int		mode;
    
    public static final int DISTANCE_BASE 	= 0;
    public static final int SPEED_BASE		= 1;
    
    // Initialize your subsystem here
    /**
     * initialize the PIDMotor
     * @param name 	the name of the system
     * @param p		the proportional term
     * @param i		the integral term
     * @param d		the derivative term
     * @param initSet 	the initial setpoint
     * @param Motor		the motor to control
     * @param encoder	the encoder that is providing feedback 
     * @param mode		the mode at which the encoder will operate
     */
    public PIDMotor(String name, double p, double i, double d, double initSet, Talon motor, Encoder encoder, int mode) {
        super(name, p, i, d);
        
        //initialize the variables
        this.Kp = p;
        this.Ki = i;
        this.Kd = d;
        
        this.motor 		= motor;
        this.encoder 	= encoder;
        this.mode		= mode;
        
        //set the encoder DPP and reset the encoder
        encoder.setDistancePerPulse(1/RobotMap.encoderPPR);
        encoder.reset();
        
        //set PIDController constraints
        super.getPIDController().setOutputRange(-1, 1); //min max set to that for Jaguar.set
        
        this.setSetpoint(initSet);
        
        //check validity of mode, enable only if mode is valid
        if(mode < 0 || mode > 1)
        	System.err.println("you fucked up in setting mode for PIDMotor " + name);
        else
        	this.enable();
        
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
        switch(this.mode)
        {
        case DISTANCE_BASE:
        	return encoder.getDistance();
		case SPEED_BASE:
        	return encoder.getRate();
		default:
        	System.err.println("you fucked up again. I warned that you didn't set mode correctly.");
        	return 0;
        }//end switch
    }//
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        motor.set(output);
    }
    
    /**
     * sets the motor voltage scale (-1 to 1) depending on whether this subsystem 
     * is on manual or PID controlled mode. If it is on PID controlled mode, 
     * or the exceeds the range it will fail to.
     * @param volt the voltage the motor will be set to
     * @return true if successful, false if on PID controlled mode.
     */
    public boolean setMotorVoltage(double volt)
    {
        if(this.isEnabled() || volt > 1 || volt < -1)
            return false;
        
        motor.set(volt);
        
        return true;
    }
    
    /**
     * Sets the proportional term
     * @param newP the new P value
     */
    public void setKp(double newP)
    {  
        this.Kp = newP;
        super.getPIDController().setPID(this.Kp, this.Ki, this.Kd);
    }
   
     /**
     * Sets the integral term
     * @param newI the new I value
     */
    public void setKi(double newI)
    {   
        this.Ki = newI;
        super.getPIDController().setPID(this.Kp, this.Ki, this.Kd);
    }
    
     /**
      * Sets the derivative term 
      * @param newD the new D value
     */
    public void setKd(double newD)
    {    
        this.Kd = newD;
        super.getPIDController().setPID(this.Kp, this.Ki, this.Kd);
    }
        
    /**
     * 
     * @return
     */
    public boolean isEnabled()
    {
    	return this.getPIDController().isEnable();
    }
}//end class
