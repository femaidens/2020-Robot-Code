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
import frc.robot.OI;
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
	public static DoubleSolenoid gearShift = new DoubleSolenoid(RobotMap.solChannel1, RobotMap.solChannel2);

	//public static CANEncoder rightEncoder = frontRight.getEncoder();
	//public static CANEncoder leftEncoder = frontLeft.getEncoder();

	public static double FRactualInput;
	public static double RRactualInput;
	public static double MRactualInput;
	public static double FLactualInput;
	public static double RLactualInput;
	public static double MLactualInput;
	
	public static int currentLimit = 17;

  	public Drivetrain(){
	  frontLeft.setSmartCurrentLimit(currentLimit);
	  //frontRight.setSmartCurrentLimit(currentLimit);
	  //rearLeft.setSmartCurrentLimit(currentLimit);
	  //rearRight.setSmartCurrentLimit(currentLimit);
	  //middleLeft.setSmartCurrentLimit(currentLimit);
	  //middleRight.setSmartCurrentLimit(currentLimit);
	  
  	}
	//public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
  @Override
  public void initDefaultCommand() {
   	//	setDefaultCommand(new DriveTeleop());
  }
  
  public static void driveTeleop() {
		//System.out.println("we out here driving");

		//double targetLeftJoy = -OI.driveJoystick.getRawAxis(1);
		double targetRightJoy = OI.driveJoystick.getRawAxis(5);
		double upRate = 0.01;
		//Only use downRate if you need to ramp down at a different rate
		//double downRate = 0.1;

		//Voltage ramping only in high gear
		

		
		if(gearShift.get() == DoubleSolenoid.Value.kForward){
	
		if((targetRightJoy - rearRight.get()) > upRate){
			RRactualInput += upRate;

		}

		//Only use this if you need to ramp down
		/*else if(rearRight.get() - targetRightJoy > downRate){
			actualInput -= downRate;
		}

		else{
			RRactualInput = targetRightJoy;
		}

		/*if((targetRightJoy - middleRight.get()) > upRate){
			MRactualInput += upRate;
			

		}
	
*/
		//Only use this if you need to ramp down
		/*else if(rearRight.get() - targetRightJoy > downRate){
			actualInput -= downRate;
		}*/

	/*	else{
			MRactualInput = targetRightJoy;
		}

		if((targetRightJoy - frontRight.get()) > upRate){
			FRactualInput += upRate;
		}

		//Only use this if you need to ramp down
		/*else if(rearRight.get() - targetRightJoy > downRate){
			actualInput -= downRate;
		}*/

		/*else{
			FRactualInput = targetRightJoy;
		}

		if((targetLeftJoy - rearLeft.get()) > upRate){
			RLactualInput += upRate;
		}*/

		//Only use this if you need to ramp down
		/*else if(rearRight.get() - targetRightJoy > downRate){
			actualInput -= downRate;
		}

	/*	else{
			RLactualInput = targetLeftJoy;
		}

		if((targetLeftJoy - middleLeft.get()) > upRate){
			MLactualInput += upRate;
		}
*/
		//Only use this if you need to ramp down
		/*else if(rearRight.get() - targetRightJoy > downRate){
			actualInput -= downRate;
		}*/

		/*else{
			MLactualInput = targetLeftJoy;
		}

		if((targetLeftJoy - frontLeft.get()) > upRate){
			FLactualInput += upRate;
		}*/

		//Only use this if you need to ramp down
		/*else if(rearRight.get() - targetRightJoy > downRate){
			actualInput -= downRate;
		}*/

		/*else{
			FLactualInput = targetLeftJoy;

		}
		*/

		//WITH voltage ramping
	/*	frontRight.set(FRactualInput);
		rearRight.set(RRactualInput);
		middleRight.set(MRactualInput);
		frontLeft.set(FLactualInput);
		rearLeft.set(RLactualInput);
		middleLeft.set(MLactualInput);
*/
		//WITHOUT voltage ramping
		//frontRight.set(targetRightJoy);
		//rearRight.set(targetRightJoy);
		/*middleRight.set(targetRightJoy);
		frontLeft.set(targetLeftJoy);
		rearLeft.set(targetLeftJoy);
		middleLeft.set(targetLeftJoy);*/

		//Voltage print statement
		//System.out.println(rearLeft.getBusVoltage() * rearLeft.getAppliedOutput());
		//System.out.println("bus voltage" + rearLeft.getBusVoltage());
		//System.out.println("applied output" + rearLeft.getAppliedOutput());

		//if(currentLimit >= 19){
			//shiftToPower();

		//}
		//if(currentLimit <= 15){
			//shifttoSpeed();
		//}
		/*frontLeft.setClosedLoopRampRate(5);
		frontRight.setCLosedLoopRampRate(5);
		middleLeft.setClosedLoopRampRate(5);
		middleRight.setCLosedLoopRampRate(5);
		rearLeft.setCLosedLoopRampRate(5);
		rearRight.setClosedLoopRampRate(5);
		*/
	}
	}

	public static void driveAuton(final double rightSpeed, final double leftSpeed) {
		//frontRight.set(rightSpeed);
		//rearRight.set(rightSpeed);
		//frontLeft.set(leftSpeed);
		//rearLeft.set(leftSpeed);
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
	//gearShift.set(DoubleSolenoid.Value.kForward);
}
public static void shiftToPower(){
	//Low Gear
	//gearShift.set(DoubleSolenoid.Value.kReverse);
}
public static void get() {
	//return gearShift.get(); 
}
}
