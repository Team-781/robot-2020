/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.RobotContainer;
//import frc.robot.Constants;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example command that uses an example subsystem.
 */
public class LimelightAim extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drive m_subsystem;
  private final Limelight m_subsystem2;
  private double lsteer , speed;
  //private boolean isDone = false;
  //Timer lTimer = new Timer();

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public LimelightAim(Drive subsystem, Limelight subsystem2) {
    m_subsystem = subsystem;
    m_subsystem2 = subsystem2;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    addRequirements(subsystem2);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //lTimer.reset();
    //lTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    speed = RobotContainer.DriverY();
    if (m_subsystem2.limelighthastarget()) {
    lsteer = m_subsystem2.limelightsteercommand();
    //lspeed = m_subsystem2.limelightdrivecommand(Constants.distanceMED);
    m_subsystem.ArcadeDrive(speed, lsteer);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.ArcadeDrive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   // if (lTimer.get() > 2.0) {
     /// isDone = true;
    //}
    //return isDone;
    return (lsteer > 0.0 && lsteer < 0.4);
  }
 
}
