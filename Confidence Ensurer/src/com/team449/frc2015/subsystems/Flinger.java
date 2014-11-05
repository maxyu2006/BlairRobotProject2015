/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2015.subsystems;

import com.team449.frc2015.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Harrison
 */
public class Flinger extends Subsystem {
    private Solenoid flinger_sol;
    
    public Flinger(){
        flinger_sol = new Solenoid(RobotMap.flinger_sol);
        flinger_sol.set(false);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void set_flinger_solenoid(boolean value){
        flinger_sol.set(value);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
