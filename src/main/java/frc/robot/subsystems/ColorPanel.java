/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.I2C;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
//import frc.robot.commands.ColorPanelStage2;

public class ColorPanel extends SubsystemBase {
  /**
   * Creates a new ColorPanel.
   */
  public ColorPanel() {
  }
  public static CANSparkMax spin = new CANSparkMax(RobotMap.colorPanelPort, MotorType.kBrushless);
  public static I2C.Port i2cPort = I2C.Port.kOnboard;
  public static ColorSensorV3 gregory = new ColorSensorV3(i2cPort);
  
/* @Override
  public void initDefaultCommand() { 
   setDefaultCommand(new ColorPanelStage2());
     SmartDashboard.putString("Print statements", "default command");
 }
*/

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
