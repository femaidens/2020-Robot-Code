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

public class CellIn extends Command{
  Timer timer;
  double time;
  static int numTimesCalled = 0;
  public CellIn(double t){
    //timer = new Timer();
    //time = t;
    //numTimesCalled++;
  }
  
  @Override
  protected void initialize(){
    //timer.reset();
    //timer.start();
  }
  
  @Override
  protected void execute(){
    //Intake.spinIn();
    Hopper.spinIn();
  }
  
  
  @Override 
  protected boolean isFinished(){
    //if (numTimesCalled > 1) {
      // teleop
      return false;
      //} else {
        // auton
        //return (time >= timer.get());
        //}
      }
      
      
      @Override 
      protected void end(){
        //double currentTime = timer.get();
        //while (timer.get() - currentTime < 0.5) {
          //Intake.spinOut();
          //}
          //Intake.spinStop();
          Hopper.spinStop();
          //timer.stop();
        }
        
        @Override 
        protected void interrupted(){
          //Intake.spinStop();
          Hopper.spinStop();
          //timer.stop();
        }
      }
      