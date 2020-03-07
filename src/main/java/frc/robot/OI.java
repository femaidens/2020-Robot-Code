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
import frc.robot.commands.ShiftToPower;
import frc.robot.commands.ShiftToSpeed;
import frc.robot.commands.ToggleCompressor;

public class OI {
	public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);
	//public static Button driveStr = new JoystickButton(driveJoystick, 2);
	//public static Button motorTest = new JoystickButton(driveJoystick, 1);
	//public static Button currentLimit = new JoystickButton(driveJoystick, 1);
//	public static Button driveStraight = new JoystickButton(driveJoystick, 1);
	public static Button shiftToPower = new JoystickButton(driveJoystick, 1);
	public static Button shiftToSpeed = new JoystickButton(driveJoystick, 2);
	public static Button comp = new JoystickButton(driveJoystick, 3);

	public void bindButtons(){
		//driveStr.whenPressed(new DriveStraight());
		//motorTest.whenPressed(new DriveAuton(0.25, 0.25));
		//currentLimit.whileHeld(new DriveTeleop());
		//driveStraight.whenPressed(new DriveDistance(0.3, 200.0));;
		//shiftToPower.whileHeld(new ShiftToPower());
		shiftToPower.whenPressed(new ShiftToPower());
		shiftToSpeed.whenPressed(new ShiftToSpeed());
		//shiftToSpeed.whenPressed(new ShiftToSpeed());
		//comp.whenPressed(new ToggleCompressor());
		
	}
}
