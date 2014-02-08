/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.olentangyfrc.commands;

/**
 *
 * @author Bindernews
 */
public class DriveJoysticks extends CommandBase {
	
	public DriveJoysticks() {
		requires(driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double joySoloXD2 = oi.filter(oi.joystickSolo.getX()/2);
		double joySoloNY = oi.filter( - oi.joystickSolo.getY());
		double joyTwoX = oi.filter(oi.joystickTwo.getX());
		double joyTwoNX = oi.filter( - oi.joystickTwo.getX());
		
		driveTrain.setLowerLeft(joySoloXD2 + joySoloNY - joyTwoX);
		driveTrain.setLowerRight(joySoloXD2 - joySoloNY + joyTwoNX);
		driveTrain.setUpperRight(joySoloXD2 - joySoloNY - joyTwoNX);
		driveTrain.setUpperLeft(joySoloXD2 + joySoloNY + joyTwoX);
		
		// lowerLeft.Move(oi.filter(oi.joystickSolo.getX()/2) + oi.filter( - oi.joystickSolo.getY()) - oi.filter(oi.joystickTwo.getX()));
		// lowerRight.Move(oi.filter(oi.joystickSolo.getX()/ 2) - oi.filter(- oi.joystickSolo.getY()) + oi.filter(- oi.joystickTwo.getX()));
		// upperLeft.Move(oi.filter(oi.joystickSolo.getX() /2) + oi.filter( - oi.joystickSolo.getY()) + oi.filter(oi.joystickTwo.getX()));
		// upperRight.Move(oi.filter(oi.joystickSolo.getX() / 2) - oi.filter(- oi.joystickSolo.getY()) - oi.filter( - oi.joystickTwo.getX()));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}