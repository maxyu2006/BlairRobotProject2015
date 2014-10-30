/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.team449.lib.util;

import com.team449.frc2015.RobotMap;

/**
 *
 * @author Eyob
 */
public abstract class Util {
    
    public static double deadBand(double val){
        return Math.abs(val) < RobotMap.deadBandCap ? 0 : val;
    }
    
}
