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

	//public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
	//public static DoubleSolenoid gearShift = new DoubleSolenoid(RobotMap.solChannel1, RobotMap.solChannel2);

	//public static CANEncoder rightEncoder = frontRight.getEncoder();
	//public static CANEncoder leftEncoder = frontLeft.getEncoder();

	public static int currentLimit = 17;

  public Drivetrain(){
	  frontLeft.setSmartCurrentLimit(currentLimit);
	  frontRight.setSmartCurrentLimit(currentLimit);
	  rearLeft.setCurrentLimit(currentLimit);
	  rearRight.setCurrentLimit(currentLimit);
	  middleLeft.setCurrentLimit(currentLimit);
	  middleRight.setCurrentLimit(currentLimit);
	  
  }
	//public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
  @Override
  public void initDefaultCommand() {
   		//setDefaultCommand(new DriveTeleop());
  }
  public static void driveTeleop() {
		/*double leftJoy = -OI.driveStr.getRawAxis(1);
		double rightJoy = OI.driveStr.getRawAxis(5);
		frontRight.set(rightJoy);
		rearRight.set(rightJoy);
		//middleRight.set(rightJoy);
		//frontLeft.set(leftJoy);
		rearLeft.set(leftJoy);
		//middleLeft.set(leftJoy);*/
		if(currentLimit >= 19){
			shifttoPower();
		}
		if(currentLimit <= 15){
			shifttoSpeed();
		}
		frontLeft.setClosedLoopRampRate(5);
		frontRIght.setCLosedLoopRampRate(5);
		middleLeft.setClosedLoopRampRate(5);
		middleRight.setCLosedLoopRampRate(5);
		frontRight.setCLosedLoopRampRate(5);
		rearRight.setClosedLoopRampRate(5);
		
	}

	public static void driveAuton(final double rightSpeed, final double leftSpeed) {
		frontRight.set(rightSpeed);
		rearRight.set(rightSpeed);
		//frontLeft.set(leftSpeed);
		rearLeft.set(leftSpeed);
		//middleLeft.set(leftSpeed);
		//middleRight.set(rightSpeed);
		//SmartDashboard.putNumber("Left motor speed", leftEncoder.getPosition());
		//SmartDashboard.putNumber("Right motor speed", rightEncoder.getPosition());
	}

	public static void driveStraight(double speed) {
		/*if(gyro.getAngle() == 0){
			Drivetrain.frontLeft.set(speed);
			Drivetrain.middleLeft.set(speed);
			Drivetrain.rearLeft.set(speed);
			Drivetrain.frontRight.set(speed);
			Drivetrain.middleRight.set(speed);
			Drivetrain.rearRight.set(speed);
		}else if(gyro.getAngle() > 180){
			Drivetrain.frontRight.set(speed);
			Drivetrain.middleRight.set(speed);
			Drivetrain.rearRight.set(speed);
			Drivetrain.frontLeft.set(speed+0.05);
			Drivetrain.middleLeft.set(speed+0.05);
			Drivetrain.rearLeft.set(speed+0.05);
		}else {
			Drivetrain.frontLeft.set(speed);
			Drivetrain.middleLeft.set(speed);
			Drivetrain.rearLeft.set(speed);
			Drivetrain.frontRight.set(speed+0.05);
			Drivetrain.middleRight.set(speed+0.05);
			Drivetrain.rearRight.set(speed+0.05);
		}
		if (Math.abs(Drivetrain.leftEncoder.getPosition()) > Math.abs(Drivetrain.rightEncoder.getPosition())) {
			Drivetrain.frontLeft.set(speed);
			Drivetrain.middleLeft.set(speed);
			Drivetrain.rearLeft.set(speed);
			Drivetrain.frontRight.set(-(speed+0.05));
			Drivetrain.middleRight.set(-(speed+0.05));
			Drivetrain.rearRight.set(-(speed+0.05));
		} else if (Math.abs(Drivetrain.rightEncoder.getPosition()) > Math.abs(Drivetrain.leftEncoder.getPosition())) {
			Drivetrain.frontRight.set(-speed);
			Drivetrain.middleRight.set(-speed);
			Drivetrain.rearRight.set(-speed);
			Drivetrain.frontLeft.set(speed+0.05);
			Drivetrain.middleLeft.set(speed+0.05);
			Drivetrain.rearLeft.set(speed+0.05);
		} 
		else{
			Drivetrain.frontLeft.set(speed + 0.01);
			Drivetrain.middleLeft.set(speed + 0.01);
			Drivetrain.rearLeft.set(speed + 0.01);
			Drivetrain.frontRight.set(-(speed));
			Drivetrain.middleRight.set(-(speed));
			Drivetrain.rearRight.set(-(speed));
		}*/
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
	//High Gear
	gearShift.set(DoubleSolenoid.Value.kForward);
}
public static void shiftToPower(){
	//Low Gear
	gearShift.set(DoubleSolenoid.Value.kReverse);
}
public static void get() {
	//return gearShift.get(); 
}
}
