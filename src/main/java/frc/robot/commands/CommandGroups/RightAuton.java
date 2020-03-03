/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.AbsoluteHood;
import frc.robot.commands.AlignTurret_PID;
import frc.robot.commands.CellIn;
import frc.robot.commands.DriveAuton;
import frc.robot.commands.DriveDistanceStraight;
import frc.robot.commands.SpinShooterNEO;
import frc.robot.commands.TurnDegrees;

public class RightAuton extends CommandGroup {
  /**
   * Add your docs here.
   */
  public RightAuton() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  addSequential(new DriveDistanceStraight(0.5, 10)); //replace second # - distance to cross line      
  addSequential(new AlignTurret_PID(0.1));
  addSequential(new AbsoluteHood(10)); //change to alignhood later
  // need to shoot continuously 
  addSequential(new SpinShooterNEO(0.3)); //change to shoot later
	addSequential(new TurnDegrees(150)); //change angle
	addSequential(new DriveDistanceStraight(0.4, 10)); //replace second # - distance to ball
 	addSequential(new CellIn());
	addSequential(new CellIn());
	addSequential(new CellIn());

  }
}
