
package org.olentangyfrc.commands;

import org.olentangyfrc.RobotMap;
/**
 *
 * @author Bindernews
 */
public class PrimeAndShoot extends CommandBase {
	public int shootingSpeed = -1;
	public PrimeAndShoot() {
		requires(shootingSubsystem);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
            if (shootingSubsystem.topPosition()) {
                shootingSpeed++;
            }
            if (shootingSubsystem.hasShot()){
                shootingSpeed=0;
            }
            shootingSubsystem.setSpeed(shootingSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return shootingSubsystem.hasShot();
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}