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
import frc.robot.commands.AbsoluteHood;
import frc.robot.commands.AlignTurret_PID;
import frc.robot.commands.CellIn;
import frc.robot.commands.CellOut;
import frc.robot.commands.CountUltra;
import frc.robot.commands.LiftIntake;
import frc.robot.commands.LowerIntake;
import frc.robot.commands.SpinShooterNEO;
import frc.robot.subsystems.Shooter;

/**
 * Add your docs here.
 */
public class OI {

    public static Joystick joy = new Joystick(0);
    public static Button intake = new JoystickButton(joy, 1);
    //public static Button liftLift = new JoystickButton(joy, 1);
    //public static Button lowerLift = new JoystickButton(joy, 3);
    //public static Button shoot = new JoystickButton(joy, 2);
    //public static Button turret = new JoystickButton(joy, 1);
    //public static Button ultra = new JoystickButton(joy, 1);
    //public static Button hood = new JoystickButton(joy, 1);
    //public static Button intake = new JoystickButton(joy, 1);
    //public static Button test = new JoystickButton(joy, 1);

	public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);
	//public static Button driveStr = new JoystickButton(driveJoystick, 2);
	//public static Button motorTest = new JoystickButton(driveJoystick, 1);
	//public static Button currentLimit = new JoystickButton(driveJoystick, 1);
 // public static Button driveStraight = new JoystickButton(driveJoystick, 1);
  //public static Button testMotors = new JoystickButton(driveJoystick, 1);

	public void bindButtons(){
		//driveStr.whenPressed(new DriveStraight());
		//motorTest.whenPressed(new DriveAuton(0.25, 0.25));
		//currentLimit.whileHeld(new DriveTeleop());
    //  driveStraight.whenPressed(new DriveDistance(0.3, 200.0));
    intake.whileHeld(new CellIn());
		
	}
}
