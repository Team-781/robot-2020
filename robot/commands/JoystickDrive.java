/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.subsystems.Drive;
//import frc.robot.subsystems.Limelight;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class JoystickDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drive m_subsystem;
  //private final Limelight m_subsystem2;
  private double speed, steer;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public JoystickDrive(Drive subsystem){//, Limelight subsystem2) {
    m_subsystem = subsystem;
    //m_subsystem2 = subsystem2;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
   // addRequirements(subsystem2);
  }


// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    speed = Robot.robotContainer.DriverY();
    steer = Robot.robotContainer.DriverX();

    m_subsystem.ArcadeDrive(speed, steer);
    //if (Robot.robotContainer.getOpA()) {
    //  if (limelightsteer < -0.5) {limelightsteer = -0.5;}
    //  if (limelightsteer > 0.5) {limelightsteer = 0.5;}
    //  m_subsystem.ArcadeDrive(limelightspeed, limelightsteer);
    //}
    //else {
      //regular manual driving
      //m_subsystem.ArcadeDrive(speed, steer);
    //}
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
