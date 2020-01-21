/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command{
  private double distance;
  private double angle;
  private double zRotation;
  private double speed;
  
  // current encoder values
  private int currentFLTicks;
  private int currentFRTicks;
  private int currentRLTicks;
  private int currentRRTicks;
  
  //for auton
  public DriveDistance(double d, double v, double angle){
      requires(Robot.drivetrain);	
  speed = v;
  // circ is a place holder.
  int ticksPerRec = frontLeftHall.getCountsPerRevolution();
  int circ = 1;
  distance = (d * ticksPerRev) / circ;
    this.angle = angle;
  }
    
  protected void initialize(){
    // there’s no reset, so subtract from these current ones
  currentFLTicks = Robot.drivetrain.frontLeftHall.getPosition();
  currentFRTicks = Robot.drivetrain.rearLeftHall.getPosition();
  currentRLTicks = Robot.drivetrain.frontRightHall.getPosition();
  currentRRTicks = Robot.drivetrain.rearRightHall.getPosition();
    Robot.drivetrain.gyro.reset();
    
  }
  
  protected void execute(){
    Robot.drivetrain.driveAuton(speed, angle, zRotation);
  }
  
  protected boolean isFinished(){
  return (distance == frontLeftHall.get() - currentFLTicks && distance == frontRightHall.get()- currentFRTicks && distance == rearLeftHall.get() - currentRLTicks && distance == rearRightHall.get() - currentRRTicks);
  }
  
  protected void end(){
    Robot.drivetrain.driveAuton(0, 0, 0);
  Robot.drivetrain.gyro.reset();	
  }
  
  protected void interrupted(){
  }
  }
  
