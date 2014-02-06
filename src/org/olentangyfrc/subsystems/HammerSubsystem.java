/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Bindernews
 */
public class HammerSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public HammerSubsystem() {
		super("Hammer Subsystem");
	}
	
	public void setSpeed(double spd) {
		
	}
	
	public void moveInitial() {
		
	}
	
	public void fire() {
		
	}

	protected double returnPIDInput() {
		throw new RuntimeException("Not supported");
	}

	protected void usePIDOutput(double d) {
		throw new RuntimeException("Not supported");
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}