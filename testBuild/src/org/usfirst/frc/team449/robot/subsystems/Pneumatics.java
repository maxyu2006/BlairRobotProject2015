package org.usfirst.frc.team449.robot.subsystems;

import java.util.Hashtable;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	
	private final Hashtable<String, Solenoid>	solenoids;
    
	public static final boolean STATE_OPEN 		= true;
	public static final boolean STATE_CLOSED 	= false;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Pneumatics()
	{
		this.solenoids	= new Hashtable<String, Solenoid>();
	}
	
	
	/**
	 * add a solenoid mapping to the system
	 * @param name		the name to map the solenoid to
	 * @param solenoid	the solenoid to add
	 * @return			true if it was able to add, false if not
	 */
	public boolean addSolenoid(String name, Solenoid solenoid)
	{
		//if name is not taken, put solenoid
		if(solenoids.get(name) == null)
			solenoids.put(name, solenoid);
		else
			return false;	//name is taken!
		
		return true;
	}//end addSolenoid
	
	/**
	 * toggles the state of a solenoid
	 * @param name the name of the solenoid 
	 * @return true if successfully toggled, false if 
	 */
	public boolean toggleState(String name)
	{
		return set(name, !getState(name));
	}
	
	/**
	 * set the state of solenoid name
	 * @param name the name of the solenoid to set state
	 * @param state the state to set the solenoid to
	 * @return true if the state was successfully set, false if it failed
	 */
	public boolean set(String name, boolean state)
	{
		if(!exists(name))
			return false;
		
		this.solenoids.get(name).set(state);
		
		return true;
	}//end set()
	
	/**
	 * return the state of the solenoid name
	 * @param name the name of the solenoid to query
	 * @return the state of the solenoid.
	 */
	public boolean getState(String name)
	{
		if(!exists(name))
			return false;
		
		return this.solenoids.get(name).get();	//return the state of the solenoid
	}
	
	/**
	 * does the solenoid exist already?
	 * @param name the name of the solenoid
	 * @return true if solenoid exists, false if it does not
	 */
	public boolean exists(String name)
	{
		return (solenoids.get(name) != null);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

