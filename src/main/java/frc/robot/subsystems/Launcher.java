// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.cheese;

public class Launcher extends SubsystemBase {
  private final Servo le_servo = new Servo(cheese.servo.SERVO_ID);
  
  /** Creates a new Launcher. */
  public Launcher() {
    
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setServoAngle(Double servoangle){
    le_servo.setAngle(servoangle);


  }
}
