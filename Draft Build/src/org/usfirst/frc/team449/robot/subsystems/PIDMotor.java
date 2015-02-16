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
    
    private double distancePerPulse = 1;
    
    private final SpeedController 	motor;
    private final Encoder 			encoder;
    private final ArrayList<SpeedController> slaves; //additional motor controllers slaved to this PID controller
    private final ArrayList<Boolean> slave_invert_flags; //add option to invert motor input
    
    public static final int DISTANCE_BASE 	= 0;
    public static final int SPEED_BASE		= 1;
    public static final int POSITION_BASE	= 2;
    
    // Initialize your subsystem here
    /**
     * initialize the PIDMotor
     * @param config the RobotMap object with all constants
     * @param p		the proportional term
     * @param i		the integral term
     * @param d		the derivative term
     * @param initSet 	the initial setpoint
     * @param tolerance the error tolerance for PID control
     * @param Motor		the motor to control
     * @param encoder	the encoder that is providing feedback 
     * @param mode		the mode at which the encoder will operate
     */
    public PIDMotor(RobotMap config, double p, double i, double d, double initSet, double tolerance, SpeedController motor, Encoder encoder, int mode) {
        super(p, i, d);
        
        //initialize the variables
        this.Kp = p;
        this.Ki = i;
        this.Kd = d;
        
        this.motor 		= motor;
        this.encoder 	= encoder;
        this.mode		= mode;
        
        //sets PID tolerance
        this.setAbsoluteTolerance(tolerance);
        
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
        slave_invert_flags = new ArrayList<Boolean>();
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
        switch(this.mode)
        {
        case DISTANCE_BASE:
        	return encoder.getDistance();
		case SPEED_BASE:
        	return encoder.getRate();
		case POSITION_BASE:
			return encoder.get()*this.distancePerPulse;
		default:
        	System.err.println("you fucked up again. I warned that you didn't set mode correctly.");
        	return 0;
        }//end switch
    }//
    
    /**
     * Overwritten method used by PIDSubsystem to set motor outputs
     * added: ability to output slaves and also invert slave outputs
     */
    protected void usePIDOutput(double output) {
        motor.set(output);
        
        if(slaves.size() != slave_invert_flags.size()) // if for some reason the invert flag array got screwed up, ignore it
        {
        	System.err.println("invert flags don't match with slaves");
        	for(int i=0; i < slaves.size(); i++)
        	{
        		//System.out.println("PID setting throttle " + output);
        		slaves.get(i).set(output);
        	}
        	
        	return;
        }
        else // invert flags and slave lists all bueno
        {
        	for(int i=0; i < slaves.size(); i++)
        	{
        		//System.out.println("setting throttle " + output);
        		if(slave_invert_flags.get(i)) // if invert flag, invert slave motor output
        		{
        			slaves.get(i).set(-output);
        		}
        		else // if slave is not to be inverted
        		{
        			slaves.get(i).set(output);
        		}
        	}
        }
    }
    
    /**
     * sets the distance per pulse for the encoder reading
     * @param dpp the distance per pulse
     */
    public void setDistancePerPulse(double dpp)
    {
    	this.distancePerPulse = dpp;
    }
    
    public double getDistancePerPulse()
    {
    	return this.distancePerPulse;
    }
    
    /**
     * sets the motor voltage scale (-1 to 1) depending on whether this subsystem 
     * is on manual or PID controlled mode. If it is on PID controlled mode, 
     * or the exceeds the range it will fail to.
     * added ability to invert slave outputs
     * @param throttle the voltage the motor will be set to
     * @return true if successful, false if on PID controlled mode.
     */
    public boolean setMotorVoltage(double throttle)
    {
        if(this.isEnabled() || throttle > 1 || throttle < -1)
            return false;
        
        motor.set(throttle);
        if(slaves.size() != slave_invert_flags.size()) // if for some reason the invert flag array got screwed up, ignore it
        {
        	System.err.println("invert flags don't match with slaves");
        	for(int i=0; i < slaves.size(); i++)
        		slaves.get(i).set(throttle);
        	
        	
        	return false;
        }
        else // invert flags and slave lists all bueno
        {
        	for(int i=0; i < slaves.size(); i++)
        	{
        		if(slave_invert_flags.get(i)) // if invert flag, invert slave motor output
        		{
        			slaves.get(i).set(-throttle);
        		}
        		else // if slave is not to be inverted
        		{
        			slaves.get(i).set(throttle);
        		}
        	}
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
     * add a slave motor
     * @param controller
     */
    public void addSlave(SpeedController controller)
    {
    	slaves.add(controller);
    	slave_invert_flags.add(false);// if not specified, motor not inverted
    }
    
    public void addSlave(SpeedController controller, boolean isInverted){
    	slaves.add(controller);
    	slave_invert_flags.add(isInverted);
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
     * reset the encoder; can be useful for calibration
     */
    public void resetEncoder()
    {
    	this.encoder.reset();
    }
    
    /**
     * Get last throttle set to the elevator motor
     * @return throttle setting
     */
    public double getMotorVal() {
    	return motor.get();
    }
    
    /**
     * @return the count on the encoder
     */
    public double getEncoderCount()
    {
    	return this.encoder.get();
    }
    
    /**
     * @return the encoder position with distance per pulse factor
     */
    public double getEncoderPosition()
    {
    	return this.encoder.get() * this.distancePerPulse;
    }
}//end class
