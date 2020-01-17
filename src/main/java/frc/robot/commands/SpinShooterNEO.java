/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Shooter;

public class SpinShooterNEO extends Command{
  double speed;
  public SpinShooterNEO(double s){
    speed = s;
  }
  
  @Override
  protected void initialize(){
  }
  
  @Override
  protected void execute(){
    Shooter.spinShooter(speed);
  }
  
  @Override
  protected boolean isFinished(){
    return false;
  }
  
  @Override
  protected void end(){
    Shooter.spinShooter(0);
  }
  @Override
  protected void interrupted(){
    Shooter.spinShooter(0);
  }
}
  
  
  