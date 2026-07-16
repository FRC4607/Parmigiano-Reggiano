package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.commands.drivedrive;
import frc.commands.setservoangle;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Launcher;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import java.util.function.DoubleSupplier;

import com.pathplanner.lib.auto.NamedCommands;

public class RobotContainer {
    final CommandXboxController m_controller = new CommandXboxController(cheese.controller.controllerid); 
    private final Drive cheeseDrive = new Drive();
    private final Launcher m_launcher = new Launcher();
    Trigger aButton;
    DoubleSupplier leftsticky;
    DoubleSupplier rightsticky;

    
    public RobotContainer(){
        
        aButton = m_controller.x();
        cheeseDrive.setDefaultCommand(new drivedrive(m_controller, cheeseDrive));
        m_launcher.setDefaultCommand(new setservoangle(m_controller, m_launcher));

        
    }

    

}
