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
import frc.robot.commands.AlignTurret_PID;
import frc.robot.commands.SpinShooterNEO;
import frc.robot.commands.StopAlign;
import frc.robot.subsystems.Shooter;

/**
 * Add your docs here.
 */
public class OI {
    public static Joystick joy = new Joystick(0);
    public static Button align = new JoystickButton(joy, 1);
    public static Button stopAlign = new JoystickButton(joy, 1);

    public static void bindButtons() {
        System.out.println("bind");
        align.whileHeld(new AlignTurret_PID(0.05));
        stopAlign.whenReleased(new StopAlign());
    }
}
