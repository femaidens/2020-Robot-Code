/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
<<<<<<< HEAD
//import frc.robot.subsystems.Climb;
=======
import frc.robot.subsystems.Climb;
>>>>>>> f1bf8631ec753c1b952d1fe4703204f8b90d2fb1
import frc.robot.subsystems.Test;

public class MoveClimb extends Command{

  public MoveClimb(){
<<<<<<< HEAD
    //requires(Robot.climb);
    requires(Robot.test);
=======
    //requires(Robot.climb)//;
    //requires(Robot.test);
>>>>>>> f1bf8631ec753c1b952d1fe4703204f8b90d2fb1
	}

	protected void initialize(){
    System.out.println("Ready");
	}

	protected void execute() {
		/*if(!Climb.limitSwitchB.get()){
			SmartDashboard.putString("Ready?", Climb.ready());
		} 
    Climb.move();*/
    Test.move();
  }

  protected boolean isFinished(){
	  return true;
  }

  protected void end(){
  }
	
  protected void interrupted(){
  }
}
