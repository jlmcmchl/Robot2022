// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import frc.robot.util.TunableNumber;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final class RobotMap {

    //Drivery-dos
    public static final int frontLeftMotorPort = 1; // NEEDS TO BE CHECKED WHEN PORTS ARE OFFICIAL
    public static final int backLeftMotorPort = 2; // NEEDS TO BE CHECKED WHEN PORTS ARE OFFICIAL
    public static final int frontRightMotorPort = 3; // NEEDS TO BE CHECKED WHEN PORTS ARE OFFICIAL
    public static final int backRightMotorPort = 4; // NEEDS TO BE CHECKED WHEN PORTS ARE OFFICIAL

    //Climber
    public static final int  telescope = 7; //Needs to probably changed when the whole ports are set and like maybe the climber will need a second one for a winch motor idk.
  }

  public static final class DriveConstants {
    public static final double kJoystickTurnDeadzone = 0.04;
  }

  public static final class AutoConstants {
    // FF and FB gains; NEED TO BE DETERMINED ON THE FULLY BUILT ROBOT, WILL CHANGE WITH WEIGHT
    public static final double ksVolts = 0;
    public static final double ksVoltSecondsPerMeter = 0;
    public static final double kaVoltSecondsSquaredPerMeter = 0;

    public static final double kPDriveVel = 0;

    // more kinematics stuff
    public static final double trackWidth = 0.66;
    public static final DifferentialDriveKinematics kinematics =
        new DifferentialDriveKinematics(trackWidth);

    // Ramsete constants; generally the same on all robots
    public static final double RamseteZeta = 0.7;
    public static final double RamseteB = 2;

    // Max speeds
    public static final double maxSpeed = 3;
    public static final double maxAccel = 3;
  }

    public  static  final class ClimberConstants {
      public static final int kCurrentLimit = 40;
      public static final TunableNumber kP = new TunableNumber("Climber/kP", 0.0);
    }
}