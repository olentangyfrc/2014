
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalOutput;
import org.olentangyfrc.RobotMap;

/**
 *
 */
public class Cylinder extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    DigitalOutput cylinderOutput;
    public Cylinder() {
        super("cylinder");
        cylinderOutput = new DigitalOutput(RobotMap.CYLINDER_OUTPUT);
    }
   

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void extend() {
        cylinderOutput.set(true);
    
    }
}

