/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.subsystems.Intake;

/**
* Add your docs here.
*/
//Hopper Subsystem
public class Hopper extends Subsystem {
	// belt talons
	//public static CANSparkMax belt1 = new CANSparkMax(RobotMap.beltPort1, MotorType.kBrushless);
	//public static CANSparkMax belt2 = new CANSparkMax(RobotMap.beltPort2, MotorType.kBrushless);
	public static DigitalInput echo = new DigitalInput(RobotMap.ultraEcho1);
	public static DigitalOutput trig = new DigitalOutput(RobotMap.trig1);
	public static Ultrasonic ultra1 = new Ultrasonic(trig, echo);
	//public static Ultrasonic ultra2 = new Ultrasonic(RobotMap.ultraPort2a, RobotMap.ultraPort2b);
	
	// time of flight sensors--DO LATER
	
	public static int numCells;
	
	public Hopper(int initialCellCount) {
		numCells = initialCellCount;
	}
	
	// methods
	public static void spinIn() {
		/*belt1.set(1.0);
		belt2.set(1.0);*/
	}
	
	
	public static void spinStop() {
		/*belt1.set(0);
		belt2.set(0);*/
	}
	
	public static void increaseCellCount() {
		numCells++;
	}
	
	public static void decreaseCellCount() {
		numCells--;
	}
	
	public static int currentCellCount() {
		return numCells;
	}

	/*public static void checkUltra() {
		ultra1.setAutomaticMode(true);
		if(numCells == 5){
			//Intake.liftIntake();
		}
		if(numCells < 5) {
			//Intake.lowerIntake();
		}
		/*if(ultra1.getRangeMM() < 5 && numCells<5){
			increaseCellCount();
			
			double first = ultra1.getRangeInches();
			try{
				Thread.sleep(10);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			double second = ultra1.getRangeInches();
			try{
				Thread.sleep(10);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			double third = ultra1.getRangeInches();
			try{
				Thread.sleep(10);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			
			if(first > second && second < third && second < 5){
				increaseCellCount();
			}
		/*if(ultra2.getRangeMM() < 5){
			decreaseCellCount();
		}
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
		System.out.println(numCells);
	}*/
	public static boolean ballPassedIn(){
		if(ultra1.getRangeMM() < 5 && numCells < 5){
			while(ultra1.getRangeMM() < 5){
				System.out.println("Ball");
			}
			increaseCellCount();
			System.out.println(numCells);
		}
		
		return true;
	}
	
	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
