/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Shooter extends SubsystemBase {
  final VictorSPX shoot1 = new VictorSPX(Constants.shoot1);
  final VictorSPX shoot2 = new VictorSPX(Constants.shoot2);

  //constructor method runs upon first schedualing
  public Shooter() {

    shoot2.follow(shoot1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runShooter(double shooterSpeed) {
    shoot1.set(ControlMode.PercentOutput, shooterSpeed);
  }
  public void stop() {
    shoot1.set(ControlMode.PercentOutput, 0.0);
  }
}
