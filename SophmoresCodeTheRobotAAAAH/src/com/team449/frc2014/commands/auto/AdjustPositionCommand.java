/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.commands.auto;

import com.team449.frc2014.commands.CommandBase;
import com.team449.frc2014.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Blair Robot Project
 */
public class AdjustPositionCommand extends CommandBase {
    
    private double lastVelocity;
    private double error;
    private Timer t;
    
    public AdjustPositionCommand() {
        requires(motor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        lastVelocity = 0;
        t = new Timer();
        t.start();
        motor.startEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        //distance = motor.getDistanceTraveled();
        error = RobotMap.setValue - motor.getDistanceTraveled();
        SmartDashboard.putNumber("error", error);
        SmartDashboard.putNumber("distance", motor.getDistanceTraveled());
        SmartDashboard.putNumber("proportional", getProportional());
        SmartDashboard.putNumber("derivative", getDerivative());
        SmartDashboard.putNumber("velocity", motor.getVelocity());
        SmartDashboard.putNumber("voltage", motor.getVoltage());
        motor.setMotor(getProportional()+getDerivative());
        t.reset();
    }
    
    private double getProportional(){
        return  RobotMap.kP * error;
    }
    
    private double getDerivative(){
        return RobotMap.kD * ((motor.getVelocity()-lastVelocity)/t.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(error) <= 0.2;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("---------------------\nadjust ended\n---------------------");
        t.stop();
        motor.stopEncoder();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
