
package edu.wpi.first.bulb;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.bulb.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    Joystick stick = new Joystick(RobotMap.JOY_PORT);
    Button buttonUp = new JoystickButton(stick, RobotMap.BUTTON_UP);
    Button buttonDown = new JoystickButton(stick, RobotMap.BUTTON_DOWN);  

    public double getStickY() {
        if(Math.abs(stick.getY()) < 0.001) return 0;
        return stick.getY();
    }
    
    public OI() {
        buttonUp.whenPressed(new Up());
        buttonDown.whenPressed(new Transition());
    }
}