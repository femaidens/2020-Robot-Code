package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Shooter;


public class AbsoluteHood extends Command {
  public double position;

  public double current_error;
  public double previous_error;
  public final double KP = 0.1;
  public final double KI = 1e-3;
  public final double KD = 0.0;
  public double derivative = 0.0;
  public double integral = 0.0;
  public double adjust = 0.0;
  public double time = 0.1;

  public AbsoluteHood(){
    SmartDashboard.putNumber("Position", 0.0);
    position = SmartDashboard.getNumber("Position", 0.0);
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
    previous_error = current_error;
    current_error = Shooter.absoluteEncoder.get() - position;
    integral = (current_error + previous_error) / 2 * time;
    derivative = (current_error - previous_error) / time;
    adjust = (KP * current_error + KI * integral + KD * derivative) * -0.1;
    System.out.println("Adjust: " + adjust);
    Shooter.hood.set(adjust*100);
    /*current = Shooter.absoluteEncoder.get();
    if(current > position){
      Shooter.hood.set(-0.1);
    }else if(current < position){
      Shooter.hood.set(0.1);
    }*/
    System.out.println(Shooter.absoluteEncoder.get());


  }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //return Shooter.absoluteEncoder.get() > ticks; 
    //negative is positive velocity
    return  false;
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
