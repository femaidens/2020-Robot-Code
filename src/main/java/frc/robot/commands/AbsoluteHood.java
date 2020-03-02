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
<<<<<<< HEAD
    double initial = Shooter.absoluteEncoder.get();
    if(initial > Shooter.absoluteEncoder.get()){
      rev++;
    }
    System.out.println(Shooter.absoluteEncoder.get());
    System.out.println(rev);
=======
   // Shooter.hood.set(0.1); 
>>>>>>> 6c7c817d132203654bee8f7f22819d2f2d00a869
  }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
<<<<<<< HEAD
    return rev * 2048 + Math.abs(Shooter.absoluteEncoder.get()) > ticks;
=======
    return Shooter.absoluteEncoder.get() > ticks; //negative is positive velocity
>>>>>>> 6c7c817d132203654bee8f7f22819d2f2d00a869
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
   //Shooter.hood.set(0.0);
  }
}
