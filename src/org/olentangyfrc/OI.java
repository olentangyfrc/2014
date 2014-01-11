
package org.olentangyfrc;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import org.olentangyfrc.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// creates digital channels, the encoder and the encoder output variables
//	DigitalInput channel1a = new DigitalInput(1, 1);
//	DigitalInput channel1b = new DigitalInput(1, 2);
	//AnalogChannel analog1 = new AnalogChannel(1);
	
	
//	public Encoder feederEncoder = new Encoder(channel1a, channel1b);
//	double rawencoder = feederEncoder.getRaw();
//    double encoderRate = feederEncoder.getRate();
//	double encoderDist = feederEncoder.getDistance();
	 
	public double verticalAimOverrideSpeed=0.125;
	public double horizontalAimOverrideSpeed=0.3; 
	// public ADXL345_I2C accelo = new ADXL345_I2C(2, ADXL345_I2C.DataFormat_Range.k2G);
	
	public double autoModeBaseTime = 0;
	
	
	//*****************************************************//
	//* VARIABLES                                         *//
	//*****************************************************//
	public int rawHopper = 0;
	public double rate = 0;
	public boolean towards = true;
	public double distance = 0; 
	public double angle =0;
	// Create the joystick and of the 8 buttons on 
  
  
	public double verticalAimCurentPosition = 0;
	public int OperatingMode = 0;
	
	public double ClimberCurrentPosition = 0;
	
	public double FeederCurrentPosition = 0;
	public double Feedercnt = 0;
	public boolean ShooterOn = false;
	public boolean ShooterReady = false;
	public double ShooterMotorStartTime = 0;
	
	Joystick leftJoy = new Joystick(3);
	Button leftbutton1 = new JoystickButton(leftJoy, 1),
			leftbutton2 = new JoystickButton(leftJoy, 2),
			leftbutton3 = new JoystickButton(leftJoy, 3),
			leftbutton4 = new JoystickButton(leftJoy, 4),
			leftbutton5 = new JoystickButton(leftJoy, 5),
			leftbutton6 = new JoystickButton(leftJoy, 6),
			leftbutton7 = new JoystickButton(leftJoy, 7),
			leftbutton8 = new JoystickButton(leftJoy, 8),
			leftbutton9 = new JoystickButton(leftJoy, 9),
			leftbutton10 = new JoystickButton(leftJoy, 10),
			leftbutton11 = new JoystickButton(leftJoy, 11);
	Joystick rightJoy = new Joystick(1);
	Button rightbutton1 = new JoystickButton(rightJoy, 1),
			rightbutton2 = new JoystickButton(rightJoy, 2),
			rightbutton3 = new JoystickButton(rightJoy, 3),
			rightbutton4 = new JoystickButton(rightJoy, 4),
			rightbutton5 = new JoystickButton(rightJoy, 5),
			rightbutton6 = new JoystickButton(rightJoy, 6),
			rightbutton7 = new JoystickButton(rightJoy, 7),
			rightbutton8 = new JoystickButton(rightJoy, 8),
			rightbutton9 = new JoystickButton(rightJoy, 9),
			rightbutton10 = new JoystickButton(rightJoy, 10),
			rightbutton11 = new JoystickButton(rightJoy, 11);
	Joystick shooterJoy = new Joystick(2);
	Button shooterbutton1 = new JoystickButton(shooterJoy, 1),
			shooterbutton2 = new JoystickButton(shooterJoy, 2),
			shooterbutton3 = new JoystickButton(shooterJoy, 3),
			shooterbutton4 = new JoystickButton(shooterJoy, 4),
			shooterbutton5 = new JoystickButton(shooterJoy, 5),
			shooterbutton6 = new JoystickButton(shooterJoy, 6),
			shooterbutton7 = new JoystickButton(shooterJoy, 7),
			shooterbutton8 = new JoystickButton(shooterJoy, 8),
			shooterbutton9 = new JoystickButton(shooterJoy, 9),
			shooterbutton10 = new JoystickButton(shooterJoy, 10);

	//Joystick shooterJoy til new Joystick(4);
	/**
	 * Bind the press of each button to a specific command or command group.
	 */
	public OI() {
		//System.out.println("IO: OperatingMode BEGIN : " + OI.OperatingMode);
		//edu.wpi.first.wpilibj.networktables2.util.List ntutillist = new edu.wpi.first.wpilibj.networktables2.util.List(); 
		//edu.wpi.first.wpilibj.networktables2.util.Stack ntutilstack = new edu.wpi.first.wpilibj.networktables2.util.Stack(); 
		//System.out.print("ntstack : " + ntutilstack + "\n");

		//rightbutton7.whenPressed(new ShooterMotorForward());
		// need to map buttons to commands 
		// BUTTON1 is the trigger
		/**************************/
		/* Left joystic buttons  */
		/**************************/
		//double dist = feederEncoder.getDistance();
	//	SmartDashboard.putNumber("Feeder Distance Monitor : ", dist);
		//leftbutton1.whenPressed(new ClimberControlLeftJoyStick());
		
	angle = acceleration();
		leftbutton2.whenPressed(new DriveTrainControlTankJoysticks());
	    leftbutton3.whileHeld(new DriveTrainControlStraightForwardSlow());
		leftbutton3.whenReleased(new DriveTrainControlTankJoysticks());
		leftbutton4.whileHeld(new DriveTrainControlStraightBackwardSlow());
		leftbutton4.whenReleased(new DriveTrainControlTankJoysticks());	
        leftbutton5.whenPressed(new DriveTrainControlShooterModeLeft());  
		//leftbutton6.whenPressed(new ShootFrizbee()); 
		//leftbutton7.whileHeld(new FeederAdjust());
		//leftbutton7.whenReleased(new FeederStop());		
		leftbutton8.whenPressed(new EmergencyStop()); 
		leftbutton9.whenPressed(new DriveTrainControlAutoAim());
		//leftbutton10.whenPressed(new ShooterMotorForward());
		//leftbutton11.whenPressed(new ShooterMotorStop());
        /**************************/
		/* Right joystic buttons  */
		/**************************/
		//rightbutton1.whenPressed(new ClimberControlRightJoyStick());
		rightbutton2.whenPressed(new DriveTrainControlTankJoysticks());		
		rightbutton3.whileHeld(new DriveTrainControlStraightForwardFast());
		rightbutton3.whenReleased(new DriveTrainControlTankJoysticks()); 
		rightbutton4.whileHeld(new DriveTrainControlStraightBackwardSlow());
		rightbutton4.whenReleased(new DriveTrainControlTankJoysticks());  
		rightbutton5.whenPressed(new DriveTrainControlShooterModeRight()); 
		//leftbutton6.whenPressed(new ShootFrizbee());
		//rightbutton7.whileHeld(new FeederAdjust());
		//rightbutton7.whenReleased(new FeederStop());
		//rightbutton8.whenPressed(new ShootFrizbee());
		rightbutton9.whenPressed(new DriveTrainControlAutoAim()); 
		//rightbutton10.whenPressed(new ShooterMotorForward());
		//rightbutton11.whenPressed(new ShooterMotorStop());
        /**************************/
		/* Shooter joystic buttons */
		/**************************/
		shooterbutton1.whenPressed(new DriveTrainControlAutoAim());
		//shooterbutton2.whenPressed(new VerticalAimControlShooterJoyStick());
		//shooterbutton5.whenPressed(new ClimberControlShooterJoystick());  
		shooterbutton6.whenPressed(new DriveTrainControlShooterJoysticksAim());
//		shooterbutton7.whenPressed(new ShooterMotorStop());
//		shooterbutton8.whileHeld(new FeederAdjust());
//		shooterbutton8.whenReleased(new FeederStop());
//		shooterbutton9.whenPressed(new ShooterMotorForward());
//		shooterbutton10.whenPressed(new FeederPush());
//		shooterbutton10.whenPressed(new ShootFrizbee());

		
		/****************************************/
		/* Network table procedures             */
		/*************************FeederPush());

		
		/****************************************/
		/* Network table procedures             */
		/****************************************/
		ITableListener itl = new ITableListener() 
		{
			public void valueChanged(ITable table, String name, Object o, boolean bln) {
				X5MULT = table.getNumber("X5MULT");
				X4MULT = table.getNumber("X4MULT");
				X3MULT = table.getNumber("X3MULT");
				X2MULT = table.getNumber("X2MULT");
				X1MULT = table.getNumber("X1MULT");
				X0MULT = table.getNumber("X0MULT");

				Mult1[0] = table.getNumber("X0MULT");
				Mult1[1] = table.getNumber("X1MULT");
				Mult1[2] = table.getNumber("X2MULT");
				Mult1[3] = table.getNumber("X3MULT");
				Mult1[4] = table.getNumber("X4MULT");
				Mult1[5] = table.getNumber("X5MULT");
			}
		};
		NetworkTable table = NetworkTable.getTable("SmartDashboard");
		table.putNumber("X5MULT", X5MULT);
		table.putNumber("X4MULT", X4MULT);
		table.putNumber("X3MULT", X3MULT);
		table.putNumber("X2MULT", X2MULT);
		table.putNumber("X1MULT", X1MULT);
		table.putNumber("X0MULT", X0MULT);
		table.addTableListener(itl); 
	}

	/********************************/
	/* Drive Train Conditioners     */
	/********************************/
	 double[] Mult1 = {
		0.3015,
		0.3731,
		0, 0,
		0, 0,};
	 double[] Mult2 = {
		1.1636,
		-2.1269,
		1.7839,};
	 double X5MULT = 0,
			X4MULT = 0,
			X3MULT = 0,
			X2MULT = 0,
			X1MULT = 0.3731,
			X0MULT = 0.3015;

	public double conditionDriveTrainSpeed(double speed) {
		 
		double aspeed = Math.abs(speed);
		double value = 0;
		if (aspeed < 0.13) {
			aspeed = 0;
		}
		if (aspeed > 0.95) {
			value = 1;
		} else if (aspeed >= .9 && aspeed <= .95) {
			value =
					6 * MathUtils.pow(aspeed, 2)
					+ -9.18 * MathUtils.pow(aspeed, 1)
					+ 4.055;
		} else {
			value =
					X5MULT * MathUtils.pow(aspeed, 5)
					+ X4MULT * MathUtils.pow(aspeed, 4)
					+ X3MULT * MathUtils.pow(aspeed, 3)
					+ X2MULT * MathUtils.pow(aspeed, 2)
					+ X1MULT * MathUtils.pow(aspeed, 1)
					+ X0MULT;
		}
		value *= aspeed / speed; // re-add the sign
		return value;
	}
    /********************************/
	/* left drive train             */
	/********************************/
	public double getLeftSpeed() {
		double speed = conditionDriveTrainSpeed(leftJoy.getY());
		SmartDashboard.putNumber("LSpeed", speed);
		return speed;
	}
    public double getClimberSpeed(int source)
	{
		double speed = 0;
		switch(source)
		{
			case 0: // left joystick
				speed = leftJoy.getY();
				break;
			case 1: // right joystick
				speed = rightJoy.getY();
				break;
			case 2: // shooter joystick
				speed = shooterJoy.getY();
				break;
			default:// shooter joystick
				speed = shooterJoy.getY();
				break;
		} 
		return speed;
	}
	public double getLeftJoyStickY()
	{
		return leftJoy.getY();
	}
	public double getRightJoyStickY()
	{
		return rightJoy.getY();
	}
	public double getshooterJoyStickY()
	{
		return shooterJoy.getY();
	}
	public double getLeftHorizontal() {

		double lefthorizontal = conditionDriveTrainSpeed(leftJoy.getX());
		lefthorizontal = lefthorizontal * (-1);
		if (Math.abs(lefthorizontal) < Constants.JoyStickSoftener) {
			lefthorizontal = 0;
		}
		return lefthorizontal;
	}
    /**************************/
	/* right drive train      */
	/**************************/
	/**
	 * @return The value of the right joystick. Note: this uses raw axis because
	 * we have a logitech joystick that resembles a PS controller.
	 */
	public double getRightSpeed() {
		double speed = conditionDriveTrainSpeed(rightJoy.getY());
		SmartDashboard.putNumber("RSpeed", speed);
		return speed;
	}
    public double getHorizontalAimSpeed(int source)
	{
		double speed = 0;
		String srcname = "default";
		switch(source)
		{	
			case Constants.UseLeftJoyStick: // Left Joystick
				speed=leftJoy.getX();
				srcname="LeftJoyStick";
				break;
			case Constants.UseRightJoyStick: //right joystick
				speed=rightJoy.getX();
				srcname="rightJoyStick";
				break;
			case Constants.UseShooterJoyStick: // shooter joystick
				speed = shooterJoy.getX();
				srcname="shooterJoyStick";
				break;
			case Constants.UseAuto:
				speed = getRoboRealmHorizontalSpeed();
				srcname = "AutoAimHorizontal";
				break;
			default: // shooter joystick
				speed = shooterJoy.getX();
				srcname="shooterJoyStick";
				break;
		}  
		double sign=1;
		if(speed < 0)
		{
			sign=(-1);
		}
		if (Math.abs(speed) <= 0.5) {
			speed = 0;
		} else {
			speed = Constants.AimHorizontalDefaultSpeed;
		}
		speed *= sign; 
		SmartDashboard.putString("Vertical Shooter Source",srcname);
		SmartDashboard.putNumber("Vertical Speed",speed); 
		return speed;
	} 
	public double getRightHorizontal() {
		double righthorizontal = conditionDriveTrainSpeed(rightJoy.getX());
		righthorizontal = righthorizontal * (1);
		if (Math.abs(righthorizontal) < Constants.JoyStickSoftener) {
			righthorizontal = 0;
		}
		return righthorizontal;
	}
    /********************8***************/
	/* shooter drive                    */
	/************************************/
	public double getShooterDrivepeed() {
		double Speed = conditionDriveTrainSpeed(shooterJoy.getY());
		//double VerticalAimSpeed =shooterJoy.getRawAxis(7);
		//double VerticalAimSpeed =shooterJoy.getRawAxis(4);
		if (Math.abs(Speed) < Constants.JoyStickSoftener) {
			Speed = 0;
		}
		return Speed;
	}
    /***********************************/
	/* vertical aim                    */
	/***********************************/ 
	public double getVerticalAimSpeed(int source) {
		double speed = 0;
		String srcname = "default";
		switch(source)
		{	
			case Constants.UseLeftJoyStick: // Left Joystick
				speed=leftJoy.getY();
				srcname="LeftJoyStick";
				break;
			case Constants.UseRightJoyStick: //right joystick
				speed=rightJoy.getY();
				srcname="rightJoyStick";
				break;
			case Constants.UseShooterJoyStick: // shooter joystick
				speed = shooterJoy.getY();
				srcname="shooterJoyStick";
				break;
			case Constants.UseAuto:
				speed = getRoboRealmVerticalSpeed();
				srcname = "AutoAim";
				break;
			default: // shooter joystick
				speed = shooterJoy.getY();
				srcname="shooterJoyStick";
				break;
		}  
		double sign=1;
		if(speed < 0)
		{
			sign=(-1);
		}
		if (Math.abs(speed) <= 0.5) {
			speed = 0;
		} else {
			speed = Constants.AimVerticalSpeed;
		}
		speed *= sign; 
		SmartDashboard.putString("Vertical Shooter Source",srcname);
		SmartDashboard.putNumber("Vertical Speed",speed);
		return speed;
	}  
	public double getRoboRealmVerticalSpeed()
	{
		double speed = 0;
		// put roborealm Y offset calculations here
		// speed is positive, negative or zero.
		return speed;
		
	} 
	public double getRoboRealmHorizontalSpeed()
	{
		double speed = 0;
		// put roborealm Y offset calculations here
		// speed is positive, negative or zero.
		return speed;
		
	}  
	public double getAutoAimHorizontalSpeed() {
		double AimSpeed = 0;
		double AimDelta = 0;
		double Distance = 0;
		Distance += SmartDashboard.getNumber("Distance", 0);
		Distance += SmartDashboard.getNumber("Distance1", 0);
		Distance += SmartDashboard.getNumber("Distance2", 0);
		Distance += SmartDashboard.getNumber("Distance3", 0);
		Distance += SmartDashboard.getNumber("Distance4", 0);
		Distance += SmartDashboard.getNumber("Distance5", 0);
		AimDelta += SmartDashboard.getNumber("HOff", 0);
		AimDelta += SmartDashboard.getNumber("HOff1", 0);
		AimDelta += SmartDashboard.getNumber("HOff2", 0);
		AimDelta += SmartDashboard.getNumber("HOff3", 0);
		AimDelta += SmartDashboard.getNumber("HOff4", 0);
		AimDelta += SmartDashboard.getNumber("HOff5", 0);
		System.out.print("H AimDelta : " + AimDelta + "\n");
		System.out.print("Distance : " + AimDelta + "\n");
		double AimDeltaAvg = AimDelta / 5;
		double AimDistanceAvg = AimDelta / 5;
		int idx = 0;
		if (Math.abs(AimSpeed) > Constants.AimHorizontalSoftener) {
			AimSpeed = Constants.AimDefaultSpeed; // aim set to a specific speed
			SmartDashboard.putString("Aim Horizonal Lock :", "Not Locked");
		} else {
			AimSpeed = 0; // locked within tolerance
			SmartDashboard.putString("Aim Horizontal Lock :", "Locked");
		}
		return AimSpeed;
	}

	public double getHorizontalAimSpeed() {
		double speed = shooterJoy.getX();
		if (Math.abs(speed) < 0.7) {
			speed = 0;
		} else {
			double sign = Math.abs(speed) / speed;
			speed = 0.35 * sign;
		}
		return speed;
	}
	public double acceleration(){
		
		double angleInDegrees =0;

		
//		double accelerationInG = accelo.getAcceleration(ADXL345_I2C.Axes.kY);
//		
//		if(accelerationInG > 1.00) {
//			accelerationInG = 1.00;
//		}
//		if(accelerationInG < -1.00) {
//			accelerationInG = 0.00;
//		}
//		
//		angleInDegrees = Math.toDegrees(MathUtils.asin(accelerationInG));
//		
//		SmartDashboard.putNumber("Shooter Aim Angle", angleInDegrees);
		
		return angleInDegrees;
		
	}
}
