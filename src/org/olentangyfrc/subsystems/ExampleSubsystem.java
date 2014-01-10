package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExampleSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
        // Declare Motors here
        // Example: Victor motor;

        public  ExampleSubsystem() {
            super("ExampleSubsystem");
            // Create motor 
            // Example: motor = new Victor(port);
            
        }
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}
