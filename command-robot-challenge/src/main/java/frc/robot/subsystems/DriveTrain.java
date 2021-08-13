// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.ctre.phoenix.motorcontrol.InvertType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


import com.ctre.phoenix.motorcontrol.InvertType;

import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */



  WPI_TalonFX falconLeftFront; // TalonFX
  WPI_TalonFX falconLeftBack; // TalonFX
  WPI_TalonFX falconRightFront; // TalonFX
  WPI_TalonFX falconRightBack; // TalonFX

  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;

  DifferentialDrive drive;


  public DriveTrain() {

    falconLeftFront = new WPI_TalonFX(Constants.LEFT_FRONT); // TalonFX
    falconLeftBack = new WPI_TalonFX(Constants.LEFT_BACK); // TalonFX
    falconRightFront = new WPI_TalonFX(Constants.RIGHT_FRONT); // TalonFX
    falconRightBack = new WPI_TalonFX(Constants.RIGHT_BACK); // TalonFX


    leftMotors = new SpeedControllerGroup(falconLeftFront, falconLeftBack);
    rightMotors = new SpeedControllerGroup(falconRightFront, falconRightBack);

    drive = new DifferentialDrive(leftMotors, rightMotors);

    falconLeftFront.configFactoryDefault();
    falconLeftBack.configFactoryDefault();
    falconRightFront.configFactoryDefault();
    falconRightBack.configFactoryDefault();

    falconLeftFront.setInverted(Constants.COUNTERCLOCKWISE);
    falconLeftBack.setInverted(Constants.COUNTERCLOCKWISE);
    falconRightFront.setInverted(Constants.CLOCKWISE);
    falconRightBack.setInverted(Constants.CLOCKWISE);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveForward(double leftPwr, double rightPwr, double speed) {
    drive.tankDrive(leftPwr * speed, rightPwr * speed);
  }

  public void driveWithJoysticks(XboxController controller, double speed) {
    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS) * speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS) * speed);
  }

  // public void driveWithJoysticks(XboxController controller, double speed) {
    // drive.arcadeDrive(Constants.kLeftY * speed, Constants.kLeftX * speed);
  // }

  // public void driveTurn(double leftSpeed, double rightSpeed) {
    // drive.tankDrive(leftSpeed, rightSpeed);
  // }

  public void stop() {
    drive.stopMotor();

  }

}
