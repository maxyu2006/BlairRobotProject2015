/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2015.subsystems;

import com.team449.frc2015.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Eyob
 */
public class Drive extends Subsystem {
    
    private final Talon left1;
    private final Talon left2;
    private final Talon left3;
    private final Talon right1;
    private final Talon right2;
    private final Talon right3;
    
    public Drive(){
        left1 = new Talon(RobotMap.left1motor);
        left2 = new Talon(RobotMap.left2motor);
        left3 = new Talon(RobotMap.left3motor);
        right1 = new Talon(RobotMap.right1motor);
        right2 = new Talon(RobotMap.right2motor);
        right3 = new Talon(RobotMap.right3motor);
    }
    
    public void setLeft(double volt){
        left1.set(volt);
        left2.set(volt);
        left3.set(volt);
    }
    
    public void setRight(double volt){
        right1.set(volt);
        right2.set(volt);
        right3.set(volt);
    }
    
    public void setAll(double volt){
        setLeft(volt);
        setRight(volt);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
