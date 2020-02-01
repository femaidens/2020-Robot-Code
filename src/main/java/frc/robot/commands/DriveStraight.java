/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
  public double initialRightTicks;
  public double initialLeftTicks;
  public double currentLeftTicks, currentRightTicks;
  public DriveStraight() {
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    initialRightTicks = Drivetrain.rightEncoder.getPosition();
		initialLeftTicks = Drivetrain.leftEncoder.getPosition();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivetrain.driveStraight();
    currentLeftTicks = Drivetrain.leftEncoder.getPosition() - initialLeftTicks;
    currentRightTicks = Drivetrain.rightEncoder.getPosition() - initialRightTicks;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Drivetrain.driveAuton(0, 0);
    initialRightTicks = Drivetrain.rightEncoder.getPosition();
		initialLeftTicks = Drivetrain.leftEncoder.getPosition();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Drivetrain.driveAuton(0, 0);
    initialRightTicks = Drivetrain.rightEncoder.getPosition();
		initialLeftTicks = Drivetrain.leftEncoder.getPosition();
  }
}
