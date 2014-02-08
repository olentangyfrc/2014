/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.olentangyfrc.commands;

/**
 *
 * @author Bindernews
 */
public class SetWheelSpeed extends CommandBase {
	
	private double speedFrontLeft;
	private double speedFrontRight;
	private double speedBackLeft;
	private double speedBackRight;
	private boolean stopOnEnd;
	
	public SetWheelSpeed(double frontLeft, double frontRight, double backLeft,
			double backRight, boolean stopOnEnd) {
		requires(driveTrain);
		speedFrontLeft = frontLeft;
		speedFrontRight = frontRight;
		speedBackLeft = backLeft;
		speedBackRight = backRight;
		this.stopOnEnd = stopOnEnd;
	}
	
	public SetWheelSpeed(double speed, boolean stopOnEnd) {
		this(speed, speed, speed, speed, stopOnEnd);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		driveTrain.setUpperLeft(speedFrontLeft);
		driveTrain.setUpperRight(speedFrontRight);
		driveTrain.setLowerLeft(speedBackLeft);
		driveTrain.setLowerRight(speedBackRight);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		if (stopOnEnd) {
			driveTrain.stopUpperLeft();
			driveTrain.stopUpperRight();
			driveTrain.stopLowerLeft();
			driveTrain.stopLowerRight();
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}