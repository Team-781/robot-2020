package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class Climber extends SubsystemBase {
VictorSPX _Climber1 = new VictorSPX(Constants.climber1);
VictorSPX _Climber2 = new VictorSPX(Constants.climber2);


    public void initDefaultCommand() {
    }

    public void Climber_() {
        _Climber2.follow(_Climber1);
        _Climber1.setNeutralMode(NeutralMode.Brake);
        _Climber2.setNeutralMode(NeutralMode.Brake);
    }

    public void runClimber(double climberSpeed) {
        _Climber1.set(ControlMode.PercentOutput, climberSpeed);
    }

public void stop() {
    _Climber1.set(ControlMode.Disabled, 0.0);
}

}