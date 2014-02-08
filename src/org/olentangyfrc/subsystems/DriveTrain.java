/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.olentangyfrc.RobotMap;

/**
 *
 * @author Bindernews
 */
public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private Victor lowerLeft;
	private Victor lowerRight;
	private Victor upperLeft;
	private Victor upperRight;
	
	public DriveTrain() {
		super("Drive Train");
		lowerRight = new Victor(RobotMap.LOW_RIGHT_MOTOR);
		lowerLeft  = new Victor(RobotMap.LOW_LEFT_MOTOR);
		upperRight = new Victor(RobotMap.TOP_RIGHT_MOTOR);
		upperLeft  = new Victor(RobotMap.TOP_LEFT_MOTOR);
	}
	
	public void setLowerLeft(double spd) {
		lowerLeft.set(spd);
	}
	
	public void setLowerRight(double spd) {
		lowerRight.set(spd);
	}
	
	public void setUpperRight(double spd) {
		upperRight.set(spd);
	}
	
	public void setUpperLeft(double spd) {
		upperLeft.set(spd);
	}
	
	public void setAllSpeed(double spd) {
		upperLeft.set(spd);
		upperRight.set(spd);
		lowerLeft.set(spd);
		lowerRight.set(spd);
	}
	
	public void stopLowerLeft() {
		lowerLeft.stopMotor();
	}
	
	public void stopLowerRight() {
		lowerRight.stopMotor();
	}
	
	public void stopUpperLeft() {
		upperLeft.stopMotor();
	}
	
	public void stopUpperRight() {
		upperRight.stopMotor();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}