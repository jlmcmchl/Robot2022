package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeFourBar extends SubsystemBase {

  private CANSparkMax fourBar;
  private double currPosition;

  public IntakeFourBar() {
    fourBar = new CANSparkMax(Constants.RobotMap.intakeMotorFourBar, MotorType.kBrushless);

    fourBar.restoreFactoryDefaults();

    fourBar.setSmartCurrentLimit(Constants.IntakeConstants.fourBarCurrentLimit);

    fourBar.setIdleMode(CANSparkMax.IdleMode.kBrake);
    fourBar.getPIDController().setP(Constants.IntakeConstants.kP.get());
    fourBar.getPIDController().setFF(Constants.IntakeConstants.kF);
  }

  public void setFourBarPosition(double position) {
    fourBar.getPIDController().setReference(position, CANSparkMax.ControlType.kPosition);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Four Bar Position", currPosition);
    SmartDashboard.putNumber("Four Bar Bus Voltage", fourBar.getBusVoltage());
    SmartDashboard.putNumber("Four Bar Duty Cycle", fourBar.getAppliedOutput());

    fourBar
        .getPIDController()
        .setP(SmartDashboard.getNumber("Four Bar kP", Constants.IntakeConstants.kP.get()));
    fourBar
        .getPIDController()
        .setFF(SmartDashboard.getNumber("Four Bar kF", Constants.IntakeConstants.kF));
    fourBar
        .getPIDController()
        .setReference(SmartDashboard.getNumber("Four Bar Setpoint", 0), ControlType.kSmartMotion);
    fourBar.setSmartCurrentLimit(
        (int) SmartDashboard.getNumber(
            "Four Bar Current Limit", Constants.IntakeConstants.fourBarCurrentLimit));

  }
}
