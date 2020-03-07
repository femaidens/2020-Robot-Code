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
import edu.wpi.first.wpilibj.Timer;
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
  	/*public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
	public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
	public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);
	public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
	public static CANSparkMax middleLeft = new CANSparkMax(RobotMap.middleLeftPort, MotorType.kBrushless);
	public static CANSparkMax middleRight = new CANSparkMax(RobotMap.middleRightPort, MotorType.kBrushless);
	*/
	//public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
	//public static DoubleSolenoid gearShift = new DoubleSolenoid(RobotMap.solChannel1, RobotMap.solChannel2);

	//public static CANEncoder rightEncoder = frontRight.getEncoder();
	//public static CANEncoder leftEncoder = frontLeft.getEncoder();

	public static double FRactualInput;
	public static double RRactualInput;
	public static double MRactualInput;
	public static double FLactualInput;
	public static double RLactualInput;
	public static double MLactualInput;
	
	public static int currentLimit = 17;

	// drivestraight pid variables
	public static double leftIntegral = 0;
	public static double rightIntegral = 0;
	public static double lastLeftError = 0;
	public static double lastRightError = 0;
	public static double lastTime = Timer.getFPGATimestamp();

	// constants
	public static double kp = 1;
	public static double ki = 0;
	public static double kd = 0;

  	public Drivetrain(){
	  //frontLeft.setSmartCurrentLimit(currentLimit);
	  //frontRight.setSmartCurrentLimit(currentLimit);
	  //rearLeft.setSmartCurrentLimit(currentLimit);
	  //rearRight.setSmartCurrentLimit(currentLimit);
	  //middleLeft.setSmartCurrentLimit(currentLimit);
	  //middleRight.setSmartCurrentLimit(currentLimit);
	  
  	}
	//public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
  @Override
  public void initDefaultCommand() {
   		setDefaultCommand(new DriveTeleop());
  }
  
  public static void driveTeleop() {
	//	System.out.println("we out here driving");
		
		//current limiting 
		int currentLimit = 17;
		int secondaryCurrentLimit = 19;
		/*	
		rearRight.setSmartCurrentLimit(currentLimit, currentLimit, 5700);
		rearLeft.setSmartCurrentLimit(currentLimit, currentLimit, 5700);
		frontRight.setSmartCurrentLimit(currentLimit, currentLimit, 5700);
		frontLeft.setSmartCurrentLimit(currentLimit, currentLimit, 5700);
		middleRight.setSmartCurrentLimit(currentLimit, currentLimit, 5700);
		middleLeft.setSmartCurrentLimit(currentLimit, currentLimit, 5700);

		rearRight.setSecondaryCurrentLimit(secondaryCurrentLimit);
		rearLeft.setSecondaryCurrentLimit(secondaryCurrentLimit);
		frontRight.setSecondaryCurrentLimit(secondaryCurrentLimit);
		frontLeft.setSecondaryCurrentLimit(secondaryCurrentLimit);
		middleRight.setSecondaryCurrentLimit(secondaryCurrentLimit);
		middleLeft.setSecondaryCurrentLimit(secondaryCurrentLimit);*/

		double targetLeftJoy = -OI.driveJoystick.getRawAxis(1); // postive originally, negated
		double targetRightJoy = OI.driveJoystick.getRawAxis(5); // negative originally
		double upRate = 0.01;
		
		//Only use downRate if you need to ramp down at a different rate
		//double downRate = 0.1;

		//Voltage ramping only in high gear
		
		
		
	
		/*if((targetRightJoy - rearRight.get()) < -upRate){
			RRactualInput -= upRate;

		}*/

		//Only use this if you need to ramp down
		/*else if(rearRight.get() - targetRightJoy > downRate){
			actualInput -= downRate;
		}
*/
		/*else{
			RRactualInput = targetRightJoy;
		}
		

		/*if((targetRightJoy - middleRight.get()) < -upRate){
			MRactualInput -= upRate;
			

		}*/
	

		//Only use this if you need to ramp down
		/*else if(rearRight.get() - targetRightJoy > downRate){
			actualInput -= downRate;
		}*/

		/*else{
			MRactualInput = targetRightJoy;
		}

		if((targetRightJoy - frontRight.get()) < -upRate){
			FRactualInput -= upRate;
		}*/

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
*/
		/*else{
			RLactualInput = targetLeftJoy;
		}

		if((targetLeftJoy - middleLeft.get()) > upRate){
			MLactualInput += upRate;
		}*/

		//Only use this if you need to ramp down
		/*else if(rearRight.get() - targetRightJoy > downRate){
			actualInput -= downRate;
		}*/

		/*else{
			MLactualInput = targetLeftJoy;
		}

		if((targetLeftJoy - frontLeft.get()) > upRate){
			FLactualInput += upRate;
		}

		//Only use this if you need to ramp down
		/*else if(rearRight.get() - targetRightJoy > downRate){
			actualInput -= downRate;
		}*/

		/*else{
			FLactualInput = targetLeftJoy;

		}*/
		
		//WITH Voltage Ramping
		//if(gearShift.get() == DoubleSolenoid.Value.kForward){
		/*frontRight.set(FRactualInput);
		rearRight.set(-RRactualInput);
		middleRight.set(MRactualInput);*/
		//frontLeft.set(FLactualInput);
		//rearLeft.set(-RLactualInput);
		//middleLeft.set(MLactualInput);
		//}


		//WITHOUT voltage ramping
		//if(gearShift.get() == DoubleSolenoid.Value.kReverse){}
		
		/*frontRight.set(targetRightJoy);
		rearRight.set(-targetRightJoy);
		middleRight.set(targetRightJoy);
		frontLeft.set(targetLeftJoy);
		rearLeft.set(-targetLeftJoy);
		middleLeft.set(targetLeftJoy);
		*/
		//System.out.println(frontRight.get());
		//System.out.println(rearRight.get());
		//System.out.println(middleRight.get());
		//System.out.println(frontLeft.get());
		//System.out.println(rearLeft.get());
		//System.out.println(middleLeft.get());






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

	public static void driveAuton(final double rightSpeed, final double leftSpeed) {
		/*frontRight.set(rightSpeed);
		rearRight.set(rightSpeed);
		frontLeft.set(leftSpeed);
		rearLeft.set(leftSpeed);
		middleLeft.set(leftSpeed);
		middleRight.set(rightSpeed);	
		SmartDashboard.putNumber("Left motor speed", leftEncoder.getPosition());
		SmartDashboard.putNumber("Right motor speed", rightEncoder.getPosition());*/
	}

	public static void driveStraight(double speed) {
		// convert speed to RPM
		double rpm = speed * 5700;
		/*double leftVel = leftEncoder.getVelocity();
		double rightVel = rightEncoder.getVelocity();*/

		/*double leftError = leftVel - rpm;
		double rightError = rightVel - rpm;
		double timeSpan = Timer.getFPGATimestamp() - lastTime;
		lastTime = Timer.getFPGATimestamp();

		leftIntegral += leftError * timeSpan;
		rightIntegral += rightError * timeSpan;
		double leftDerivative = (leftError - lastLeftError) / timeSpan;
		double rightDerivative = (rightError - lastRightError) / timeSpan;

		double leftSpeed = rpm + (kp * leftError) + (ki * leftIntegral) + (kd * leftDerivative);
		double rightSpeed = rpm + (kp * rightError) + (ki * rightIntegral) + (kd * rightDerivative);

		// convert back when calling drive auton
		driveAuton(leftSpeed / 5700, rightSpeed / 5700);

		lastLeftError = leftError;
		lastRightError = rightError;*/
	}

	public static void turnDegrees(final double angle) {
	/*if (angle > 180) {
		angle = -(360 - angle);
	  }
  
	  while (Drivetrain.gyro.getAngle() != angle) {
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
	  }
	  	  Drivetrain.frontRight.set(0.0);
		  Drivetrain.rearRight.set(0.0);
		  Drivetrain.frontLeft.set(0.0);
		  Drivetrain.rearRight.set(0.0);
		  */
  }
public static void shiftToSpeed(){
	//High Gear
	//gearShift.set(DoubleSolenoid.Value.kForward);
}
public static void shiftToPower(){
	//Low Gear
	//gearShift.set(DoubleSolenoid.Value.kReverse);
}
/*public static DoubleSolenoid.Value get() {
	//return gearShift.get(); 
}*/
}
