/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.MoveClimb;

public class Climb extends Subsystem {
  /**
   * Creates a new Climber.
   */
  private static final double UP_VALUE = 0.0;
	private static final double DOWN_VALUE = 5.0;

  public static CANSparkMax climbMotor = new CANSparkMax(RobotMap.climbMotorPort, MotorType.kBrushless);
	
	public static DigitalInput limitSwitchB = new DigitalInput(RobotMap.limitPortB); //bottom
	public static DigitalInput limitSwitchT = new DigitalInput(RobotMap.limitPortT); //top
	
	public static Servo servo = new Servo(RobotMap.servoPort);

  public Climb() {
  }
	
	public static void move(){
		double value = OI.atkJoy2.getRawAxis(1);
		if(value>0 && !limitSwitchT.get()){
			servo.setPosition(UP_VALUE);
			climbMotor.set(value);
		}else if(value<0 && !limitSwitchB.get()){
			servo.setPosition(DOWN_VALUE);
      climbMotor.set(value);
		}
	}

	public static String ready(){ //checks if the robot is under the switch
		byte[] message = new byte[1];;
    Robot.i2c.readOnly(message, 1);
    try{
      double answer = message[0];
	    return "Yes";
    }
    catch(NullPointerException ex){
      return "No";
    }
  }

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new MoveClimb());
  }
}
