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
	 
	private final DigitalInput 	limitTop;
	private final DigitalInput 	limitBottom;
    private final Encoder 		encoder;    
    
    /**
     * initialize the elevator 
     */
    public Elevator() {
    	limitTop 	= new DigitalInput(RobotMap.elevlim1Chnl);
    	limitBottom = new DigitalInput(RobotMap.elevlim2Chnl);
    	encoder 	= new Encoder(RobotMap.elevEncA, RobotMap.elevEncB, true, CounterBase.EncodingType.k4X);
    	motor 		= new Victor(RobotMap.elevVict);
    	
    	enProgrammer.reset();
    }
    
    public boolean touchingTop() {
    	//return limitTop.get();
    	return false;
    }
    
    public boolean touchingBottom() {
    	//return limitBottom.get();
    	return false;
    }
    
    public void setMotor(double speed) {
    	//winner.set(speed);
    }
    
    public double getPosition(){
    	//return enProgrammer.getDistance();
    	return 0;
    }

    public void initDefaultCommand() {
    }
}

