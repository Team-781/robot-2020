package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight extends SubsystemBase {
NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
NetworkTableEntry tx = table.getEntry("tx"); // x pos
NetworkTableEntry ty = table.getEntry("ty"); // y pos
NetworkTableEntry ta = table.getEntry("ta"); // target area
NetworkTableEntry tv = table.getEntry("tv"); // limelight valid target - <1.0 = invalid

//read values periodically
private double nv, nx, ny;

//post to smart dashboard periodically
//SmartDashboard.putNumber("LimelightX", x);
//SmartDashboard.putNumber("LimelightY", y);
//SmartDashboard.putNumber("LimelightArea", area);

  //double targetOffsetAngle_Horizontal = table.getNumber("tx", 0);
  //double targetOffsetAngle_Vertical = table.getNumber("ty", 0);
 // double targetArea = table.getNumber("ta", 0);
  //double targetSkew = table.getNumber("ts", 0);
public Limelight() {

}

/** 
 * check to see if limelight sees target
 * @return - true if target aquired
 *
 */
public boolean limelighthastarget() {
    nv = tv.getDouble(0);
    return nv < 1.0;
}
/** 
 * value to steer robot might want to limit vale to not cause overesteer
 * @return - double
 */
public double limelightsteercommand() {
    nx = tx.getDouble(0);
    if (nx > 0.1) nx = 0.1;
    if (nx < -0.1) nx = 0.1;
    return nx;
}

/** 
 * return value to elevate are reaching target
 * @return - integer
 */ 
public int limelightelevation() {
    return 300;
}

/** 
 * returns shooter speed to reach target
 * @return - double
 */

public double limelightspeed() {
    return 0.8;
}

/** 
 * us y measurement ti get shooting angle 
 * @return - int - arm lift value from  constants
 */
public int distance() {
    ny = ty.getDouble(0) *10;
//come up with alogorithm to convert nr to an into from 0 to 20
return Constants.shootrange[(int)ny];

}
public double shootspeed() {
    ny = ty.getDouble(0) *10;
    return Constants.shootspeed[(int) ny];
}
@Override
public void periodic() {

}


}