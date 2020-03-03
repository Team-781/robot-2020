package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Intake extends Subsystem {
VictorSPX _intake = new VictorSPX(RobotMap.intake);

@Override 
public void initDefaultCommand() {
    //idk
}

    

public void runIntake(double speed) {
    _intake.set(ControlMode.PercentOutput, RobotMap.intakeSpeed);
}
}