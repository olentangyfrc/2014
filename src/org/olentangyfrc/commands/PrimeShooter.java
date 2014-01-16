
package org.olentangyfrc.commands;

/**
 * Primes the shooter for shooting. This will probably 
 * @author Bindernews
 */
public class PrimeShooter extends CommandBase {
	
	public static final long PULL_BACK_TIME = 1000L;
	
	private long startTime;
	
	public PrimeShooter() {
		requires(shootingSubsystem);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		shootingSubsystem.setSpeed(-1.0);
		startTime = System.currentTimeMillis();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		// pulling back
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// return true if it's actually pulled back
		return System.currentTimeMillis() > startTime + PULL_BACK_TIME;
	}

	// Called once after isFinished returns true
	protected void end() {
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		
	}
}