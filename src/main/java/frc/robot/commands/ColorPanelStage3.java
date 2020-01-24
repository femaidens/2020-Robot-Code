/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.ColorMatch;

public class ColorPanelStage3 extends CommandBase {
  String t = DriverStation.getInstance().getGameSpecificMessage();
  edu.wpi.first.wpilibj.util.Color currentColor = ColorPanel.gregory.getColor();
  edu.wpi.first.wpilibj.util.Color target;

  public ColorPanelStage3() {
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
    if(t.equals("R")){
      target = ColorMatch.makeColor(0.143, 0.427, 0.439);
    }
    else if(t.equals("B")){
      target = ColorMatch.makeColor(0.561, 0.232, 0.114);
    }
    else if(t.equals("Y")){
      target = ColorMatch.makeColor(0.197, 0.561, 0.240);
    }
    else if(t.equals("G")){
      target = ColorMatch.makeColor(0.361, 0.524, 0.113);
    }
    ColorPanel.spin.set(0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
    ColorPanel.spin.set(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(ColorPanel.gregory.getColor() == target){
			return true;
		}
		else{
			return false;
		}
  }
}
