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
  //public double speed;
  public SpinShooterNEO(double s){
    //speed = s;
  }
  
  @Override
  protected void initialize(){
    //System.out.println("initialized");
  }
  
  @Override
  protected void execute(){
    //System.out.println("spinning");
    //Shooter.spinShooter(speed);
    //Shooter.hood.set(speed);
  }
  
  @Override
  protected boolean isFinished(){
    return false;
  }
  
  @Override
  protected void end(){
    //System.out.println("stop");
    //Shooter.spinShooter(0);
  }
  @Override
  protected void interrupted(){
    //System.out.println("stop");
    //Shooter.spinShooter(0);
  }
}
  
  
  