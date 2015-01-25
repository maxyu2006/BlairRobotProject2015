package org.usfirst.frc.team449.robot.subsystems;

import org.usfirst.frc.team449.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Drive subsystem.
 */
public class Drive extends Subsystem {
    
    // Drive hardware fields
	private Victor[] motorsLeft = new Victor[3];
	private Victor[] motorsRight = new Victor[3];
	
	public Drive(RobotMap config){
		motorsLeft = new Victor[]{new Victor(config.leftMotorChannels[0]),
				new Victor(config.leftMotorChannels[1]),
				new Victor(config.leftMotorChannels[2])};
		motorsRight = new Victor[]{new Victor(config.rightMotorChannels[0]),
				new Victor(config.rightMotorChannels[1]),
				new Victor(config.rightMotorChannels[2])};
	}
	
	/**
	 * Sends power to the three left and right three motors on the drive frame.
	 * @param leftVolts - The amount of volts to supply to the three left motors.
	 * @param rightVolts - The amount of volts to supply to the three right motors.
	 */
	public void  move(double leftVolts, double rightVolts){
		for(Victor i:motorsLeft){
			i.set(leftVolts);
		}
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

