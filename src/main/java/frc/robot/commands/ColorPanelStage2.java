/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;

public class ColorPanelStage2 extends Command {
  //edu.wpi.first.wpilibj.util.Color startColor = ColorPanel.gregory.getColor();
    //edu.wpi.first.wpilibj.util.Color currentColor = ColorPanel.gregory.getColor();
    int count = 0;
  
  public ColorPanelStage2() {
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //currentColor = ColorPanel.gregory.getColor();
    /*if(currentColor == startColor){
      count++;
    }*/
    //ColorPanel.spin.set(0.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    /*if(ColorPanel.gregory.getColor() == startColor && count == 7){
      return true;
    }
    else{
      return false;
    }*/
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
