/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class AlignTurret_PID extends Command {
  private static final double KP = 0.1;
	private static final double KI = 0.0;
	private static final double KD = 0.0;

public static double speed;

private static double min_error = 0.1;
private static double min_command = 0.0;
static double current_error = 0.0; 
static double previous_error = 0.0;
static double integral = 0.0;
static double derivative = 0.0;
static double adjust = 0.0;
static double time = 0.1;

public AlignTurret_PID(double s){
  speed = s;
}


  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.limelight.setLiveStream(0);
    Robot.limelight.setLEDMode(3);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    /*if(!Robot.limelight.objectSighted()){
      return;
     }
       previous_error = current_error;
       current_error = Robot.limelight.getTx();
       integral = (current_error+previous_error)/2*(time);
           derivative = (current_error-previous_error)/time;
           adjust = KP*current_error + KI*integral + KD*derivative;
     
           if (current_error > min_error){
     adjust += min_command;
     }
           else if (current_error < -min_error){
     adjust -= min_command;
       }
           Shooter.spinTurret(speed + adjust);
     
           try {
             Thread.sleep((long)(time*1000));
           }
     catch(InterruptedException e){
           }	*/
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
