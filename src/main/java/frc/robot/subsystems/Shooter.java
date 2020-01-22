/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
* Add your docs here.
*/

// Shooter subsystem
public class Shooter extends Subsystem {
  // motors
  public static CANSparkMax turret = new CANSparkMax(RobotMap.turretPort, MotorType.kBrushless);
  public static CANSparkMax hood = new CANSparkMax(RobotMap.hoodPort, MotorType.kBrushless);
  public static TalonSRX shooterNEO = new TalonSRX(RobotMap.shooterPort);
  public static Joystick joy = new Joystick(0);
  
  public Shooter() {
  }
  
  public static void spinTurret(double speed) {
    double s = joy.getRawAxis(1);
    turret.set(s);
  }
  
  public static void spinHood(double speed){
    double s = joy.getRawAxis(5);
    hood.set(s);
  }
  public static void spinShooter(double speed){
    shooterNEO.set(ControlMode.PercentOutput, speed);
  }
  
  
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
