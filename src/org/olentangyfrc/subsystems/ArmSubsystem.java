
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import org.olentangyfrc.RobotMap;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
    
    Victor armMotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public ArmSubsystem() {
        super("ArmSubsystem");
        armMotor = new Victor(RobotMap.ARM_MOTOR);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void liftArm() {
        armMotor.set(.8);
    }
    
    public void lowerArm() {
        armMotor.set(-.8);
    }
    
}

