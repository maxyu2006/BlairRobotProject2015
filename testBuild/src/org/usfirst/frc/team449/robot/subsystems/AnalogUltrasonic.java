package org.usfirst.frc.team449.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AnalogUltrasonic extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	// difference b/w halfs of a foot: .136 V

	private AnalogInput sensorReading;
	
	private double lastReading;
	private double lastDistance;
	
	private static double scaleFactor = 136;	//the conversion factor for volts to inches. Units are millivolts/inch
	
	/**
	 * Creates a new AnalogUltransonic sensor with a default scaleFactor of 9.8 volts/inch
	 * @param channel
	 */
	public AnalogUltrasonic(int channel)
	{
		if(channel < 0 || channel > 7)
			System.err.println("you fucked up in assigning the AnalogUltrasonic sensor a channel");
		
		sensorReading = new AnalogInput(channel);
	}
	
	/**
	 * creates a new AnalogUltrasonic sensor with a modified scaleFactor for converting the sensor reading to inches
	 * @param channel		the analog channel the sensor is plugged into 0-3 are on the roboRio 4-7 on the moreBoard
	 * @param scaleFactor	the new scaleFactor for conversion. Units MUST BE IN millivolts/inch
	 */
	public AnalogUltrasonic(int channel, double scaleFactor)
	{
		this(channel);
		
		AnalogUltrasonic.scaleFactor = scaleFactor;
	}
	
	public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	}
	
	/**
	 * 
	 * @return
	 */
	public double getLastReading()
	{
		return this.lastReading;
	}
	
	/**
	 * reads the sensor voltage, storing the value in lastReading
	 * @return the voltage output of the sensor
	 */
	public double readSensor()
	{
		this.lastReading = sensorReading.getVoltage();
		
		return this.lastReading;
	}
	
	public double readAverage()
	{
		return this.sensorReading.getAverageVoltage();
	}
	
	public double readDistance()
	{
		this.lastReading 	= sensorReading.getVoltage();
		this.lastDistance	= lastReading * 43.142 - 2.589;
		
		return this.lastDistance;
	}
}//end class
