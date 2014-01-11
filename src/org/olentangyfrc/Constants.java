/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.olentangyfrc;
 
public class Constants {
	
	//*******************************************************//
	//* CONSTANTS                                           *//
	//*******************************************************//
	//* Operating Modes                                     *//
	//* Used by the control commands for linking the        *//
	//* different inputs (joystick and auto control inputs) *//
	//* This allows switching control of a subsystem to     *//
	//* different joysticks on the fly                      *//
	//*******************************************************//
	static final public int 
			/********************************/
			/* Operating Modes              */
			/********************************/
			STOP = -1, // initial value to do nothing
			tankModeLeftandRight = 0, //LJoy,RJoy,ShooterJoy	
			tankModeRightandShooter = 1,//Shooter Joy plays left
			tankModeLeftandShooter = 2,// Shooter Joy Plays rt 

			shooterModeLeft = 3, // shooter joy primary
			shooterModeRight = 4, // right joy drives
			shooterModeShooter = 5, // left joy drives

			climberModeLeft = 6, // Left primary
			climberModeRight = 7, // right joy drives
			climberModeShooter = 8, // shooter joy drives

			AutoAim = 9 , // shooter joy drives
			StraightDriveForwardFast = 10, // drives straight forward
			StraightDriveForwardSlow = 12, // drives straight forward 
			StraightDriveBackwardSlow = 13, // drives straight forward 
			AutonomousAimInitialPosition = 11 ; // shooter joy drives; 
     static final public int UseLeftJoyStick=0,
			                 UseRightJoyStick=1,
			                 UseShooterJoyStick=2,
			                 UseAuto = 3;
	 static final public int OperatingModeDefault = tankModeLeftandRight;
     static final public double driveTrainLeftRightMotoraAdjust = 0.88;
	 static final public double StraightDriveSpeedDefaultFast = 0.65;
	 static  final public double StraightDriveSpeedDefaultSlow = 0.45;
	 static  final public double StraightDriveSpeedBackwardDefaultSlow = -0.45;
	 /*****************************/
	 /* Climber Position          */
	 /*****************************/
	  static final public double 
			ClimberStowPosition = 0,
			ClimberStartPosition = 0,
			ClimberMaxPosition = 200;
	 /*****************************/
	 /*  vertical aim             */
	 /*****************************/
	 static final public double JoyStickSoftener = 0.05,
			HorizontalConstant = 0.1,
			verticalAimStowPosition = -20,
			verticalAimStartPosition = 0,
			verticalAimMaxPosition = 0;
	static final public double verticalAimOverrideSpeed=0.125;
	static final public double horizontalAimOverrideSpeed=0.3;
	static final public int DistanceAngle[][] = 
	{{10, 10},
		{20, 20},
		{30, 30},
		{40, 40},
		{50, 50}
	};
	// depending on the distance, the xdelta value has to be adusted.
	// this table takes the delta and adjusts it.
	// Aim Softener
	 static final public double AimStowTime = 3.0;
	 static final public double AimStowSpeed = 0.5;
	 static final public double AimVerticalSpeed=0.55;
	 static final double AimVerticalSoftener = 0.5;
	 static final double AimHorizontalSoftener = 1;
	 static final double AimDefaultSpeed = 0.35;
	 static final double AimHorizontalDefaultSpeed = -0.35; 
	 static final double MaxAimDistanceAdjustment = 60; 
	 static final double AimDistanceAdjustment[][] = {{10, 1},
		{20, 20},
		{30, 30},
		{40, 40},
		{50, 50}
	};
	
	/*********************************/
	/* Feeder variables              */
	/*********************************/
	 static final public double 
			FeederForwardSpeed = -1,
	        FeederBackwardSpeed = 1, 
			FeederStowPosition = 180,
			FeederStartPosition = 0,
			FeederStopPosition = 270,
	        FeederRevolutionTime = .85,
	        FeederResetTime = 3;
	
	/********************************/
	/* shooter variables            */
	/********************************/
	 static final public double ShooterDriveSpeed = -0.35;
	 static final public double ShooterStartupTime = 3.0;
	
	/********************************/
	/* automode                     */
	/********************************/
	 static final public double autoModeDrivetrainSpeed = 0.5; 
	 static final public double autoModeTurnSpeed=-1;
	//Joystick shooterJoy til new Joystick(4);
	/**
	 * Bind the press of each button to a specific command or command group.
	 */
	
}
