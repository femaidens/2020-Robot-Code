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
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;



/**
* Add your docs here.
*/
//Intake Subsystem -- DO LATER WHEN WE KNOW WHAT’S HAPPENING
public class Intake extends Subsystem {
  public static CANSparkMax intake = new CANSparkMax(RobotMap.intake, MotorType.kBrushless);
 public static CANEncoder intakeEncoder = intake.getEncoder();
  public static CANPIDController intakePIDController = intake.getPIDController();
  // public static CANSparkMax intake2 = new CANSparkMax(RobotMap.intake2, MotorType.kBrushless); //test (easier for me)
  /*public static CANSparkMax lift = new CANSparkMax(RobotMap.lift, MotorType.kBrushless);
  public static CANEncoder liftEncoder = lift.getEncoder();
  public static CANPIDController liftPID = lift.getPIDController();*/
  /*
  public static DigitalInput limitSwitchIntake = new DigitalInput(RobotMap.limitSwitchPort1);
  */
  public Intake(){
    /*liftPID.setP(0.1);
    liftPID.setI(0);
    liftPID.setD(0);
    liftPID.setIZone(0);
    liftPID.setFF(0);
    liftPID.setOutputRange(-0.2, 0.2);*/
    intakePIDController.setP(4e-4);
    intakePIDController.setI(0);
    intakePIDController.setD(1e-4);
    intakePIDController.setIZone(0);
    intakePIDController.setFF(5e-4);
    intakePIDController.setOutputRange(-0.5, 0.5);
  }
  /*
  public static void intakeLimitSwitch (){
    while(limitSwitchIntake.get() == true){
      lift.set(0.5);
    }
    lift.set(0.0);
  }
  */
  
  public static void spinIn() {
    //System.out.println("spin in");
   intakePIDController.setReference(-800, ControlType.kVelocity);
   System.out.println(intakeEncoder.getVelocity());
    //intake.set(-0.5);
    //intake2.set(-0.5);//test for shooter (easier for me)
    //double currentTicks = liftEncoder.getPosition();
    // change 5 with testing
   /* while (liftEncoder.getPosition() - currentTicks < 5) {
      lift.set(0.5);
    }
    while (liftEncoder.getPosition() - currentTicks > 0) {
      lift.set(-0.5);
    }*/
  }
  
  public static void spinStop() {
    intake.set(0);
    //lift.set(0);
  }
  
  
  public static void spinOut() {
    intake.set(-.2);
    //double currentTicks = liftEncoder.getPosition();
    // change 5 with testing
  /*  while (liftEncoder.getPosition() - currentTicks < 5) {
      lift.set(0.5);
    }
    while (liftEncoder.getPosition() - currentTicks > 0) {
      lift.set(-0.5);
    }
    */
  }
  
  
  public static void liftIntake(){
    // change 81 to 20 after testing
    /*while (liftEncoder.getPosition() > -81/4) {
      lift.set(-.1);
    }
    lift.set(0);
    liftPID.setReference(-81/4, ControlType.kPosition);*/
    
  }
  
  public static void lowerIntake(){
    // change 81 to 20 after testing
    /*if (liftEncoder.getPosition() < 0) {
      lift.set(0.2);
    }
    lift.set(0);
    liftPID.setReference(0, ControlType.kPosition);
    */
  }

  public static void stopIntake() {
    //lift.set(0);
  }

  /*
  public static void liftIntake(){
    //lift.set(ControlMode.PercentOutput, 0.15);
  }

  public static void lowerIntake(){
    //lift.set(ControlMode.PercentOutput, -0.15);
  }

  public static void stopIntake(){
    //lift.set(ControlMode.PercentOutput, 0.0);
  }
  */

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}  
