/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.Climb;

public class MoveClimb extends Command{

  public MoveClimb(){
	  requires(Robot.climb);
	}

	protected void initialize(){
	}

	protected void execute() {
		if(!Climb.limitSwitchB.get()){
			SmartDashboard.putString("Ready?", Climb.ready());
		} 
    Climb.move();
  }

  protected boolean isFinished(){
	  return false;
  }

  protected void end(){
  }
	
  protected void interrupted(){
  }
}