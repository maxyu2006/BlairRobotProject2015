/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Max Yu
 */
public class GearDrive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private final Motor left1;
    private final Motor left2;
    private final Motor left3;
    
    private final Motor right1;
    private final Motor right2;
    private final Motor right3;
    
    private boolean gearMode = false;       //gear mode: false = low gear; true = high gear.
    
    /**
     * create a drive given the ports that correspond to the its motors
     * @param leftPorts     array that contains the pwmPort indexes for the left side of the drive. Must be length of three
     * @param rightPorts    array that contains the pwmPort indexes for the right side of the drive. Must also be length of three
     */
    public GearDrive(int[] leftPorts, int[] rightPorts)
    {
        if(leftPorts.length != 3)
            System.err.println("leftPorts length does not match number of motors");
        if(rightPorts.length != 3)
            System.err.println("rightPorts length does not match number of motors");
        
        left1 = new Motor(leftPorts[0]);
        left2 = new Motor(leftPorts[1]);
        left3 = new Motor(leftPorts[2]);
        
        right1 = new Motor(rightPorts[0]);
        right2 = new Motor(rightPorts[1]);
        right3 = new Motor(rightPorts[2]);
    }
    
    /**
     * 
     * @param volt 
     */
    public void setVoltageLeft(double volt)
    {
        //validate voltage passed in
        if(volt > 1 || volt < 0)
        {
            System.err.println("invalid voltage in setVolageLeft");
            return;
        }
       
        //set left side
        left1.setMotor(volt);
        left2.setMotor(volt);
        left3.setMotor(volt);
        
        //set right side
        right1.setMotor(volt);
        right2.setMotor(volt);
        right3.setMotor(volt);
    }

     /**
     * 
     * @param volt 
     */
    public void setVoltageRight(double volt)
    {
        //validate voltage passed in
        if(volt > 1 || volt < 0)
        {
            System.err.println("invalid voltage in setVolageRight");
            return;
        }
        
        //set right side
        right1.setMotor(volt);
        right2.setMotor(volt);
        right3.setMotor(volt);
    }

    public void switchGear()
    {
        gearMode = !gearMode;
    }
    
    public void switchGear(boolean newMode)
    {
        gearMode = newMode;
    }
    
    public boolean getGearMode()
    {
        return gearMode;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
