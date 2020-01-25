/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

public class DriveStraight extends CommandBase {
  /**
   * Creates a new DriveStraight.
   */
  double initialRightTicks;
  double initialLeftTicks;
  public DriveStraight() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initialRightTicks = Drivetrain.rightEncoder.getPosition();
		initialLeftTicks = Drivetrain.leftEncoder.getPosition();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { //double currentLeftTicks = Drivetrain.leftEncoder.getPosition() - initialLeftTicks;
    if (Drivetrain.leftEncoder.getPosition() > Drivetrain.rightEncoder.getPosition()) {
      Drivetrain.frontLeft.set(0.5);
      Drivetrain.middleLeft.set(0.5);
      Drivetrain.rearLeft.set(0.5);
		} else if (Drivetrain.rightEncoder.getPosition() > Drivetrain.leftEncoder.getPosition()) {
      Drivetrain.frontRight.set(0.5);
      Drivetrain.middleRight.set(0.5);
      Drivetrain.rearRight.set(0.5);
    }
    double currentLeftTicks = Drivetrain.leftEncoder.getPosition() - initialLeftTicks;
    double currentRightTicks = Drivetrain.rightEncoder.getPosition() - initialRightTicks;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Drivetrain.driveAuton(0, 0);
    initialRightTicks = Drivetrain.rightEncoder.getPosition();
		initialLeftTicks = Drivetrain.leftEncoder.getPosition();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
