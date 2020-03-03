/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class MoveHood extends Command {
	public final double SPEED;
	public final double CONVERSION = 10.0;
	public double dx; //Total horizontal distance of the robot to the inner goal
	public double dy = 2.0; //Max height of the parabola, just a placeholder 

	public MoveHood (double s) {
		//requires(Robot.shooter);
		SPEED = s;
	}
	@Override
	protected void initialize() {
		dx = Limelight.getDistance() + 24.5;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double angle = Math.acos((SPEED*dx-4.9*dx)/(dy*SPEED));
		double ticks = angle*CONVERSION;
		Shooter.adjustHood(ticks);
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
