
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import org.olentangyfrc.RobotMap;
/**
 *
 */
public class Cylinder extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid cylinderOutput;
public Cylinder() {
    super("Cylinder");
    cylinderOutput = new  Solenoid(RobotMap.CYLINDER_OUTPUT);
}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
    }
    public void extend(){
        cylinderOutput.set(true);
        
    }
    public void release(){
        cylinderOutput.set(false);
        
    }
    
}

