package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;


// i think it run shooter
public class Shooter extends Subsystem {
 TalonSRX _shoot1 = new TalonSRX(RobotMap.shooter1);
 TalonSRX _shoot2 = new TalonSRX(RobotMap.shooter2);

    @Override 
    public void initDefaultCommand() {
        //idk
    }
    
    public void setmotors() {
        _shoot2.follow(_shoot1);
    }
    public void runShooter(double speed) {
        _shoot1.set(ControlMode.PercentOutput, 0.8);
    }
    }

