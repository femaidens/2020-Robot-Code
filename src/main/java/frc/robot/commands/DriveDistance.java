/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveDistance extends Command{
	private double speed;
  private double distance;
  private double currentZeroRight;
  private double currentZeroLeft;
	
	public DriveDistance(double s, double d){
    		speed = s;
		distance = d;
	}
 
	protected void initialize(){
    currentZeroRight = Drivetrain.rightEncoder.getPosition();
    currentZeroLeft = Drivetrain.leftEncoder.getPosition();
		Drivetrain.driveAuton(0,0);
}	
    
	protected void execute(){
    Drivetrain.driveAuton(speed,speed);
		if((Drivetrain.rightEncoder.getPosition() - currentZeroRight) > (Drivetrain.leftEncoder.getPosition() - currentZeroLeft)){
			  Drivetrain.driveAuton(speed+0.1,speed);
		}

		else if((Drivetrain.rightEncoder.getPosition() - currentZeroRight) < (Drivetrain.leftEncoder.getPosition() - currentZeroLeft)){
			Drivetrain.driveAuton(speed,speed+0.1);
		}
		
		else{
			Drivetrain.driveAuton(speed,speed);
		}
}

	protected boolean isFinished(){
    		if((Drivetrain.rightEncoder.getPosition() - currentZeroLeft) < distance && (Drivetrain.leftEncoder.getPosition() - currentZeroRight) < distance == true){
			return false;
		}

		else{
			return true;
		}
	}

	protected void end(){
    Drivetrain.driveAuton(0.0,0.0);
}

	protected void interrupted(){
		Drivetrain.driveAuton(0.0,0.0);
	}

}
