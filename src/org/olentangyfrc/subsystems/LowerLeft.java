/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.olentangyfrc.RobotMap;
import org.olentangyfrc.commands.DriveBackLeft;

/**
 *
 * @author alex
 */
public class LowerLeft extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Victor lowLeft;

    public LowerLeft() {
        lowLeft = new Victor(RobotMap.LOW_LEFT_MOTOR);
    }

    public void Move(double speed) {
        lowLeft.set(speed);
    }

    public void stopLowLeft() {
        lowLeft.stopMotor();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveBackLeft());
    }
}
