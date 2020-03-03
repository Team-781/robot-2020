package frc.robot.subsystems;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Intake extends Subsystem {
VictorSPX _intake = new VictorSPX(RobotMap.intake);
TalonSRX _arm = new TalonSRX(RobotMap.arm);
@Override 
public void initDefaultCommand() {
    //idk
}

public void runIntake(double intakeSpeed) {
    _intake.set(ControlMode.PercentOutput, intakeSpeed);
}
public void stop() {
    _intake.set(ControlMode.PercentOutput, 0.0);
}
}