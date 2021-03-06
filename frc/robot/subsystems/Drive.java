/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.Constants;
//import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.networktables.*;
//import edu.wpi.first.wpilibj.smartdashboard.*;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.networktables.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.Compressor;
 /*
 * An example subsystem. You can replace with me with your own subsystem.
 */
 
public class Drive extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands
  double speed, steer;
  Compressor compressor = new Compressor(0);
  Solenoid shifter = new Solenoid(0);  
  CANSparkMax lMaster = new CANSparkMax(Constants.lMaster, MotorType.kBrushless);
  CANSparkMax lTyler1 = new CANSparkMax(Constants.lSlave1, MotorType.kBrushless);
  CANSparkMax lTyler2 = new CANSparkMax(Constants.lSlave2, MotorType.kBrushless);
  CANSparkMax rMaster = new CANSparkMax(Constants.rMaster, MotorType.kBrushless);
  CANSparkMax rTyler1 = new CANSparkMax(Constants.rSlave1, MotorType.kBrushless);
  CANSparkMax rTyler2 = new CANSparkMax(Constants.rSlave2, MotorType.kBrushless);

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  CANEncoder left, right;
  //DoubleSolenoid Shifter = new DoubleSolenoid(0, 1);
 protected void initDefaultCommand() {
  // Set the default command for a subsystem here.
 }

  //run this method during robot init
  public Drive() {
  compressor.start();
  //reset motor controllers
  lMaster.restoreFactoryDefaults();
  lTyler1.restoreFactoryDefaults();
  lTyler2.restoreFactoryDefaults();
  rMaster.restoreFactoryDefaults();
  rTyler1.restoreFactoryDefaults();
  rTyler2.restoreFactoryDefaults();
  //set slaves to follow masters
  lTyler1.follow(lMaster);
  lTyler2.follow(lMaster);
  rTyler1.follow(rMaster);
  rTyler2.follow(rMaster);
  //don't send it too quickly (takes a few moments to get to full speed)
  lMaster.setClosedLoopRampRate(1.0);
  rMaster.setClosedLoopRampRate(1.0);
  lMaster.setOpenLoopRampRate(1.0);
  rMaster.setOpenLoopRampRate(1.0);
  //Right Side goes backwards normally, so invert the motor controllers
  rMaster.setInverted(true);
  rTyler1.setInverted(true);
  rTyler2.setInverted(true);
  
  rMaster.setIdleMode(IdleMode.kBrake);

  left = lMaster.getEncoder();
  right = rMaster.getEncoder();
}
 
 public void ArcadeDrive(double speed, double steer) {
    speed = speed * speed * speed * 0.7;
    steer = steer * steer * steer * 0.3;
    lMaster.set(speed - steer);
    rMaster.set(speed + steer);
    //SmartDashboard.putNumber("left position", left.getPosition());
    //SmartDashboard.putNumber("right position", right.getPosition());
  }
 public void ShiftGears(boolean shift) {
    if (shift) {
        shifter.set(true);
    } else
        shifter.set(false);
}
}



