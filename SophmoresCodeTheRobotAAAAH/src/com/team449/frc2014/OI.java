
package com.team449.frc2014;

import com.team449.frc2014.commands.ToggleReverseCommand;
import com.team449.frc2014.commands.auto.AdjustPositionCommand;
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
    public Button reset;
    
    public boolean isNotToggled=true;
    
    public OI(){
        j1 = new Joystick(RobotMap.joyPort);
        
        reverse = new JoystickButton(j1, RobotMap.reverseButtonPos);
        reset = new JoystickButton(j1, RobotMap.resetButtonPos);
        reverse.whenPressed(new ToggleReverseCommand());
        reset.whenPressed(new AdjustPositionCommand());
    }
    
    public double getSpeed(){
        int reverseInt;
        
        if(isNotToggled)
            reverseInt = 1;
        else
            reverseInt = -1;
        
        return deadband(j1.getRawAxis(2))*RobotMap.multiplier*reverseInt;
    }
    
    public double deadband(double in){
        if(Math.abs(in) > RobotMap.deadband)
            return in;
        else
            return 0;
    }
}

