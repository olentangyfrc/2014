
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DigitalInput;
import org.olentangyfrc.RobotMap;
import org.olentangyfrc.commands.PrimeShooter;

/**
 * Handles the firing mechanism.
 * @author Bindernews
 */
public class ShootingSubsystem extends Subsystem {
	
	// here we will add various internal fields
	// like Jaguars, Victors, etc.
    
	Victor bashMotor;
        DigitalInput primingLimit;
        DigitalInput shootingLimit;
        
	public ShootingSubsystem() {
		super("ShootingSubsystem");
                bashMotor = new Victor(RobotMap.BASH_MOTOR);
                primingLimit = new DigitalInput(RobotMap.PRIMING_LIMIT);
                shootingLimit = new DigitalInput(RobotMap.SHOOTING_LIMIT);
	}

	protected void initDefaultCommand() {
		// here we can set up a default command to control the subsystem
            
            setDefaultCommand(new PrimeShooter());
	}
	
	public void setSpeed(double speed) {
		bashMotor.set(speed);
	}
        
        public boolean isInPrimingPosition() {
            return primingLimit.get();
        }
        
        public boolean hasShot() {
            return shootingLimit.get();
        }
}
