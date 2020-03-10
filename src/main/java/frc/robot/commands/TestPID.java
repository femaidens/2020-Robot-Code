/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Shooter;

public class TestPID extends Command {
  public int s;
  public TestPID() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    SmartDashboard.putNumber("P", 0.000700);
    SmartDashboard.putNumber("I", 0.000001);
    SmartDashboard.putNumber("D", 0.01);
    SmartDashboard.putNumber("IZone", 100.00);
    SmartDashboard.putNumber("FF", 0.000250);
    SmartDashboard.putNumber("OutputRangeL", 0.0);
    SmartDashboard.putNumber("OutputRangeH", 1.0);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Shooter.shooterPIDController.setP(SmartDashboard.getNumber("P", 0.000700));
    Shooter.shooterPIDController.setI(SmartDashboard.getNumber("I", 0.000001));
    Shooter.shooterPIDController.setD(SmartDashboard.getNumber("D", 0.010000));
    Shooter.shooterPIDController.setIZone(SmartDashboard.getNumber("IZone", 100.00));
    Shooter.shooterPIDController.setFF(SmartDashboard.getNumber("FF", 0.000250));
    Shooter.shooterPIDController.setOutputRange(SmartDashboard.getNumber("OutputRangeL", 0.0), SmartDashboard.getNumber("OutputRangeH", 1.0));
    Shooter.shooterPIDController.setReference(SmartDashboard.getNumber("Shooter Speed", 0.0), ControlType.kVelocity);
    //Shooter.shooterNEO2.follow(Shooter.shooterNEO1, true);
    System.out.println(Shooter.shooterEncoder.getVelocity());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Shooter.shooterNEO1.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
