/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTeleop extends Command {
  public class DriveTeleop extends Command{
    public DriveTeleop(){
    }
    protected void initialize(){
    }
  protected void execute(){
    Robot.drivetrain.driveTeleop();
    }
    protected boolean isFinished(){
      return false;
    }
    protected void end(){
      Robot.drivetrain.driveAuton(0, 0, 0);
    }
    protected void interrupted(){
    }
  }
  
