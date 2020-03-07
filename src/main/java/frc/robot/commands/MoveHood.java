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
	public double dy = 31.0; //Vertical Distance

	public MoveHood() {
		//requires(Robot.shooter);
		//SPEED = (Shooter.shooterEncoder.getVelocity()*6*Math.PI)/60;
		SPEED = 148.597;
	}
	@Override
	protected void initialize() {
		System.out.println("Angle");
		dx = Limelight.getDistance() + 24.5;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//double angle = Math.acos(Math.abs((SPEED*dx-4.9*dx))/(dy*SPEED));
		double ratio = Math.pow(dx, 2)/Math.pow(SPEED, 2);
		double det = Math.pow(dx, 2) - 19.6*ratio*(dy+4.9*ratio);
		//double angle1 = Math.atan((dx+Math.sqrt(det))/(-9.8*ratio));
		double angle2 = Math.atan((dx-Math.sqrt(det))/(-9.8*ratio));
		//System.out.println("Angle(+): " + angle1);
		System.out.println("Angle(-): " + angle2);
		/*System.out.println("Speed: " + SPEED);
		System.out.println("dx: " + dx);
		System.out.println("Num: " + (dx*19.6));
		System.out.println("Denom: " + SPEED*SPEED);
		System.out.println("Angle: " + angle);*/
		//double ticks = angle*CONVERSION;
		//Shooter.adjustHood(ticks);
		//Shooter.spinHood(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
	return true;
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


