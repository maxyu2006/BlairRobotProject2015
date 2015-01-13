package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
    
	private final DigitalInput limit1;
	private final DigitalInput limit2;
    private final Encoder encoder;
    private final Victor winner;
    
    public Elevator() {
    	limit1 = new DigitalInput(RobotMap.elevlim1Chnl);
    	limit2 = new DigitalInput(RobotMap.elevlim2Chnl);
    	encoder = new Encoder(RobotMap.elevEncA, RobotMap.elevEncB,
        		true, CounterBase.EncodingType.k4X);
    	winner = new Victor(RobotMap.elevVict);
    	encoder.reset();
    }
    
    public boolean touchingTop() {
    	return limit1.get();
    }
    
    public boolean touchingBottom() {
    	return limit2.get();
    }
    
    public void setMotor(double speed) {
    	winner.set(speed);
    }
    
    public double getPosition(){
    	return encoder.getDistance();
    }

    public void initDefaultCommand() {
    }
}

