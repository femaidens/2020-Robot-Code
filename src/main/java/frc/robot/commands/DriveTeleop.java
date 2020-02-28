/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

public class DriveTeleop extends Command {
  public DriveTeleop() {
    // Use requires() here to declare subsystem dependencies
    //requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Drivetrain.frontLeft.setSmartCurrentLimit(17);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.drivetrain.driveTeleop();
    Drivetrain.frontLeft.set(1.0);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    // Robot.drivetrain.driveAuton(0.0, 0.0);
    Drivetrain.frontLeft.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
   // Robot.drivetrain.driveAuton(0.0, 0.0);
   Drivetrain.frontLeft.set(0.0);
  }
}
