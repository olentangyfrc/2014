
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import org.olentangyfrc.RobotMap;
import org.olentangyfrc.OI;

/**
 * Handles the firing mechanism.
 * @author Bindernews
 */
public class ShootingSubsystem extends Subsystem {
	
	// here we will add various internal fields
	// like Jaguars, Victors, etc.
	Victor bashMotor;
	public ShootingSubsystem() {
		super("ShootingSubsystem");
                bashMotor = new Victor(RobotMap.BASH_MOTOR);
	}

	protected void initDefaultCommand() {
		// here we can set up a default command to control the subsystem
	}
	
	public void setSpeed(double speed) {
		bashMotor.set(speed);
	}
	
	public double getSpeed() {
		// TODO implement this
		return 0;
        }
}
