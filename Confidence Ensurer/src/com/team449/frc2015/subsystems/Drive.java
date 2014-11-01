/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2015.subsystems;

import com.team449.frc2015.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Eyob
 */
public class Drive extends Subsystem {
    
    private final Jaguar left1;
    private final Jaguar left2;
    private final Jaguar left3;
    private final Jaguar right1;
    private final Jaguar right2;
    private final Jaguar right3;
    
    public Drive(){
        left1 = new Jaguar(RobotMap.left1motor);
        left2 = new Jaguar(RobotMap.left2motor);
        left3 = new Jaguar(RobotMap.left3motor);
        right1 = new Jaguar(RobotMap.right1motor);
        right2 = new Jaguar(RobotMap.right2motor);
        right3 = new Jaguar(RobotMap.right3motor);
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
