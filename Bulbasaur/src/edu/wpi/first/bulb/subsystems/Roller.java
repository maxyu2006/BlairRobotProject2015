
package edu.wpi.first.bulb.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.bulb.RobotMap;

/**
 * The thing that catches and releases balls
 */
public class Roller extends Subsystem {
    Jaguar rollerMotor = new Jaguar(RobotMap.MOTOR_PORT);
    DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.R_FWD_CHANNEL, RobotMap.R_REV_CHANNEL);
    
    public void setSolenoid(DoubleSolenoid.Value value) {
        solenoid.set(value);
    }
    
    public void setMotor(double speed) {
        rollerMotor.set(speed);
    }
    
    public void initDefaultCommand() {
    }
}

