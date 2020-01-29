/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
//import frc.robot.OI;
//import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.MoveClimb;

public class Test extends Subsystem {

  //public static CANSparkMax climbMotor = new CANSparkMax(RobotMap.climbMotorPort, MotorType.kBrushless);
	
	public static DigitalInput limitSwitchB = new DigitalInput(RobotMap.limitPortB); //bottom
	public static DigitalInput limitSwitchT = new DigitalInput(RobotMap.limitPortT); //top
	

  public Test() {
    System.out.println("test");
  }
	
	public static void move() {
    if (limitSwitchB.get()) {
      System.out.println("bottom true");
    }
    if (!limitSwitchB.get()) {
      System.out.println("bottom false");
    }
    if (limitSwitchT.get()){
      System.out.println("bottom true");
    }
    if (!limitSwitchB.get()){
      System.out.println("bottom false");
    }
  
    /*double value = OI.atkJoy2.getRawAxis(1);
		if(value > 0 && !limitSwitchT.get()){
      climbMotor.set(value);
      System.out.println("yes");
		} else if(value<0 && !limitSwitchB.get()){
      climbMotor.set(value);
      System.out.println("no");
    }*/
    
	}

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new MoveClimb());
  }
}
