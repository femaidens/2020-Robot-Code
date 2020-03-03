/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
 
public class CellIn extends Command{
  //Timer timer;
//double time;
 // static int numTimesCalled = 0;
  public CellIn(){
   // timer = new Timer();
  //  time = t;
   // numTimesCalled++;
  }
  
  @Override
  protected void initialize(){
    System.out.println("initilaize");
   // timer.reset();
   // timer.start();
  }
  
  @Override
  protected void execute(){

    Intake.spinIn();
   // Hopper.spinIn();

    /*Intake.spinIn();
    Hopper.spinIn();*/
    //Intake.spinIn();
    System.out.println("execute");
  }
  
  
  @Override 
  protected boolean isFinished(){
   /* if (numTimesCalled > 1) {
      // teleop
      return false;
    } else {
      // auton
      return (time >= timer.get());
    } */
    return false;
  }
      
      
  @Override 
  protected void end(){
    /*double currentTime = timer.get();
    Hopper.spinStop();
    while (timer.get() - currentTime < 0.5) {
      Intake.spinOut();
    }
    */
    //Intake.spinStop();
   // timer.stop();

    //Intake.spinStop();
  }
        
  @Override 
  protected void interrupted(){
    /*Intake.spinStop();
    Hopper.spinStop();
    timer.stop();*/

    Intake.spinStop();
  }
}
      