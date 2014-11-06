
package com.team449.frc2014;

import com.team449.frc2014.commands.ToggleReverseCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick j1;
    public Button reverse;
    
    public boolean isNotToggled=true;
    
    public OI(){
        j1 = new Joystick(1);
        reverse = new JoystickButton(j1, RobotMap.reverseButtonPos);
        
        reverse.whenPressed(new ToggleReverseCommand());
    }
    
    public double getSpeed(){
        int reverseInt = isNotToggled?1:-1;
        return deadband(j1.getRawAxis(2))*RobotMap.multiplier*reverseInt;
    }
    
    public double deadband(double in){
        return Math.abs(in) > RobotMap.deadband ? in : 0;
    }
}

