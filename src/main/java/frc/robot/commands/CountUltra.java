/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Hopper;

public class CountUltra extends Command {
  public CountUltra() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Hopper.ultra1.setAutomaticMode(true);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
<<<<<<< HEAD:src/main/java/frc/robot/commands/CountUltra.java
    //Hopper.checkUltra();
   // System.out.println(Hopper.ultra1.isRangeValid());
    //System.out.println(Hopper.ultra1.getDistanceUnits());
   // System.out.println(Hopper.ultra1.getRangeMM());
   
=======
    Robot.drivetrain.driveAuton(leftSpeed, rightSpeed);
    
>>>>>>> 07fa5d096517a23a344976a6e53209fefd4cc9dd:src/main/java/frc/robot/commands/DriveAuton.java
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.driveAuton(0.0, 0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
