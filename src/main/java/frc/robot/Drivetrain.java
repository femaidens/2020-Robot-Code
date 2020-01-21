/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2265.robot.subsystems;
import edu.wpi.first.wpilibj.MecanumDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.AnalogGyro;

public class Drivetrain extends Subsystem {
	// instantiate motor controllers & other things
public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
	public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
	public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);
public static CANSparkMax frontLeft =new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
	
public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
	
public static MecanumDrive m_drive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
	
public static CANEncoder frontRightHall = frontRight.getEncoder();
  	public static CANEncoder rearRightHall = rearRight.getEncoder();
  	public static CANEncoder frontLeftHall = frontLeft.getEncoder();
  	public static CANEncoder rearLeftHall = rearLeft.getEncoder();
  		
	// drive teleop
public static void driveTeleop() {
//sets certain parts of the joystick to getting x,y,z speeds
double x_speed = OI.driveJoystick.getRawAxis(2); 
double y_speed = OI.driveJoystick.getRawAxis(1);
double z_speed = OI.driveJoystick.getRawAxis(6);
//the get methods get the speed from a certain channel 
	m_drive.mecanumDrive_Cartesian(y_speed, x_speed, z_speed); 
}

//x is speed, angle is between 180 & -180 (the angle that the robot drives at), zrotation is -1.0 & 1.0 (clockwise is positive)
public void driveAuton(double speed, double angle, double zRotation,) {
m_drive.mecanumDrive_Polar(speed, angle, zrotation);	
	}
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
