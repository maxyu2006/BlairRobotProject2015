
package com.team449.frc2015;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private Joystick j1 = new Joystick(RobotMap.j1port);
    private Joystick j2 = new Joystick(RobotMap.j2port);

    public double getJ1Axis(){
        return j1.getY();
    }
    
    public double getJ2Axis(){
        return j2.getY();
    }
    
}

