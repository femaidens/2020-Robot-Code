/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;



/**
* Add your docs here.
*/
//Intake Subsystem -- DO LATER WHEN WE KNOW WHAT’S HAPPENING
public class Intake extends Subsystem {
  /*public static CANSparkMax intake = new CANSparkMax(RobotMap.intake, MotorType.kBrushless);
  public static CANSparkMax lift = new CANSparkMax(RobotMap.lift, MotorType.kBrushless);
  public static CANEncoder liftEncoder = lift.getEncoder();
  
  public static DigitalInput limitSwitchIntake = new DigitalInput(RobotMap.limitSwitchPort1);
  
  public Intake(){
  }
  
  public static void intakeLimitSwitch (){
    while(limitSwitchIntake.get() == true){
      lift.set(0.5);
    }
    lift.set(0.0);
  }
  
  public static void spinIn() {
    intake.set(1.0);
    double currentTicks = liftEncoder.getPosition();
    // change 5 with testing
    while (liftEncoder.getPosition() - currentTicks < 5) {
      lift.set(0.5);
    }
    while (liftEncoder.getPosition() - currentTicks > 0) {
      lift.set(-0.5);
    }
  }
  
  public static void spinStop() {
    intake.set(0);
    lift.set(0);
  }
  
  
  public static void spinOut() {
    intake.set(-1.0);
    double currentTicks = liftEncoder.getPosition();
    // change 5 with testing
    while (liftEncoder.getPosition() - currentTicks < 5) {
      lift.set(0.5);
    }
    while (liftEncoder.getPosition() - currentTicks > 0) {
      lift.set(-0.5);
    }
  }
  
  public static void liftIntake(){
    double currentTicks = liftEncoder.getPosition();
    // change 30 with testing
    while (liftEncoder.getPosition() - currentTicks < 30) {
      lift.set(0.5);
    }
    lift.set(0);
  }
  
  public static void lowerIntake(){
    double currentTicks = liftEncoder.getPosition();
    // change 30 with testing
    while (liftEncoder.getPosition() - currentTicks < -30) {
      lift.set(-0.5);
    }
    lift.set(0);
  }
  */

public static TalonSRX intake = new TalonSRX(RobotMap.intake);

public static void spinIn() {
  intake.set(ControlMode.PercentOutput, 1.0);
  
}

public static void spinStop() {
  intake.set(ControlMode.PercentOutput, 0.0);
}


public static void spinOut() {
  intake.set(ControlMode.PercentOutput, -1.0);
  
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}  
