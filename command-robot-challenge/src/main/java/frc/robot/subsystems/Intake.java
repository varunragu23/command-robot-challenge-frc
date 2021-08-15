// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  CANSparkMax roller;

  public Intake() {
    roller.restoreFactoryDefaults();

    roller.setInverted(Constants.kRollerInvert); 
  }

  public void intake() {
    roller.set(Constants.kIntakeSpeed);
  }

  public void outtake() {
    roller.set(Constants.kOuttakeSpeed);
  }

  public void stop() {
    roller.stopMotor();
  }
  
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void driveWithJoysticks(XboxController driverJoystick, double kintakespeed) {
}
}
