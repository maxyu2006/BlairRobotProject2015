/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Max Yu
 */
public class Pneumatics extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Compressor compressor;
    
    public Pneumatics(int pressureSwitchSlot, int pressureSwitchChannel, int compressorRelaySlot, int compressorRelayChannel)
    {
        compressor = new Compressor(pressureSwitchSlot, pressureSwitchChannel, compressorRelaySlot, compressorRelayChannel);
        
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
