/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.olentangyfrc.RobotMap;
import org.olentangyfrc.commands.DriveFrontRight;


public class UpperRight extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private Victor topRight;
	
	public UpperRight()
	{
		topRight = new Victor(RobotMap.TOP_RIGHT_MOTOR);
	}
	
	public void Move(double speed)
	{
		topRight.set(speed);
	}
	
	public void stopTopRight()
	{
		topRight.stopMotor();
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveFrontRight());
	}
}
