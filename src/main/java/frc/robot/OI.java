/*----------------------------------------------------------------------------*/
<<<<<<< HEAD
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
=======
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
>>>>>>> 5084734c33c36dc579372827a1394080b5ad7f51
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
<<<<<<< HEAD
import frc.robot.commands.CellIn;
import frc.robot.commands.SpinShooterNEO;

/**
 * Add your docs here.
 */
public class OI {
    Joystick joy = new Joystick(0);
    Button intakeCell = new JoystickButton(joy, 1);
    Button shoot = new JoystickButton(joy, 2);

    public void bindButtons() {
        intakeCell.whileHeld(new CellIn(.5));
        shoot.whileHeld(new SpinShooterNEO(5));
    }
=======

public class OI {
	public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);
	public void bindButtons(){
	}
>>>>>>> 5084734c33c36dc579372827a1394080b5ad7f51
}
