// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */

  CANSparkMax arm = new CANSparkMax(Constants.kArmPort, MotorType.kBrushless);

  public Arm() {
    arm.restoreFactoryDefaults();

    arm.setInverted(Constants.kArmInvert);
  }

  public void liftArm() {
    arm.set(Constants.kLiftArmSpeed);
  }
  public void lowerArm() {
    arm.set(Constants.kLowerArmSpeed);
  }
  public void stopArm() {
    arm.stopMotor();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
  
