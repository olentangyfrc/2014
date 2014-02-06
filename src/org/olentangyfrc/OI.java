package org.olentangyfrc;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public double filter(double rawValue) {
		double result = 0;
		if (Math.abs(rawValue) < .13) {
			return result;
		}
		if (btnWarpSpeed.get()) {
			return rawValue;
		} else {
			result = rawValue / 1.5;
		}
		return result;
	}
	
	public Joystick joystickSolo = new Joystick(1);
	public Joystick joystickTwo = new Joystick(2);
	public Joystick stellarus = new Joystick(RobotMap.STELLARUS_PORT);
	
	public JoystickButton btnBrake = new JoystickButton(joystickSolo, 2),
			btnWarpSpeed = new JoystickButton(joystickSolo, 1),
			btnRollerForwards = new JoystickButton(stellarus, RobotMap.BUTTON_WHITE_UP),
			btnRollerBackwards = new JoystickButton(stellarus, RobotMap.BUTTON_WHITE_DOWN),
			
			btnArmUp = new JoystickButton(stellarus, RobotMap.BUTTON_BLUE_UP),
			btnArmDown = new JoystickButton(stellarus, RobotMap.BUTTON_BLUE_DOWN),
			btnArmCatch = new JoystickButton(stellarus, RobotMap.BUTTON_RED_UP),
			btnPass = new JoystickButton(stellarus, RobotMap.BUTTON_YELLOW_UP),
			btnGoal = new JoystickButton(stellarus, RobotMap.BUTTON_YELLOW_DOWN),
			btnTrussShot = new JoystickButton(stellarus, RobotMap.BUTTON_RED_DOWN);

	public OI() {
		btnRollerForwards.whenPressed(null);
		btnRollerBackwards.whenPressed(null);
		btnArmUp.whenPressed(null);
		btnArmDown.whenPressed(null);
		btnArmCatch.whenPressed(null);
		btnPass.whenReleased(null); // THIS IS INTENTIONAL
		btnGoal.whenPressed(null);
		btnTrussShot.whenPressed(null);
	}
}
