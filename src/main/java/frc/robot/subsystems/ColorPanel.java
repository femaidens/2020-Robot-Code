/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.I2C;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ColorPanel extends Subsystem {

  public static CANSparkMax spin = new CANSparkMax(RobotMap.colorPanelPort, MotorType.kBrushless);
  public static I2C.Port i2cPort = I2C.Port.kOnboard;
  public static ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);

  public ColorPanel(){

  }

  @Override
  public void initDefaultCommand() {
  }

  public static edu.wpi.first.wpilibj.util.Color colorSet(String t, edu.wpi.first.wpilibj.util.Color target){
    if(t.equals("R")){
      target = ColorMatch.makeColor(0.143, 0.427, 0.439);
    }
    else if(t.equals("B")){
      target = ColorMatch.makeColor(0.561, 0.232, 0.114);
    }
    else if(t.equals("Y")){
      target = ColorMatch.makeColor(0.197, 0.561, 0.240);
    }
    else if(t.equals("G")){
      target = ColorMatch.makeColor(0.361, 0.524, 0.113);
  }
  return target;
  } 


}