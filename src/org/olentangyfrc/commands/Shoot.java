
package org.olentangyfrc.commands;

import org.olentangyfrc.RobotMap;
/**
 *
 * @author Bindernews
 */
public class Shoot extends CommandBase {
	
	public Shoot() {
		requires(shootingSubsystem);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
            if (RobotMap.SHOOT_AT_A_VARIABLE_SPEED) {
                shootingSubsystem.setSpeed(oi.getVariableSpeed());
            } else {
                shootingSubsystem.setSpeed(1);
            }
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