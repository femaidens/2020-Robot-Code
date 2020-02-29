package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.MoveClimb;

/**
 * Add your docs here.
 */
public class OI {
    public static Joystick atkJoy1 = new Joystick(RobotMap.joyPort1);
    public static Joystick atkJoy2 = new Joystick(RobotMap.joyPort2);
    public static Button test = new JoystickButton(atkJoy1, 1);
    
    public static void bindButtons(){    
        test.toggleWhenPressed(new MoveClimb());
    }
}
