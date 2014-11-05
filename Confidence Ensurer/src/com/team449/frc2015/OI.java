
package com.team449.frc2015;

import com.team449.frc2015.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private Joystick j1 = new Joystick(RobotMap.j1port);
    private Joystick j2 = new Joystick(RobotMap.j2port);

    
    Button roller_intake = new JoystickButton(j2,2),
            roller_output = new JoystickButton(j2,3),
            roller_down = new JoystickButton(j1,2),
            roller_up = new JoystickButton(j1,3);
    Button fire1 = new JoystickButton(j1,1),
            fire2 = new JoystickButton(j2,1);
  
    
    public OI(){
        roller_down.whenPressed(new LowerRoller());
        roller_up.whenPressed(new RaiseRoller());
        if(fire1.get()){
            fire2.whenPressed(new FireFlinger());
        }
        else if(fire2.get()){
            fire1.whenPressed(new FireFlinger());
        }
            
    }
    public double getJ1Axis(){
        return j1.getY();
    }
    
    public double getJ2Axis(){
        return j2.getY();
    }
    
    public double getRollerSpeed(){
        if(roller_intake.get())
            return .75;
        if(roller_output.get())
            return -.75;
        return 0;
    }
    
}

