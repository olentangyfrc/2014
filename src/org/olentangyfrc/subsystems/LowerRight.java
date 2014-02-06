/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.olentangyfrc.RobotMap;
import org.olentangyfrc.commands.DriveBackRight;

/**
 *
 * @author alex
 */
public class LowerRight extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Victor LowRight;

    public LowerRight() {
        LowRight = new Victor(RobotMap.LOW_RIGHT_MOTOR);
    }

    public void Move(double speed) {
        LowRight.set(speed);

    }

    public void stopLowRight() {
        LowRight.stopMotor();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveBackRight());
    }
}
