/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Max Yu
 */
public class JagMotor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private final Jaguar controller;
    
    public JagMotor(int channel)
    {
        controller = new Jaguar(channel);
    }
    
    /**
     * set the speed of this motor from -1 to 1
     * @param speed the desired speed of the motor
     */
    public void setSpeed(double speed)
    {
        //not valid
        if(speed > 1.0 || speed < -1.0)
        { 
            System.err.println("WARNING setSpeed "+ speed +" for DriveMotor "+ controller.getChannel());
            
            //cap speed
            if(speed > 1.0)
                speed = 1.0;
            if(speed < -1.0)
                speed = -1.0;
            
            System.out.println("speed capped to " + speed);
        }//endif

        controller.set(speed);
    }//end setVoltage(double)

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
