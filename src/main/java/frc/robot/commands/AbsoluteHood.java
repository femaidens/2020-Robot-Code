package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Shooter;


public class AbsoluteHood extends Command {
  //public double current = 0;
  //public double desiredrevs;
  public AbsoluteHood(double revs) {
    //desiredrevs = revs;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //System.out.println("Moving");
    //Shooter.hood.set(0.1);
  }
  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    /*double initial = Shooter.absoluteEncoder.get();
    while((int)desiredrevs!=current){
      if(initial > Shooter.absoluteEncoder.get()){
        current++;
      }
    }
    while(desiredrevs-current > Shoot.absoluteEncoder.get()){

    }

    System.out.println(Shooter.absoluteEncoder.get());
    System.out.println(current);*/
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
    //Shooter.hood.set(0.0);
  }
  
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
   //Shooter.hood.set(0.0);
  }
}
