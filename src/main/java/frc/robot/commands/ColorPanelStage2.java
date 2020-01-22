/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ColorPanelStage2 extends CommandBase {
    edu.wpi.first.wpilibj.util.Color startColor = ColorPanel.gregory.getColor();
    edu.wpi.first.wpilibj.util.Color currentColor = ColorPanel.gregory.getColor();
    int count = 0;
  /**
   * Creates a new ColorPanelStage2.
   */
  public ColorPanelStage2() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentColor = ColorPanel.gregory.getColor();
    if(currentColor == startColor){
      count++;
    }
    ColorPanel.spin.set(0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ColorPanel.spin.set(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(ColorPanel.gregory.getColor() == startColor && count == 7){
      return true;
    }
    else{
      return false;
    }
  }
}
