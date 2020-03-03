package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Intake extends SubsystemBase {
VictorSPX _intake = new VictorSPX(Constants.intake);
TalonSRX _arm = new TalonSRX(Constants.arm);

public void initDefaultCommand() {
    //idk
}
public Intake() {
    _intake.setInverted(true);
}

public void runIntake(double intakeSpeed) {
    _intake.set(ControlMode.PercentOutput, intakeSpeed);
}
public void stop() {
    _intake.set(ControlMode.PercentOutput, 0.0);
}
}