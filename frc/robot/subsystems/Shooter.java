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
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Shooter extends SubsystemBase {
  final TalonSRX shoot1 = new TalonSRX(Constants.shoot1);
  final TalonSRX shoot2 = new TalonSRX(Constants.shoot2);

  //constructor method runs upon first schedualing
  public Shooter() {
    shoot1.configFactoryDefault();
    shoot1.setInverted(true);
    shoot2.configFactoryDefault();
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
