/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DriveAuton;
import frc.robot.commands.DriveStraight;
import frc.robot.commands.DriveTeleop;
import frc.robot.commands.DriveDistance;

public class OI {
	public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);
	//public static Button driveStr = new JoystickButton(driveJoystick, 2);
	//public static Button motorTest = new JoystickButton(driveJoystick, 1);
	//public static Button currentLimit = new JoystickButton(driveJoystick, 1);
	public static Button driveStraight = new JoystickButton(driveJoystick, 1);

	public void bindButtons(){
		//driveStr.whenPressed(new DriveStraight());
		//motorTest.whenPressed(new DriveAuton(0.25, 0.25));
		//currentLimit.whileHeld(new DriveTeleop());
		driveStraight.whenPressed(new DriveDistance(0.3, 200.0));

		
	}
}
