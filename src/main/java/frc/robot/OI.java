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
    public static Button hood = new JoystickButton(joy, 1);
    //public static Button intake = new JoystickButton(joy, 1);
    //public static Button test = new JoystickButton(joy, 1);
    public static void bindButtons() {
        //System.out.println("binding");
        //liftLift.toggleWhenPressed(new LiftIntake());s
        //ultra.whileHeld(new CountUltra());
        System.out.println("Binded");
        //shoot.whileHeld(new SpinShooterNEO(-5300));
        //turret.whenPressed(new AlignTurret_PID(0.02));
        hood.whenPressed(new AbsoluteHood(4096));
        //test.whenPressed(new SpinShooterNEO(0.2));
    }
}
