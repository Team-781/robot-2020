package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;


// i think it run shooter
public class Shooter extends Subsystem {
    TalonSRX _shoot1, _shoot2;
    
    public Shooter() {
        TalonSRX _shoot1 = new TalonSRX(RobotMap.shooter1);
        TalonSRX _shoot2 = new TalonSRX(RobotMap.shooter2);       
        _shoot2.follow(_shoot1);
    }
    public void runShooter(double shooterSpeed) {
        _shoot1.set(ControlMode.PercentOutput,shooterSpeed);
    }

    public void stop(){
        _shoot1.set(ControlMode.Disabled, 0.0);
    }    
  public void initDefaultCommand() {
      //idk
    }
}

