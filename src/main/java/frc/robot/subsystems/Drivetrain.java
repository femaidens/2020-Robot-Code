/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveTeleop;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
	public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
	public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);
	public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
	public static CANSparkMax middleLeft = new CANSparkMax(RobotMap.middleLeftPort, MotorType.kBrushless);
	public static CANSparkMax middleRight = new CANSparkMax(RobotMap.middleRightPort, MotorType.kBrushless);

	//public static DoubleSolenoid gearShift = new DoubleSolenoid(RobotMap.solChannel1, RobotMap.solChannel2);

	public static Joystick joy = new Joystick(RobotMap.driveJoyPort);

	public static CANEncoder rightEncoder = frontRight.getEncoder();
	public static CANEncoder leftEncoder = frontLeft.getEncoder();

  public Drivetrain(){
  }
	//public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new DriveTeleop());
  }
  public static void driveTeleop() {
		double leftJoy = -joy.getRawAxis(1);
		double rightJoy = joy.getRawAxis(5);
		frontRight.set(rightJoy);
		rearRight.set(rightJoy);
		middleRight.set(rightJoy);
		frontLeft.set(leftJoy);
		rearLeft.set(leftJoy);
		middleLeft.set(leftJoy);
	}

	public static void driveAuton(final double rightSpeed, final double leftSpeed) {
		frontRight.set(rightSpeed);
		rearRight.set(rightSpeed);
		frontLeft.set(leftSpeed);
		rearLeft.set(leftSpeed);
		middleLeft.set(leftSpeed);
		middleRight.set(rightSpeed);
		SmartDashboard.putNumber("Left motor speed", leftEncoder.getPosition());
		SmartDashboard.putNumber("Right motor speed", rightEncoder.getPosition());
	}

	public static void driveStraight() {
		if (Drivetrain.leftEncoder.getPosition() > Drivetrain.rightEncoder.getPosition()) {
			Drivetrain.frontLeft.set(0.5);
			Drivetrain.middleLeft.set(0.5);
			Drivetrain.rearLeft.set(0.5);
		} else if (Drivetrain.rightEncoder.getPosition() > Drivetrain.leftEncoder.getPosition()) {
			Drivetrain.frontRight.set(0.5);
			Drivetrain.middleRight.set(0.5);
			Drivetrain.rearRight.set(0.5);
		}
	}

	public static void turnDegrees(final double angle) {
	/*if (angle > 180) {
		angle = -(360 - angle);
	  }
  
	  if (Drivetrain.gyro.getAngle() != angle) {
		if (angle < 0) {
		  Drivetrain.frontRight.set(1.0);
		  Drivetrain.rearRight.set(1.0);
		  Drivetrain.frontLeft.set(-1.0);
		  Drivetrain.rearLeft.set(-1.0);
		} else {
		  Drivetrain.frontRight.set(-1.0);
		  Drivetrain.rearRight.set(-1.0);
		  Drivetrain.frontLeft.set(1.0);
		  Drivetrain.rearRight.set(1.0);
		}
	  }*/
  }
public static void shiftToSpeed(){
	//gearShift.set(DoubleSolenoid.Value.kForward);
}
public static void shiftToPower(){
	//gearShift.set(DoubleSolenoid.Value.kReverse);
}
public static void get() {
	//return gearShift.get(); 
}
}
