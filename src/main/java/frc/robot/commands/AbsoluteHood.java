package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Shooter;


public class AbsoluteHood extends Command {
  public double current;
  public double position;
  public AbsoluteHood(double position) {
    this.position = position;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Moving");
    //Shooter.hood.set(0.1);
  }
  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    current = Shooter.absoluteEncoder.get();
    if(current > position){
      Shooter.hood.set(-0.1);
    }else if(current < position){
      Shooter.hood.set(0.1);
    }
    System.out.println(Shooter.absoluteEncoder.get());
  }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //return Shooter.absoluteEncoder.get() > ticks; 
    //negative is positive velocity
    return  Math.abs(position-current) < 0.001;
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
