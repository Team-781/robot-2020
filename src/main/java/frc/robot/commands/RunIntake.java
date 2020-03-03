package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class RunIntake extends Command {
    public RunIntake() {
      // Use requires() here to declare subsystem dependencies
      requires(Robot.m_Intake);
    }
  
    // Called just before this Command runs the first time
    protected void initialize() {
      Robot.m_Intake.runIntake(0.5);
    }
  
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }
  
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
      return false;
    }
  
    // Called once after isFinished returns true
    @Override
    protected void end() {
    }
  
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
      Robot.m_Intake.stop();
    }
  }
  