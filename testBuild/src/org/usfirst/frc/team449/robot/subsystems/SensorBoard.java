
package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;

/**
 * 
 */
public class SensorBoard extends Subsystem {
    
	private DigitalInput di;
	private AnalogPotentiometer ai;
	private ADXL345_I2C a;
	
	public SensorBoard() {
		di = new DigitalInput(RobotMap.limitChnl);
		ai = new AnalogPotentiometer(RobotMap.potChnl);
		a  = new ADXL345_I2C(Port.kOnboard, Range.k2G);
	}
	public boolean getDigital() {
		return di.get();
	}
	
	public double getPotValue() {
		return ai.get();
	}
	
	public double getAccelX() {
		return a.getX();
	}
	
	public double getAccelY() {
		return a.getY();
	}
	
	public double getAccelZ() {
		return a.getZ();
	}

    public void initDefaultCommand() {
    }
}

