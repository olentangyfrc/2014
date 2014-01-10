package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import org.olentangyfrc.RobotMap;
import org.olentangyfrc.commands.RotateRoller;

/**
 *
 */
public class Roller extends Subsystem {
    
             Victor rollerMotor;
             
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
        
        public Roller() {
            super("RollerSubsystem");
            rollerMotor = new Victor(RobotMap.ROLLER_MOTOR);
        }     
        
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
            
            setDefaultCommand(new RotateRoller());
	}
        
        public void setSpeed(double speed) {
            rollerMotor.set(speed);
        }
        
        public void stop(){
        rollerMotor.set(0);
        }
}
