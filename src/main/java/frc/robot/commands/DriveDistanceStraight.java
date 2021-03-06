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

public class DriveDistanceStraight extends Command {
  public double initialRightTicks;
  public double initialLeftTicks;
  public double currentLeftTicks, currentRightTicks;
  public double distance;
  public double speed;
  public static double conversionFactor = 1; // change later
  public DriveDistanceStraight(double s, double d) {
    requires(Robot.drivetrain);
    distance = d * conversionFactor;
    speed = s;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //initialRightTicks = Drivetrain.rightEncoder.getPosition();
    //initialLeftTicks = Drivetrain.leftEncoder.getPosition();
    System.out.println("Initialized");
    System.out.println(currentLeftTicks);
    System.out.println(currentRightTicks);
    
   // Drivetrain.rightEncoder.setPosition(0.0);
   /// Drivetrain.leftEncoder.setPosition(0.0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivetrain.driveStraight(speed);
    //System.out.println("Right: " + Math.abs(Drivetrain.rightEncoder.getPosition()));
    //System.out.println("Left: " + Math.abs(Drivetrain.leftEncoder.getPosition()));

    //currentLeftTicks = Drivetrain.leftEncoder.getPosition() - initialLeftTicks;
    //currentRightTicks = Drivetrain.rightEncoder.getPosition() - initialRightTicks;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false; //Math.abs(Drivetrain.leftEncoder.getPosition() - initialLeftTicks) > distance && Math.abs(Drivetrain.rightEncoder.getPosition() - initialRightTicks) > distance;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Drivetrain.driveAuton(0, 0);
    /*initialRightTicks = Drivetrain.rightEncoder.getPosition();
		initialLeftTicks = Drivetrain.leftEncoder.getPosition();*/
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Drivetrain.driveAuton(0, 0);
    /*initialRightTicks = Drivetrain.rightEncoder.getPosition();
		initialLeftTicks = Drivetrain.leftEncoder.getPosition();*/
  }
}
