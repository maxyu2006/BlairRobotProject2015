/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2015.subsystems;

import com.team449.frc2015.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Harrison
 */
public class Roller extends Subsystem {
    
    private final Jaguar roller_motor;
    private final DoubleSolenoid roller_sol;
    private boolean isDown = false;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Roller(){
        roller_motor = new Jaguar(RobotMap.roller_motor);
        roller_sol  = new DoubleSolenoid(RobotMap.roller_sol_1, RobotMap.roller_sol_2);
        roller_sol.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void setRollerMotor(double throttle){
        roller_motor.set(throttle);
    }
    
    public void extend_pistons(){
        roller_sol.set(DoubleSolenoid.Value.kForward);
        this.isDown = true;
    }
    
    public void retract_pistons(){
        roller_sol.set(DoubleSolenoid.Value.kReverse);
        this.isDown = false;
    }
    
    /**
     * if arm is down true
     * used as a safety lock to stop the shooter from destroying the arm
     */
    public boolean check_arm(){
        return this.isDown;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
