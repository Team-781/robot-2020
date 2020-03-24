package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
public class Limelight extends SubsystemBase {
    DoubleSolenoid parascope = new DoubleSolenoid(Constants.parascope1, Constants.parascope2);
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry tv = table.getEntry("tv");

    //read values periodically
    private double nv, nx, na, lsteer, lspeed;
    private double steer_k = .133333333;
    private double drive_k = .3;
    //boolean 
    
    //double targetOffsetAngle_Horizontal = table.getNumber("tx", 0);
    //double targetOffsetAngle_Vertical = table.getNumber("ts", 0);
    //double targetArea = table.getNumber("ta", 0);
    //double targetSkew = table.getNumber("ts", 0);
  public Limelight() {
  }
  public void periodic() {
    SmartDashboard.putNumber("LimelightX", lsteer);
    SmartDashboard.putNumber("AproxDistance", na * 0.85);
    SmartDashboard.putBoolean("target seen", limelighthastarget());
  }
   /**
    * check to see if limelight sees target
    * @return - true if target aquired
    *
    */
  public boolean limelighthastarget() {
      nv = tv.getDouble(0);
      return nv > 0.0;
  }
  //value to steer robot, limiting speed may be useful
  public double limelightsteercommand() {
      nx = tx.getDouble(0.0);
      lsteer = nx * steer_k;
      return lsteer;
  }
  public double limelightdrivecommand(double targetArea) {
      na = ta.getDouble(0.0);
      lspeed = targetArea - na * drive_k;
      return lspeed;
    }
  public void moveParascope(boolean onOff) {
    if (onOff) parascope.set(Value.kForward);
    else parascope.set(Value.kReverse);
  }
  public void setPipeline(int pipeline) {
  NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(pipeline);
  }
}