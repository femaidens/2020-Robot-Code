/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// accelerometer
// abs endc for turret
// abs enc for hood
// limelight on turret, not hood

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.MoveHood;

import java.lang.module.ModuleDescriptor.Requires;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
* Add your docs here.
*/

// Shooter subsystem
public class Shooter extends Subsystem {
  // motors
  //public static CANSparkMax turret = new CANSparkMax(RobotMap.turretPort, MotorType.kBrushless);
  public static CANSparkMax hood = new CANSparkMax(RobotMap.hoodPort, MotorType.kBrushless);
  public static CANSparkMax shooterNEO = new CANSparkMax(RobotMap.shooterPort, MotorType.kBrushless);
  public static CANEncoder shooterEncoder = shooterNEO.getEncoder();
  public static CANPIDController shooterPIDController = shooterNEO.getPIDController();
  public static Joystick joy = new Joystick(0);
  
  public static DigitalInput limitSwitchLeft = new DigitalInput(RobotMap.limitSwitchPort2);
  public static DigitalInput limitSwitchRight = new DigitalInput(RobotMap.limitSwitchPort3);
  
  
  public static double speed;
  
  public Shooter() {
    shooterPIDController.setP(0.1);
    shooterPIDController.setI(0);
    shooterPIDController.setD(0);
    shooterPIDController.setIZone(0);
    shooterPIDController.setFF(0);
    shooterPIDController.setOutputRange(-1, 1);
    speed = 0.5;
  }
  /*
  public static void shooterLimitSwitch(){
    while(limitSwitchLeft.get() == true){
      turret.set(-0.5);
    }
    while(limitSwitchRight.get() == true){
      turret.set(0.5);
    }
    turret.set(0.0);
  }
  
  
  public static void spinTurret(double speed) {
    // double s = joy.getRawAxis(1);
    turret.set(speed);
  }
  */
  public static void spinHood(double speed){
    double s = joy.getRawAxis(1);
    hood.set(s * 0.01);
  }
  public static void spinShooter(double speed) {
    // on the off chance speed is in RPM, this code mightttttt not work
    // shooterPIDController.setReference(speed, ControlType.kVelocity);
    shooterNEO.set(speed);
  }
  
  public static void setSpeed(double s) {
    speed = s;
  }
  
  public static double getSpeed() {
    return speed;
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new MoveHood(0.5));
  }
}
