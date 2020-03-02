/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
<<<<<<< HEAD:src/main/java/frc/robot/commands/LiftIntake.java
import frc.robot.subsystems.Intake;
=======
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;
>>>>>>> 07fa5d096517a23a344976a6e53209fefd4cc9dd:src/main/java/frc/robot/commands/DriveTeleop.java

public class LiftIntake extends Command {
  public LiftIntake() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Drivetrain.frontLeft.setSmartCurrentLimit(17);
  }
  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
<<<<<<< HEAD:src/main/java/frc/robot/commands/LiftIntake.java
    Intake.liftIntake();
    //Intake.intakeLimitSwitch();
=======
    Drivetrain.driveTeleop();
    //Drivetrain.frontLeft.set(1.0);

>>>>>>> 07fa5d096517a23a344976a6e53209fefd4cc9dd:src/main/java/frc/robot/commands/DriveTeleop.java
  }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
  
  // Called once after isFinished returns true
  @Override
  protected void end() {
<<<<<<< HEAD:src/main/java/frc/robot/commands/LiftIntake.java
    Intake.lowerIntake();
=======
    // Robot.drivetrain.driveAuton(0.0, 0.0);
    //Drivetrain.frontLeft.set(0.0);
>>>>>>> 07fa5d096517a23a344976a6e53209fefd4cc9dd:src/main/java/frc/robot/commands/DriveTeleop.java
  }
  
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
<<<<<<< HEAD:src/main/java/frc/robot/commands/LiftIntake.java
    //Intake.lowerIntake();
    Intake.lowerIntake();
=======
   // Robot.drivetrain.driveAuton(0.0, 0.0);
   //Drivetrain.frontLeft.set(0.0);
>>>>>>> 07fa5d096517a23a344976a6e53209fefd4cc9dd:src/main/java/frc/robot/commands/DriveTeleop.java
  }
}