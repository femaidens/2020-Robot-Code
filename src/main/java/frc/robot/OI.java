/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Climb;

/**
 * Add your docs here.
 */
public class OI {
    public static Joystick joy = new Joystick(RobotMap.joyPort);

    public static Button climbUp = new JoystickButton(joy, 4);
    public static Button climbDown = new JoystickButton(joy, 1);

    public static void bindButtons() {
        climbUp.whileHeld(new Climb(0.5));
        climbDown.whileHeld(new Climb(-0.5));
    }
}
