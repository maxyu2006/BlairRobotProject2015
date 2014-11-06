/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Blair Robot Project
 */
public class AutonomousCommand extends CommandGroup {
    
    public AutonomousCommand() {
        addSequential(new AdjustPositionCommand());
    }
}
