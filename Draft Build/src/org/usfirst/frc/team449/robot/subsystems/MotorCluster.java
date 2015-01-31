package org.usfirst.frc.team449.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorCluster extends Subsystem implements SpeedController {
    
	private final ArrayList<SpeedController> controllerList;
	
	private double lastSet = 0;
	
	/**
	 * 
	 * @param controller
	 */
	public MotorCluster(SpeedController controller)
	{
		this.controllerList = new ArrayList<SpeedController>();
		this.controllerList.add(controller);
		
		this.lastSet = 0;
	}
	
	/**
	 * add a motor that will be considered a part of the cluster
	 * @param controller the motorController
	 */
	public void addSlave(SpeedController controller)
	{
		controllerList.add(controller);
	}

	@Override
	public void pidWrite(double output) {
		for(int i=0; i < this.controllerList.size(); i++)
			controllerList.get(i).set(output);
		
		this.lastSet = output;
	}

	@Override
	public double get() {
		return this.lastSet;
	}

	@Override
	public void set(double speed, byte syncGroup) {
		System.out.println("This shit is deprecated and shouldn't be called.\n TL;DR: YOU DONE FUCKED UP");
	}

	@Override
	public void set(double speed) {
	
		for(int i=0; i < this.controllerList.size(); i++)
			controllerList.get(i).set(speed);
		
		this.lastSet = speed;
	}

	@Override
	public void disable() {
		
		for(int i=0; i < this.controllerList.size(); i++)
			controllerList.get(i).disable();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//no default command yo
	}
}//end class