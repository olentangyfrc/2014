
package org.olentangyfrc.commands;

/**
 *
 * @author bradmiller
 */

public class RotateRoller extends CommandBase {

    public RotateRoller() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(roller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        roller.setSpeed(oi.getRollerSpeed());
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