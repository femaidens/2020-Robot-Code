/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Shooter;


public class AbsoluteHood extends Command {

  public double ticks;
  public int rev = 0;
  public AbsoluteHood(double desiredTicks) {
    ticks = desiredTicks;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Moving");
    Shooter.hood.set(0.1);
  }
  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double initial = Shooter.absoluteEncoder.get();
    if(initial > Shooter.absoluteEncoder.get()){
      rev++;
    }
    System.out.println(Shooter.absoluteEncoder.get());
    System.out.println(rev);
  }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //return Shooter.absoluteEncoder.get() > ticks; 
    //negative is positive velocity
    return false;
  }
  
  // Called once after isFinished returns true
  @Override
  protected void end() {
    Shooter.hood.set(0.0);
  }
  
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
   Shooter.hood.set(0.0);
  }
}