/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Shooter;

public class MoveHood extends Command {
	double speed;
public MoveHood (double s) {
	speed = s;
}
@Override
protected void initialize() {
}

// Called repeatedly when this Command is scheduled to run
@Override
protected void execute() {
//Shooter.spinHood(speed);
}

// Make this return true when this Command no longer needs to run execute()
@Override
protected boolean isFinished() {
return false;
}

// Called once after isFinished returns true
@Override
protected void end() {
	//Shooter.spinHood(0);
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
@Override
protected void interrupted() {
	//Shooter.spinHood(0);
}
}


