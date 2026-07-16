package frc.robot.subsystems;
import frc.robot.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase{
    TalonSRX _talonleft0;
  VictorSPX _victorleft0;
  VictorSPX _victorleft1;
  
  


  TalonSRX _talonright0;
  VictorSPX _victorright0;
  VictorSPX _victorright1;


  public Drive() {
    _talonleft0 = new TalonSRX(cheese.drive.DRIVER_TALON_ID);
  _victorleft0 = new VictorSPX(cheese.drive.DRIVER_VECTOR_ID);
  _victorleft1 = new VictorSPX(cheese.drive.DRIVER_VECTOR2_ID);
  
  


  _talonright0 = new TalonSRX(cheese.drive.PASSENGER_TALON_ID);
  _victorright0 = new VictorSPX(cheese.drive.PASSENGER_VECTOR_ID);
 _victorright1 = new VictorSPX(cheese.drive.PASSSENGER_VECTOR2_ID);
 _victorleft0.follow(_talonleft0);
    _victorleft1.follow(_talonleft0);


    _victorright0.follow(_talonright0);
    _victorright1.follow(_talonright0);
  }

  public void setDriveSpeeds(double leftSpeed, double rightSpeed) {
    _talonleft0.set(ControlMode.PercentOutput, leftSpeed);
    _talonright0.set(ControlMode.PercentOutput, rightSpeed);



  }











}
