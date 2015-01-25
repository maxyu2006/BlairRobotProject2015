package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Drive subsystem.
 */
public class Drive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final Victor[] motorsLeft;
	private final Victor[] motorsRight;
	
	/**
	 * 
	 * @param leftMotors
	 * @param rightMotors
	 */
	public Drive(Victor[] leftMotors, Victor[] rightMotors){
		this.motorsLeft 	= leftMotors;
		this.motorsRight 	= rightMotors;
	}
	
	/**
	 * 
	 * @param leftVolts
	 * @param rightVolts
	 */
	public void setThrottle(double leftVolts, double rightVolts){
		
		for(int i = 0; i < this.motorsLeft.length; i++)
			this.motorsLeft[i].set(leftVolts);
		
		for(int i = 0; i < this.motorsRight.length; i++)
			this.motorsRight[i].set(rightVolts);
		
	}//end move()
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

