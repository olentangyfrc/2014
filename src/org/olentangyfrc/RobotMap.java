package org.olentangyfrc;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem. 
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
        public static final boolean
                // set to true to change hammer speed with joystick
                SHOOT_AT_A_VARIABLE_SPEED = false;
        public static final int 
                BASH_MOTOR = 9,
                PRIMING_LIMIT = 1,
                SHOOTING_LIMIT = 2,
                KICK_BUTTON = 5,
                VARIABLE_SPEED_JOYSTICK = 3;
        public static final double
                JOYSTICK_FILTER = .08;
}
