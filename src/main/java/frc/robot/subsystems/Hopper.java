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

/**
 * Add your docs here.
 */
//Hopper Subsystem
public class Hopper extends Subsystem {
	// belt talons
public static CANSparkMax belt1 = new CANSparkMax(RobotMap.beltPort1, MotorType.kBrushless);
public static CANSparkMax belt2 = new CANSparkMax(RobotMap.beltPort2, MotorType.kBrushless);
	
// time of flight sensors--DO LATER

	public static int numCells;
	
	public Hopper(int initialCellCount) {
		numCells = initialCellCount;
	}
	
	// methods
public static void spinIn() {
		belt1.set(1.0);
		belt2.set(1.0);
		belt3.set(1.0);
		belt4.set(1.0);
	}
	
	
	public static void spinStop() {
		belt1.set(0);
		belt2.set(0);
		belt3.set(0);
		belt4.set(0);
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



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
