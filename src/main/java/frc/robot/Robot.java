// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.cheese;
import frc.robot.cheese.servo;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;  

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.Faults;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  
  
  private static Robot robotInstance;
  private static RobotContainer robotContainer;
  public static long timercount;
  
  public static Robot getRobotInstance(){
    return robotInstance;
  }
  

  


  
  
  
  
  






  /** Called once at the beginning of the robot program. */
  public Robot() {
    robotInstance = this;
    robotContainer = new RobotContainer();
    timercount = 0;
    
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    /**
     askii cheese art (a must have)
    
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
                                                                           :-=-:.                                                      
                                                                         :=**++***+=-:.                                                
                                                                       .-+*=-:-=+++*****+=:..                                          
                                                                     .:=*+-........:=+***####*+=:..                                    
                                                                   .:=*+-...............:-+*#######*+-..                               
                                                                  .-++=:.....................:-=*###%%###*=:..                         
                                                                .-+*+:............:::::............:-+#%%%###*=:                       
                                                              .:=++-...........-+*#*+:.:................:-=*%@@%-                      
                                                             .-++-:........:-+%%@@@@@#=.::.................-+#@@@-                     
                                                             :+=:.........-*#%%#+-:-=#*.::...............:+*+-:@@@:                    
                                                             -+-......:..-#%#*===-:-*%+.::... .......:..-+*=:..:@@#.                   
                                                           .:=+:.........*%+=----=*%@=.::.........:-:.-+++-:....-@@+                   
                                                         .:=++-..........*#*+*%@@@@#-:..::=+***+=-:::-*+=:.......+@@-                  
                                                   .:=++++**+:...........=#@@@@@@@+:...-+*#***+++==-:++-..........%@%.                 
                                                 .:=++++++=:........::::..-==-:..:..:=*##+=:...-===-:*+:..  ......-@@+                 
                                                :-++=:...........-*#%%%#*=:.::.....=*#*+=-:::.-+**+=-#+:...........+@@.                
                                              .-++=-....  .....-*%@%##*+++=::::...=**+---:::::+#+=-.=#+:............@@=                
                                            .-=+=-............+%@#=-:.-++=-::-.:.-**-:::::::-+*+--::*#+=--:.........*@%                
                                           .-+=-.............=%%+-:::-+#*+:.::.:.+*-::::::.-=*+---:=%#*==--:........:@@:               
                                           :+=:...   ..   ...=#+:::.-*%#-::::...:*+:::.....-+*-::-:*%*=-:---:.   ....#@*               
                                          .=+:...............-%@@@@@@@%=.::::...:**::::...:-+*-:::+##=-::---:........-@@.              
                                       ..-++=...............::-++=--:=#@%*-:-:...=#+-::.:::--+=--+*+=-==-=--.........-@@.              
                                  .:=++++++-............  ...=#@@@@@@@@%%@%=::...:+%#+-----:-++.=*=.:==++=-...   ....-@@:              
                                .:=+++++=-.................-%@@%*=:::....-@#:::...:-=++++**+==-=*=::..::-:.. ........:@@-              
                              .:=++=:.....................=%@*=----:::...-@*:::.:=**+-..:::..-++-..::.................%@=              
                            .:=++-:...............   ....-%%=--::..::::-+%@-:::-++=-::-----=--:...:::..... ...........#@+              
                          .:-++-..:.....::::............:+@+-:::..::::+#@%=:==**+-:.............:..-=+=-.............:*@*              
                         .-++=:......:+%@@@%#=.::........+%*=:...-+%@@@%+:-+***=:..............:::=+++++=............:*@#              
                       .-=+=:......:+@@@%###%%-::.   ....-*@@@@@@@@@@%*-.+#%*=:...............::.-=::.:-+-.....  .....*@#              
                     .-=+=:.......-#@@*=:..=%%:::.........:=%@@@@@#-..:-*##+:....-+*#*=:......:::===-..-=-............*@#              
                   .-+++-........-%@#=---:+@@+.:............::::::::::=*#*-... -#%%%%##*-..:...:.-=++====:............*@#              
                 .-++=-.....   ..=%#-..+%@@@-.:...   ..............:=**+=:....=%@*-..:=*+:.....:::-=+++=:.::..........*@#              
              ..-+*+-............-%@@@@@@@#:::....   ........:-===-=++=:.....-#%-.....:+*-.....:-:..:-:........:.....:#@#              
            ..-+*+-.............::-*%@%+::-:......   .....:=*%%%%*==+-::.....+%=......:**-......:-=--:::........:....:%@*              
           .-+*+-..................:::::::...    ..  ..:.-*%%*+==+:-=:.......*#:......-*+:........:::::..........:::..@@=              
        .-=+*+-..............................    .......=#%*-...+*-==:.......*#:....:=**-..................:......:::+@@-              
      .-+**+-..................::..---:......   .......-#%+:...-#+-+=........+%+:..:+*+-................::::::.-*@@@@@@#:              
     .-=+-....... ...........-=+=------......   .......+%+:...:++:*+:......:::*%###%#+-.......  .....:::.:#@@@@@@@@@@@*:               
     .==::--:.. ............=*#*===::=-..............:.+#+-:=++=:**-.........:.-+**+-.........::-::*@@@@@@@@@@@@@*-.                   
     .=+=:....:::..........:**--=+=-==:..............:.=++=--:.-++-...........::::::::::::::=*%@@@@@@@@@@@#-.                          
     .:=++--:........ .....:+*#*+-:--:................-*#+-:-++=-:.............::..:..-*@@@@@@@@@@@%=.                                 
        .-=+++=-::-:.:.....::=+=-...................:+#%*=---:..................:*@@@@@@@@@@@#=:.                                      
           .:=++++=-.::...:..................   ..:=#%#+:..............::::+@@@@@@@@@@@%=:.                                            
               .-+*#*=-.::.::::::......   .......-*%%+-..............-*@@@@@@@@@@@=:.                                                  
                  .:+##**=:....::--:..........:-+##*-......:-:::-#@@@@@@@@@@+:.                                                        
                     .-+*#*+=-::::.:::.......-+##*=:....::..*@@@@@@@@@%+:                                                              
                         .=****+=.:-:...:...-+#*=:....:*@@@@@@@@@%-.                                                                   
                            .:=*##+=-.:----=**+-.=#@@@@@@@@@@=:                                                                        
                                .-+###+=:..-+%@@@@@@@@@%+:.                                                                            
                                   .:=*####%@@@@@@#=.                                                                                  
                                       .-=++=:.                                                                                        
                                                                                                                                           
    
    
    
    
    
**/

    
    
    


    
  }
  
    
 
  @Override
  public void teleopPeriodic() {
    timercount += 1;
    
   
    
    
    
  }
  @Override
  public void robotPeriodic(){
    CommandScheduler.getInstance().run();
  }
  @Override
  public void robotInit(){

  }
}
