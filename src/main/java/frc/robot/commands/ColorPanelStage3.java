/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.DriverStation;
import com.revrobotics.ColorMatch;
import edu.wpi.first.wpilibj.command.Command;

public class ColorPanelStage3 extends Command {

  String t = DriverStation.getInstance().getGameSpecificMessage();
  edu.wpi.first.wpilibj.util.Color currentColor = ColorPanel.colorSensor.getColor();
  edu.wpi.first.wpilibj.util.Color target;

  public ColorPanelStage3() {
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    ColorPanel.colorSet(t, target);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    currentColor = ColorPanel.colorSensor.getColor();
    ColorPanel.spin.set(0.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(ColorPanel.colorSensor.getColor() == target){
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
