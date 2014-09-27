/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author Blair Robot Project
 */
public class Motor extends Subsystem {
    private final Talon motor= new Talon(4);
    public void setMotor(double volt){
        motor.set(volt);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //justleaveithereanddonothing
    }
}
