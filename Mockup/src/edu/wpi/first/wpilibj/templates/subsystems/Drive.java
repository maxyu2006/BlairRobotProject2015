/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Max Yu
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private final JagMotor[] right;
    private final JagMotor[] left;
    
    public Drive(JagMotor[] left, JagMotor[] right)
    {
        checkSymmetry();
        
        this.left   = left;
        this.right  = right;
    }//end Drive(JagMotor[], JagMotor[])
    
    public void setSpeed(double leftSpeed, double rightSpeed)
    {
        checkSymmetry();
        
        for(int i=0; i < left.length; i++)
        {
            left[i].setSpeed(leftSpeed);
            right[i].setSpeed(rightSpeed);
        }//end for
    }//end setSpeed(double, double)
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Checks symmetry in terms of number of motors assigned to each side
     * if they aren't equal, print warning message
     */
    private void checkSymmetry()
    {
        if(left.length != right.length)
        {
            System.err.print("WARNING Drive motor config not Symmetrical: ");
            System.err.println("Left "+ left.length + "Right "+ right.length);
        }
    }//end checkSymmetry()
}//end class
