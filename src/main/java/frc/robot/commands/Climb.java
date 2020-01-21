/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Climber;

public class Climb extends Command {
  /**
   * Creates a new Climb.
   */
  double speed;
  public Climb(double s) {
    // Use addRequirements() here to declare subsystem dependencies.
    speed = s;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Climber.spin(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {
    Climber.spin(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  protected void interrupted() {
    Climber.spin(0);
  }
}
