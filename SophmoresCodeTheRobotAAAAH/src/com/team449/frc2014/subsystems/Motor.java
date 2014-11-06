/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.subsystems;

import com.team449.frc2014.RobotMap;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author Blair Robot Project
 */
public class Motor extends Subsystem {
    
    private final Talon motor = new Talon(RobotMap.talonPort);
    private final Encoder encoder = new Encoder(1,2,1,3,true, CounterBase.EncodingType.k4X);
    
    public Motor(){
        encoder.setMaxPeriod(.1);
        encoder.setDistancePerPulse(RobotMap.enDPP);
        encoder.setMinRate(RobotMap.enMinRt);
        encoder.setSamplesToAverage(RobotMap.enNumSamp);
        encoder.start();
    }
    
    public void setMotor(double volt){
        motor.set(volt);
        System.out.println("encoder: "+encoder.getStopped()+" "+encoder.get()+" "+encoder.getRate()+" "+encoder.getRaw());
        System.out.println("voltage: "+volt);
    }
    
    public int getRevolutions(){
        return encoder.getRaw();
    }
    
    public double getDistanceTraveled(){
        return encoder.getDistance();
    }
    
    public double getVelocity(){
        return encoder.getRate();
    }
    
    public void initDefaultCommand() {
    }
}
