/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Hopper;
import frc.robot.Robot;

public class CountUltra extends Command {
  public double leftSpeed, rightSpeed;

  public CountUltra(double l, double r) {
    leftSpeed = l;
    rightSpeed = r;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   // Hopper.ultra1.setAutomaticMode(true);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Hopper.ballPassedIn();
    //Hopper.checkUltra();

   // System.out.println(Hopper.ultra1.isRangeValid());
    //System.out.println(Hopper.ultra1.getDistanceUnits());
   // System.out.println(Hopper.ultra1.getRangeMM());
   

    
    

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
