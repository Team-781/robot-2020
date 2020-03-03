package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Runclimber;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class Climber extends Subsystem {
VictorSPX _Climber1 = new VictorSPX(RobotMap.climber1);
VictorSPX _Climber2 = new VictorSPX(RobotMap.climber2);


    public void initDefaultCommand() {
        setDefaultCommand(new Runclimber());

    }

    public void Climber_() {
        _Climber2.follow(_Climber1);
    }

    public void Runclimber() {
        _Climber1.set(ControlMode.PercentOutput, RobotMap.Climberspeed);
        _Climber2.set(ControlMode.PercentOutput, RobotMap.Climberspeed);
    }

public void stop() {
    _Climber1.set(ControlMode.Disabled, 0.0);

}

}
