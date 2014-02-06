/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.olentangyfrc.commands;

/**
 *
 * @author alex
 */
public class DriveFrontLeft extends CommandBase {
	
	public DriveFrontLeft() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(CommandBase.upperLeft );
	}
	// Called just before this Command runs the first time
	protected void initialize() {
	
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double speed  = oi.filter(oi.joystickSolo.getX() /2) + oi.filter( - oi.joystickSolo.getY()) + oi.filter(oi.joystickTwo.getX());
		upperLeft.Move(speed);
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
