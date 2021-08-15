// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;

public class DriveWithJoystick<Outtake> extends CommandBase {
  private final DriveTrain driveTrain;
  private final Intake intake;
  private final Outtake outtake;
  private final LiftArm liftArm;
  private final LowerArm lowerArm;

  /**
   * Creates a new DriveWithJoysticks.
   */
  public DriveWithJoystick(DriveTrain dt) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
    addRequirements(driveTrain);
  }

  public DriveWithJoystick(Intake it) {
    intake = it;
    addRequirements(intake);
  }

  public DriveWithJoystick(Outtake ot) {
    outtake = ot;
    addRequirements(outtake);
  }

  public DriveWithJoystick(stopIntake si) { //not sure how to configure the stop intake button
    stopIntake = si;
    addRequirements(stopIntake);
  }

  public DriveWithJoystick(liftArm lia) {
    liftArm = lia;
    addRequirements(liftArm);
  }

  public DriveWithJoystick(lowerArm loa) {
    lowerArm = loa;
    addRequirements(lowerArm);
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.driveWithJoysticks(RobotContainer.driverJoystick, Constants.DRIVETRAINSPEED);
    intake.driveWithJoysticks(RobotContainer.driverJoystick, Constants.kIntakeSpeed);
    intake.driveWithJoysticks(RobotContainer.driverJoystick, Constants.kOuttakeSpeed);
    intake.driveWithJoysticks(RobotContainer.driverJoystick, Constants.kStop);
    arm.driveWithJoysticks(RobotContainer.driverJoystick, Constants.kLiftArmSpeed);
    arm.driveWithJoysticks(RobotContainer.driverJoystick, Constants.kLowerArmSpeed);
  }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}