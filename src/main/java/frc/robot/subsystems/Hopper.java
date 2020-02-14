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
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.subsystems.Intake;

/**
* Add your docs here.
*/
//Hopper Subsystem
public class Hopper extends Subsystem {
	// belt talons
	public static CANSparkMax belt1 = new CANSparkMax(RobotMap.beltPort1, MotorType.kBrushless);
	public static CANSparkMax belt2 = new CANSparkMax(RobotMap.beltPort2, MotorType.kBrushless);
	public static Ultrasonic ultra1 = new UltraSonic(RobotMap.ultraPort1);
	public static Ultrasonic ultra2 = new Ultrasonic(RobotMap.ultraPort2);
	
	// time of flight sensors--DO LATER
	
	public static int numCells;
	
	public Hopper(int initialCellCount) {
		numCells = initialCellCount;
	}
	
	// methods
	public static void spinIn() {
		belt1.set(1.0);
		belt2.set(1.0);
	}
	
	
	public static void spinStop() {
		belt1.set(0);
		belt2.set(0);
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
	public static boolean ballPassed(){
		if(numCells == 5){
			liftIntake();
		}
		if(ultra1.getRangeMM() < 5 && numCells<5){
			increaseCellCount();
		}
		if(ultra2.getRangeMM() < 5){
			decreaseCellCount();
		}
		
	}


	
	
	
	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
