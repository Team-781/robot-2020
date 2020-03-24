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
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //SUBSYSTEMS
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Shooter m_shoot = new Shooter();
  private final Drive m_drive = new Drive();
  private final Intake m_intake = new Intake();
  private final Climber m_climber = new Climber();
  private final Shwoop m_shwoop = new Shwoop();
  private final Arm m_arm = new Arm();
  private final Limelight m_limelight = new Limelight();
  //COMANDS
  private final JoystickDrive JoystickDrive = new JoystickDrive(m_drive);
  //private final RunIntake runIntake = new RunIntake(m_intake);
  private final LoadShwoop loadShwoop = new LoadShwoop(m_shwoop);
  //private final ReverseIntake reverseIntake = new ReverseIntake(m_intake);
  //private final ArmDown armDown = new ArmDown(m_arm);
  private final RunParascopeDown runParascopeDown = new RunParascopeDown(m_limelight);
  private final RunParascopeUp runParascopeUp = new RunParascopeUp(m_limelight);
  double DriverY, DriverX;
  //Driver
  final static Joystick vroomstick = new Joystick(Constants.vroom_stick);
  final JoystickButton drA = new JoystickButton(vroomstick, Constants.drA);
  final JoystickButton drB = new JoystickButton(vroomstick, Constants.drB);
  final JoystickButton drY = new JoystickButton(vroomstick, Constants.drY);
  final JoystickButton drX = new JoystickButton(vroomstick, Constants.drX);
  final JoystickButton drLB = new JoystickButton(vroomstick, Constants.drLB);
  final static JoystickButton drRB = new JoystickButton(vroomstick, Constants.drRB);
  // Operater
  final Joystick beepboopstick = new Joystick(Constants.beepboop_stick);
  final JoystickButton op1 = new JoystickButton(beepboopstick, Constants.op1);
  final JoystickButton op2 = new JoystickButton(beepboopstick, Constants.op2);
  final JoystickButton op3 = new JoystickButton(beepboopstick, Constants.op3);
  final JoystickButton op4 = new JoystickButton(beepboopstick, Constants.op4);
  final JoystickButton op5 = new JoystickButton(beepboopstick, Constants.op5);
  final JoystickButton op6 = new JoystickButton(beepboopstick, Constants.op6);
  final JoystickButton op7 = new JoystickButton(beepboopstick, Constants.op7);
  final JoystickButton op8 = new JoystickButton(beepboopstick, Constants.op8);
  final JoystickButton op9 = new JoystickButton(beepboopstick, Constants.op9);
  final JoystickButton op10 = new JoystickButton(beepboopstick, Constants.op10);
  final JoystickButton op11 = new JoystickButton(beepboopstick, Constants.op11);
  final JoystickButton op12 = new JoystickButton(beepboopstick, Constants.op12);
  final JoystickButton op13 = new JoystickButton(beepboopstick, Constants.op13);
  final JoystickButton op14 = new JoystickButton(beepboopstick, Constants.op14);
  final JoystickButton op15 = new JoystickButton(beepboopstick, Constants.op15);
  final JoystickButton op16 = new JoystickButton(beepboopstick, Constants.op16);
  final JoystickButton op17 = new JoystickButton(beepboopstick, Constants.op17);
  final JoystickButton op18 = new JoystickButton(beepboopstick, Constants.op18);
  final JoystickButton op19 = new JoystickButton(beepboopstick, Constants.op19);
  final JoystickButton op20 = new JoystickButton(beepboopstick, Constants.op20);
  final JoystickButton op21 = new JoystickButton(beepboopstick, Constants.op21);
  final JoystickButton op22 = new JoystickButton(beepboopstick, Constants.op22);
  final JoystickButton op23 = new JoystickButton(beepboopstick, Constants.op23);
  final JoystickButton op24 = new JoystickButton(beepboopstick, Constants.op24);

  /*
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // set default commands
    m_drive.setDefaultCommand(JoystickDrive);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //op4.whileHeld(armStarting);
    drA.whileHeld(new RunClimber(m_climber, -1.0));
    drY.whileHeld(new RunClimber(m_climber, 1.0));
    op1.whileHeld(loadShwoop);
    op2.whileHeld(runParascopeUp);

    op5.whileHeld(new ZeroArm(m_arm));

    op7.whileHeld(runParascopeDown);

    op11.whileHeld(new RunArm(m_arm, Constants.armVertical));
    op12.whileHeld(new RunArm(m_arm, Constants.arm10ft));
    op13.whileHeld(new RunArm(m_arm, Constants.armDown));

    op15.whileHeld(new RunArm(m_arm, Constants.armHome));

    op17.whileHeld(new ParallelCommandGroup(new RunArm(m_arm, Constants.armDown), new RunIntake(m_intake, 0.75)));
    op18.whileHeld(new RunIntake(m_intake, -0.75));
    op19.whileHeld(new RunShwoopShooter(m_shwoop, m_shoot, 0.8));
    op20.whileHeld(new LimelightAim(m_drive, m_limelight));
    op21.whileHeld(new RunShwoopShooter(m_shwoop, m_shoot, 0.9));
    op22.whenPressed(new ZeroArm(m_arm));
    // op11.whileHeld(new ArmVertical(m_arm));
    //op13.whileHeld(armDown);
    //op15.whileHeld(new ArmHome(m_arm));
    // op12.whileHeld(new Arm11ft(m_arm));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
   // return autonomous;
   //return new SequentialCommandGroup(new ArmDown(m_arm) ,new Autonomous(m_drive), new Arm11ft(m_arm), new RunShwoopShooter(m_shwoop, m_shoot));
    return new SequentialCommandGroup(new RunArm(m_arm, Constants.armDown), new Autonomous(m_drive), new ParallelCommandGroup(new RunArm(m_arm, Constants.arm10ft), new RunShwoopShooterAuto(m_shwoop, m_shoot)));
    //new LimelightAim(m_drive, m_limelight), new RunShwoopShooter(m_shwoop, m_shoot));
    //return new SequentialCommandGroup(autonomous, aimFAR);
  }

  public static double DriverY() {
    return vroomstick.getRawAxis(1);
  }

  public static double DriverX() {
    return vroomstick.getRawAxis(4);
  }
  
  public static double DriverLT() {
    return vroomstick.getRawAxis(2);
  }

  public static double DriverRT() {
    return vroomstick.getRawAxis(3);
  }

  public static boolean DriverRB() {
    return drRB.get();
  }
}