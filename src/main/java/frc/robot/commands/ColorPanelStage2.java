/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;
import frc.robot.Subsystems.*;
import edu.wpi.first.wpilibj.command.Command;

public class ColorPanelStage2 extends Command {
  edu.wpi.first.wpilibj.util.Color startColor = ColorPanel.colorSensor.getColor();
  edu.wpi.first.wpilibj.util.Color currentColor = ColorPanel.colorSensor.getColor();
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
    currentColor = ColorPanel.colorSensor.getColor();
    if(currentColor == startColor){
      count++;
    }
    ColorPanel.spin.set(0.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(ColorPanel.colorSensor.getColor() == startColor && count == 7){
      return true;
    }
    else{
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    ColorPanel.spin.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
