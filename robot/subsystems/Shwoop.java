/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shwoop extends SubsystemBase {
  VictorSPX _shwoop = new VictorSPX(Constants.shwoop);
  
  /**
   * Creates a new ExampleSubsystem.
   */
  public Shwoop() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runShwoop(double Shwoopspeed) {
    _shwoop.set(ControlMode.PercentOutput, Shwoopspeed);
  }
  public void stop() {
    _shwoop.set(ControlMode.Disabled, 0.0);
  }
}
