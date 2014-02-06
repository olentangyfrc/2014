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
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    public static final int TOP_LEFT_MOTOR = 1;
    public static final int TOP_RIGHT_MOTOR = 2;
    public static final int LOW_LEFT_MOTOR = 3;
    public static final int LOW_RIGHT_MOTOR = 4;
    
    public static final int
            HAMMER_MOTOR_1 = 5,
            HAMMER_MOTOR_2 = 6;

    public static final int
            STELLARUS_PORT = 0,
            BUTTON_WHITE_DOWN = 10,
            BUTTON_WHITE_UP = 9,
            BUTTON_BLUE_DOWN =  8,
            BUTTON_BLUE_UP = 7,
            BUTTON_GREEN_DOWN = 6,
            BUTTON_GREEN_UP = 5,
            BUTTON_YELLOW_DOWN = 4,
            BUTTON_YELLOW_UP = 3,   // this is INVERTED!!! Pushing the button causes it to turn off. Code wisely.
            BUTTON_RED_DOWN = 2,
            BUTTON_RED_UP = 1;
}
