// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int LEFT_FRONT = 3;
	public static final int RIGHT_FRONT = 1;
	public static final int LEFT_BACK = 4;
    public static final int RIGHT_BACK = 2;

    public static final boolean CLOCKWISE = false;
    public static final boolean COUNTERCLOCKWISE = true;

    public static final int XBOX_LEFT_X_AXIS = 0;
    public static final int XBOX_LEFT_Y_AXIS = 1;

    public static final double DRIVETRAINSPEED = 0.3;

    public static final double kIntakeSpeed = -0.2;
    public static final double kOuttakeSpeed = 0.3;
    public static final int kStop = 0;

    public static final double kLiftArmSpeed = 0.1;
    public static final double kLowerArmSpeed = -0.05;
    //public static final double stopArm = 0;

    public static final double kLiftClimberSpeed = 0.15;
    public static final double kLowerClimberSpeed = -0.05;

    public static final int JOYSTICK_NUMBER = 0;

    public static final int kLeftX = 2;
    public static final int kRightX = 4;
    public static final int kLeftY = 1;
    public static final int kRightY = 5;

    public static final int kIntakePort = 6;

    public static final int kArmPort = 5;

    public static final int kClimberPort = 14; // not finalized need to double check on "REV SPARK MAX Client" - finalized

    public static final boolean kRollerInvert = false;

    public static final boolean kArmInvert = true;
	public static final String IntakeConstants = null;
    public static final boolean kClimberInvert = true;

    public static final int kIntakeBumper = 5;
    public static final int kOuttakeBumper = 6;
    public static final int kLiftArmBumper = 3;
    public static final int kLowerArmBumper = 4;

    public static final int kStopIntakeBumper = 7;
    public static final int kLiftClimberBumper = 8;
    public static final int kLowerClimberBumper = 9;
    public static final int kStopClimberBumper = 10;
    public static final int kStopArmBumper = 11;

}
