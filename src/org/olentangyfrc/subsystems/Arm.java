
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import org.olentangyfrc.RobotMap;

/**
 *
 */
public class Arm extends Subsystem {
    
    Victor armMotor;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Arm() {
        super("ArmSubsystem");
        armMotor = new Victor(RobotMap.ARM_MOTOR);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void lift() {
        armMotor.set(.8);
    }
    
    public void lower() {
        armMotor.set(-.8);
    }
    
    public void stop() {
        armMotor.set(0);
    }
    
}

