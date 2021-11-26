// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final DriveTrain driveTrain;
  private final Intake intake;
  private final Arm arm;
  private final DriveWithJoystick driveWithJoystick;
  private final Climber climber;

  public static XboxController driverJoystick;

  // The robot's subsystems and commands are defined here...

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings

    driveTrain = new DriveTrain();
    arm = new Arm();
    intake = new Intake();
    climber = new Climber();


    driveWithJoystick = new DriveWithJoystick(driveTrain);
    driveWithJoystick.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoystick);

    driverJoystick = new XboxController(Constants.JOYSTICK_NUMBER);


    configureButtonBindings();


  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  
  private void configureButtonBindings() {
    JoystickButton intakeButton = new JoystickButton(driverJoystick, Constants.kIntakeBumper);
    intakeButton.whenPressed(intake::intake);

    JoystickButton outtakeButton = new JoystickButton(driverJoystick, Constants.kOuttakeBumper);
    outtakeButton.whenPressed(intake::outtake);

    JoystickButton stopIntakeButton = new JoystickButton(driverJoystick, Constants.kStopIntakeBumper);
    stopIntakeButton.whenPressed(intake::stop);

    JoystickButton liftArmButton = new JoystickButton(driverJoystick, Constants.kLiftArmBumper);
    liftArmButton.whileHeld(arm::liftArm);

    JoystickButton lowerArmButton = new JoystickButton(driverJoystick, Constants.kLowerArmBumper);
    lowerArmButton.whileHeld(arm::lowerArm);

    JoystickButton stopArmButton = new JoystickButton(driverJoystick, Constants.kStopArmBumper);
    stopArmButton.whileHeld(arm::stopArm);

    JoystickButton liftClimberButton = new JoystickButton(driverJoystick, Constants.kLiftClimberBumper);
    liftClimberButton.whileHeld(climber::liftClimber);

    JoystickButton lowerClimberButton = new JoystickButton(driverJoystick, Constants.kLowerClimberBumper);
    lowerClimberButton.whileHeld(climber::lowerClimber);

    JoystickButton stopClimberButton = new JoystickButton(driverJoystick, Constants.kStopClimberBumper);
    stopClimberButton.whileHeld(climber::stopClimber);
  }

  /**~
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
