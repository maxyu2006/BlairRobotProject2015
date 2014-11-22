/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.subsystems;

import com.team449.frc2014.RobotMap;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author Max Yu
 */
public class pidMotor extends PIDSubsystem {

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;

    private final Jaguar motor = new Jaguar(RobotMap.talonPort);
    private final Encoder encoder = new Encoder(1,2,1,3,true, CounterBase.EncodingType.k4X);
    
    private double targetRPM;
    
    // Initialize your subsystem here
    public pidMotor(double initRPM, boolean isManual) {
        super("pidMotor", Kp, Ki, Kd);
        
        //set targetRPM
        this.targetRPM = initRPM;
        
        //set the encoder DPP and reset the encoder
        encoder.setDistancePerPulse(1/RobotMap.encoderPPR);
        encoder.start();
        encoder.reset();
        
        //set PIDController constraints
        super.getPIDController().setOutputRange(-1, 1); //min max set to that for Jaguar.set
        
        //if is running on manual mode disable the
        //pid controller and return; no need for anything else
        if(isManual)
        {
            this.disable();
            return;
        }//end if
        
        this.setSetpoint(initRPM);
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
        
        return encoder.getRate();
    }
    
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
        if(!this.isManual() || volt > 1 || volt < -1)
            return false;
        
        motor.set(volt);
        
        return true;
    }
    
    /**
     * 
     * @param RPM 
     */
    public void setRPM(double RPM)
    {
        this.setSetpoint(RPM);
    }
    
    public double getRPM()
    {
        return this.getSetpoint();
    }
    
    /**
     * returns if this subsystem is running in manual mode or PID controlled mode
     * @return true if in manual mode, false if in PID controlled mode
     */
    public boolean isManual()
    {
        return this.getPIDController().isEnable();
    }
    
    public double getRealRate()
    {
        return encoder.getRate();
    }
}//end class
