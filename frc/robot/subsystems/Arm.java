/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Arm extends SubsystemBase {
  /**
   * Creates a new Arm
   * 1 motor -> TalonSRX(22)
   * 1 analog encoder
   */

   private TalonSRX m_arm = new TalonSRX(Constants.arm);
   private int m_position;

  public Arm() {
    //TalonSRX m_arm = new TalonSRX(Constants.arm);
    //TalonSRX m_arm = new TalonSRX(22);

    m_arm.configFactoryDefault();
    m_arm.configSelectedFeedbackSensor(FeedbackDevice.Analog);

    // these parameters should be moved to constants
    m_arm.config_kP(0, 17.0);
    m_arm.config_kI(0, 0.0);
    m_arm.config_kD(0, 100.0);
    m_arm.config_kF(0, 0.0);
    m_arm.config_IntegralZone(0,0);
    m_arm.setInverted(true);
    m_arm.setSensorPhase(true);
    // soft limits - to be determined by experiment
    m_arm.configReverseSoftLimitThreshold(25); // lower limit
    m_arm.configForwardSoftLimitThreshold(660); // upper limit
    // motion magic acceleration and cruise velocity
    m_arm.configMotionAcceleration(15);
    m_arm.configMotionCruiseVelocity(30);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Arm Position", m_arm.getSelectedSensorPosition());
  }

  /**
   * move arm to requested position
   * note: no checks are made for boundaries
   * @param Position - raw position in counts
   */
  public void goArm(int position){
    m_position = position;
    //m_arm.set(ControlMode.Position, m_position);
    m_arm.set(ControlMode.MotionMagic, m_position);
}

  /**
   * get current arm position
   * @return - integer - raw position
   */
  public int getArmPosition(){
    return m_arm.getSelectedSensorPosition();
  }

  /**
   * test to see if arm is in final position
   * @return bpplean - true if in position
   */
  public boolean armDone() {
    int currentPosition = m_arm.getSelectedSensorPosition();
    return ((currentPosition > m_position - 5) && (currentPosition < m_position + 5));
  }

  /**
   * stop arm - disables arm
   */
  public void stopArm(){
    m_arm.set(ControlMode.Disabled, 0.0);
  }
  public void zeroArm(){
    m_arm.setSelectedSensorPosition(25);
  }
}
