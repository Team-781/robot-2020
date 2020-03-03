/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Shooter m_shoot = new Shooter();
  private final Drive m_drive = new Drive();
  private final Intake m_intake = new Intake();
  private final Climber m_climber = new Climber();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  //Driver
  final Joystick vroomstick = new Joystick(Constants.vroom_stick);
  final Joystick beepboopstick = new Joystick(Constants.beepboop_stick);
  final JoystickButton drA = new JoystickButton(vroomstick, Constants.drA);
  final JoystickButton drB = new JoystickButton(vroomstick, Constants.drB);
  final JoystickButton drY = new JoystickButton(vroomstick, Constants.drY);
  final JoystickButton drX = new JoystickButton(vroomstick, Constants.drX);
  final JoystickButton drLB = new JoystickButton(vroomstick, Constants.drLB);
  final JoystickButton drRB = new JoystickButton(vroomstick, Constants.drRB);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }
  public double DriverY() {
    return vroomstick.getRawAxis(0);
  }
  public double DriverX() {
    return vroomstick.getRawAxis(4);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
