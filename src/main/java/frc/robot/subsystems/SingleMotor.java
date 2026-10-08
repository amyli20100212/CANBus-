// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.CANBus.CANBusStatus;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.GeneralConstants.*;

public class SingleMotor extends SubsystemBase {
  private final TalonFX motor = new TalonFX(MOTOR_ID, CAN_BUS);

  /** Creates a new SingleMotor. */
  public SingleMotor() {
    TalonFXConfiguration config = new TalonFXConfiguration();
    motor.getConfigurator().apply(config);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run         
    CANBusStatus canInfo = CAN_BUS.getStatus();
    float busUtil = canInfo.BusUtilization;
    SmartDashboard.putNumber("CANBus utilization", busUtil);
    
    if (busUtil > 0.8) {
      System.out.println("CAN bus utilization is greater than 80%!");
    }

  }

  public void setMotorSpeed(double voltage)
  {
    motor.setVoltage(voltage);
  }

  public void stopMotor(){
    motor.setVoltage(0);
  }
  
}



