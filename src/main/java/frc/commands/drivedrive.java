package frc.commands;

import java.util.function.DoubleSupplier;

import javax.naming.directory.DirContext;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.cheese;
import frc.robot.cheese.drive;
import frc.robot.subsystems.Drive;

public class drivedrive extends Command{
    private Drive m_drive;
    private DoubleSupplier m_leftSpeed;
    private DoubleSupplier m_rightspeed;
    private CommandXboxController m_controller;


    public drivedrive(CommandXboxController controller, Drive drive){
        m_drive = drive;
        m_controller = controller;
        addRequirements(m_drive);
        
        


    }
    @Override
    public void initialize(){
        


    }
    @Override
    public void execute(){
        if (cheese.drive.CONTROLL_WITH_ONE_STICK){
            m_drive.setDriveSpeeds(((-m_controller.getRightX() * 0.5) + m_controller.getLeftY()) * 1, ((-m_controller.getRightX() * 0.5) - m_controller.getLeftY()) * 1);

        } else {
        m_drive.setDriveSpeeds(m_controller.getLeftY(), -m_controller.getRightY());
        }
    }
    @Override
    public void end(boolean interrupted){

    }
    public boolean isFinished() {
        return false;
    }












}
