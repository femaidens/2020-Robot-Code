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
import frc.robot.commands.CellIn;
import frc.robot.commands.SpinShooterNEO;
import frc.robot.subsystems.Shooter;

/**
 * Add your docs here.
 */
public class OI {
    Joystick joy = new Joystick(0);
   // Button intakeCell = new JoystickButton(joy, 1);
    Button shoot = new JoystickButton(joy, 2);

    public void bindButtons() {
        //intakeCell.whileHeld(new CellIn(.5));
        shoot.toggleWhenPressed(new SpinShooterNEO(Shooter.getSpeed()));
    }
}
