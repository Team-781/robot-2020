/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class Shwoop extends SubsystemBase {
  TalonSRX _shwoop = new TalonSRX(Constants.shwoop);
  DigitalInput ballSensor = new DigitalInput(Constants.shwoopSensor);
  /**
   * Creates a new ExampleSubsystem.
   */
  public Shwoop() {
    _shwoop.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Ball in Shwoop", ballSensor.get());
  }

  public void runShwoop(double Shwoopspeed) {
    _shwoop.set(ControlMode.PercentOutput, Shwoopspeed);
  }
  public void stop() {
    _shwoop.set(ControlMode.Disabled, 0.0);
  }
  public boolean shwoopLoaded() {
    return !ballSensor.get();
  }
}
