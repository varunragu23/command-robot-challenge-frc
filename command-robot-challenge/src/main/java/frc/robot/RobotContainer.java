// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.Command;

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

  public static XboxController driverJoystick;

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings

    driveTrain = new DriveTrain();
    arm = new Arm();
    intake = new Intake();
  
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
    JoystickButton intakeButton = new JoystickButton(driverJoystick, XboxController.Button.kBumperRight.value);
    intakeButton.whenPressed(intake);

    JoystickButton outtakeButton = new JoystickButton(driverJoystick, XboxController.Button.kBumperLeft.value);
    outtakeButton.whenPressed(outtake);

    JoystickButton stopIntakeButton = new JoystickButton(driverJoystick, XboxController.Button.kBumperRight.value);
    stopIntakeButton.cancelWhenPressed(intake);

    JoystickButton liftArmButton = new JoystickButton(driverJoystick, XboxController.Button.kBumperRight.value);
    liftArmButton.whileHeld(arm);

    JoystickButton lowerArmButton = new JoystickButton(driverJoystick, XboxController.Button.kBumperLeft.value);
    lowerArmButton.whileHeld(arm);
  }

  /**~
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
