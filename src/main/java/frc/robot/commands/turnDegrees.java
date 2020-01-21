/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class turnDegrees extends Command{
	
	private int degrees;
	private int speed;

	public turnDegrees(int angle){
		requires(Robot.drivetrain);
		degrees = angle;
	}
 
	protected void initialize(){
    Robot.drivetrain.gyro.reset();
	}
	
	protected void execute(){
		if (Robot.drivetrain.gyro.getAngle() < degrees){
			Robot.drivetrain.driveAuton(0, 0, 1);
		} else { 
			Robot.drivetrain.driveAuton(0, 0, -1);
}
	}

	protected boolean isFinished(){
		return(Robot.drivetrain.gyro.getAngle == degrees);
	}

	protected void end(){
		Robot.drivetrain.driveAuton(0, 0, 0);
		Robot.drivetrain.gyro.reset();
}

	protected void interrupted{
	}
}


