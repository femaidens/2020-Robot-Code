/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
//Intake Subsystem -- DO LATER WHEN WE KNOW WHAT’S HAPPENING
public class Intake extends Subsystem {
	public static CANSparkMax intake = new CANSparkMax(RobotMap.intake, MotorType.kBrushless);
	public static CANSparkMax lift = new CANSparkMax(RobotMap.lift, MotorType.kBrushless);


//methods

public static void spinOut() {
		intake.set(-1.0);
	}

public static void liftIntake(){
}




  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
