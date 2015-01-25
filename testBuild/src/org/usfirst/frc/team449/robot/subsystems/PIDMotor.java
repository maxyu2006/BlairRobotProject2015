/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team449.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * motor subsystem with an embedded pid controller based on an encoder
 * @author Max Yu
 */
public class PIDMotor extends PIDSubsystem {

    private double 	Kp 		= 0.0;
    private double 	Ki 		= 0.0;
    private double 	Kd 		= 0.0;
    private int		mode;
    
    
    private final SpeedController 	motor;
    private final Encoder 			encoder;
    private final ArrayList<SpeedController> slaves;	//additional motor controllers slaved to this PID controller
    
    public static final int DISTANCE_BASE 	= 0;
    public static final int SPEED_BASE		= 1;
    public static final int POSITION_BASE	= 2;
    
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
    public PIDMotor(double p, double i, double d, double initSet, SpeedController motor, Encoder encoder, int mode) {
        super(p, i, d);
        
        //initialize the variables
        this.Kp = p;
        this.Ki = i;
        this.Kd = d;
        
        this.motor 		= motor;
        this.encoder 	= encoder;
        this.mode		= mode;
        
        //set the encoder DPP and reset the encoder
        encoder.setDistancePerPulse(1.0/RobotMap.encoderPPR);
        encoder.reset();
        
        //set PIDController constraints
        super.getPIDController().setOutputRange(-1, 1); //min max set to that for Jaguar.set
        
        this.setSetpoint(initSet);
        
        //check validity of mode, enable only if mode is valid
        if(mode < 0 || mode > 2)
        	System.err.println("you fucked up in setting mode for PIDMotor");
        else
        	this.mode = mode;
        
        slaves = new ArrayList<SpeedController>();
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
        System.out.println("Trying to return pidInput");
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
        
        for(int i=0; i < slaves.size(); i++)
        {
        	slaves.get(i).set(output);
        	System.out.println("setting throttle " + output);
        }
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
        for(int i=0; i < slaves.size(); i++)
        {
        	System.out.println("setting throttle " + volt);
        	slaves.get(i).set(volt);
        }
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
    
    /**
     * 
     * @param controller
     */
    public void addSlave(SpeedController controller)
    {
    	slaves.add(controller);
    }
    
    /**
     * measures the rate of the encoder
     * @return the rate of the encoder as ticks per second
     */
    public double measureSpeed()
    {
    	return this.encoder.getRate();
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
    		motor.set(throttle);
    }
    
    /**
     * Get last throttle set to the elevator motor
     * @return throttle setting
     */
    public double getMotorVal() {
    	return motor.get();
    }

	public Encoder getEncoder() {
		return encoder;
	}
}//end class
