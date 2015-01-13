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
    
	private final DigitalInput limitTop;
	private final DigitalInput limitBottom;
    private final Encoder enProgrammer;
    private final Victor winner;
    
    public Elevator() {
    	limitTop = new DigitalInput(RobotMap.elevlim1Chnl);
    	limitBottom = new DigitalInput(RobotMap.elevlim2Chnl);
    	enProgrammer = new Encoder(RobotMap.elevEncA, RobotMap.elevEncB,
        		true, CounterBase.EncodingType.k4X);
    	winner = new Victor(RobotMap.elevVict);
    	enProgrammer.reset();
    	
    }
    /**
     * Returns whether the top tote is touching the top of the elavator
     * @return
     */
    public boolean touchingTop() {
    	return limitTop.get();
    }
    
    public boolean touchingBottom() {
    	return limitBottom.get();
    }
    
    public void setMotor(double speed) {
    	winner.set(speed);
    }
    
    public double getPosition(){
    	return enProgrammer.getDistance();
    }

    public void initDefaultCommand() {
    }
}

