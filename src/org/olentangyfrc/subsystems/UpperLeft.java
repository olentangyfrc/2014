/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import org.olentangyfrc.RobotMap;
import org.olentangyfrc.commands.DriveFrontLeft;

public class UpperLeft extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Victor topLeft;

    public UpperLeft() {
        topLeft = new Victor(RobotMap.TOP_LEFT_MOTOR);
    }

    public void Move(double speed) {
        topLeft.set(speed);
    }

    public void stopTopLeft() {
        topLeft.stopMotor();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveFrontLeft());

    }
}
