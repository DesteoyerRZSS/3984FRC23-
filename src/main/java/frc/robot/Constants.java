// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Map;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import frc.robot.utils.ModuleMap;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final class CanConstants {

    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 5; //FIXME: CAN ID of front left drive motor
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 9; //FIXME: CAN ID of front left steer motor
    public static final int FRONT_LEFT_MODULE_STEER_CANCODER = 1; //FIXME: CAN ID of front left CANCoder
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = 313.09; //FIXME: reading of front left CANCoder (in degrees) after manually setting wheel to forward (axle bolt head to the right side of the robot)

    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 6; //FIXME: CAN ID of front right drive motor
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 10; //FIXME: CAN ID of front right steer motor
    public static final int FRONT_RIGHT_MODULE_STEER_CANCODER = 2; //FIXME: CAN ID of front right CANCoder
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = 292.27; //FIXME: reading of front right CANCoder (in degrees) after manually setting wheel to forward (axle bolt head to the right side of the robot)

    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 7; //FIXME: CAN ID of back left drive motor
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 11; //FIXME: CAN ID of back left steer motor
    public static final int BACK_LEFT_MODULE_STEER_CANCODER = 3; //FIXME: CAN ID of back left CANCoder
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = 228.79; //FIXME: reading of back left CANCoder (in degrees) after manually setting wheel to forward (axle bolt head to the right side of the robot)

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 8; //FIXME: CAN ID of back right drive motor
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 12; //FIXME: CAN ID of back right steer motor
    public static final int BACK_RIGHT_MODULE_STEER_CANCODER = 4; //FIXME: CAN ID of back right CANCoder
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = 104.48; //FIXME: reading of back right CANCoder (in degrees) after manually setting wheel to forward (axle bolt head to the right side of the robot)

  }

  public static final class DriveConstants {

    public static final boolean kFrontLeftTurningMotorReversed = true;
    public static final boolean kBackLeftTurningMotorReversed = true;
    public static final boolean kFrontRightTurningMotorReversed = true;
    public static final boolean kBackRightTurningMotorReversed = true;

    public static final boolean kFrontLeftDriveMotorReversed = true;
    public static final boolean kBackLeftDriveMotorReversed = true;
    public static final boolean kFrontRightDriveMotorReversed = true;
    public static final boolean kBackRightDriveMotorReversed = true;

    public static final double kTrackWidth = Units.inchesToMeters(29.5); //FIXME: Distance between centers of right and left wheels on robot
    public static final double kWheelBase = Units.inchesToMeters(29.5); //FIXME: Distance between centers of front and back wheels on robot

    public enum ModulePosition {
      FRONT_LEFT,
      FRONT_RIGHT,
      BACK_LEFT,
      BACK_RIGHT
    }

    public static final Map<ModulePosition, Translation2d> kModuleTranslations = Map.of(
        ModulePosition.FRONT_LEFT, new Translation2d(kWheelBase / 2, kTrackWidth / 2),
        ModulePosition.FRONT_RIGHT, new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
        ModulePosition.BACK_LEFT, new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
        ModulePosition.BACK_RIGHT, new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

    public static final SwerveDriveKinematics kSwerveKinematics = new SwerveDriveKinematics(
        ModuleMap.orderedValues(kModuleTranslations, new Translation2d[0]));

    public static final boolean kGyroReversed = true;

    // These are example values only - DO NOT USE THESE FOR YOUR OWN ROBOT!
    // These characterization values MUST be determined either experimentally or
    // theoretically
    // for *your* robot's drive.
    // The SysId tool provides a convenient method for obtaining these values for
    // your robot.

    //FIXME: For just a drive base these values are fine, but definitely run System Identification for the drive motors to find new values once the robot is assembled, as it will have significantly more mass.

    public static final double ksVolts = 1;
    public static final double kvVoltSecondsPerMeter = 0.8;
    public static final double kaVoltSecondsSquaredPerMeter = 0.15;

    public static final double kMaxSpeedMetersPerSecond = 5;

    public static final double kMaxRotationRadiansPerSecond = Math.PI * 2;
    public static final double kMaxRotationRadiansPerSecondSquared = Math.PI;

    public static final double kP_X = 0.2;
    public static final double kD_X = 0;
    public static final double kP_Y = 0.2;
    public static final double kD_Y = 0;
    public static final double kP_Theta = 8;
    public static final double kD_Theta = 0;
    public static double kTranslationSlew = 1.55;
    public static double kRotationSlew = 3.00;
    public static double kControllerDeadband = .05;
    public static double kControllerRotDeadband = .1;
    
    public static double kVoltCompensation = 12.6;

    // public static final double kMaxRotationRadiansPerSecond =
    // Math.hypot(DriveConstants.kTrackWidth / 2.0,
    // DriveConstants.kWheelBase / 2.0);

    // public static final double MAX_ANGULAR_ACCEL_RADIANS_PER_SECOND_SQUARED = 2 *
    // Math.PI;

  }

  public static final class ModuleConstants {

    // ModuleConfiguration MK4I_L2
    public static final double kWheelDiameterMeters = Units.inchesToMeters(4);

    public static double driveGearRatio = 1 / ((14.0 / 50.0) * (27.0 / 17.0) * (15.0 / 45.0)); //FIXME: This drive gear ratio is for the L2 configuration. If you're using L1 or L3, the gear ratios can be obtained from the chart at https://www.swervedrivespecialties.com/products/mk4i-swerve-module.

    public static double steerGearRatio = 1 / ((14.0 / 50.0) * (10.0 / 60.0)); //The steering gear ratio is the same for all 3 configurations

    public static final double kDriveMetersPerEncRev =

        (kWheelDiameterMeters * Math.PI) / driveGearRatio;

    // in 1 minute at 1 rpm encoder drive moves kDriveMetersPerEncRev
    // so in 1 second encoder travels 1/60 revs = kDriveMetersPerEncRev/60
    // so MPS

    public static final double kDriveEncRPMperMPS = kDriveMetersPerEncRev / 60;

    public static double kEncoderRevsPerMeter = 1 / kDriveMetersPerEncRev;

    public static double kFreeMetersPerSecond = 5600 * kDriveEncRPMperMPS;
  
    public static final double kTurningDegreesPerEncRev = 360 / steerGearRatio;

    // max turn speed = (5400/ 21.43) revs per min 240 revs per min 4250 deg per min
    public static final double kPModuleTurningController = .025;

    public static final double kPModuleDriveController = .2;

    // use sysid on robot
    public static double ksVolts = .055;
    public static double kvVoltSecondsPerMeter = .2;
    public static double kaVoltSecondsSquaredPerMeter = .02;

    public static double kPModuleTurnController;

    public static double kSMmaxAccel = 90;//deg per sec per sec

    public static double maxVel= 90; // deg per sec

    public static double allowedErr = .05;//deg

    // sysid on module?
    public static final double ksDriveVoltSecondsPerMeter = 0.667 / 12;
    public static final double kvDriveVoltSecondsSquaredPerMeter = 2.44 / 12;
    public static final double kaDriveVoltSecondsSquaredPerMeter = 0.27 / 12;
    // sysid on module?
    public static final double kvTurnVoltSecondsPerRadian = 1.47; // originally 1.5
    public static final double kaTurnVoltSecondsSquaredPerRadian = 0.348; // originally 0.3

    
    public static double kMaxModuleAngularSpeedDegPerSec = 90;

    public static final double kMaxModuleAngularAccelerationDegreesPerSecondSquared = 90;

  }

  public static final class TrapezoidConstants {
    
    public static final double kMaxSpeedMetersPerSecond = 3;

    public static final double kMaxAccelerationMetersPerSecondSquared = 15;

    // public static final double kMaxAngularSpeedDegreesPerSecond = 800;

    // public static final double kMaxAngularSpeedDegreesPerSecondSquared =2000;
    public static final double kMaxRotationRadiansPerSecond = Math.PI;
    public static final double kMaxRotationRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 1;
    public static final double kPYController = 1;
    public static final double kPThetaController = 1;

    public static final TrapezoidProfile.Constraints kThetaControllerConstraints = new TrapezoidProfile.Constraints(
        kMaxRotationRadiansPerSecond, kMaxRotationRadiansPerSecondSquared);

    // // Constraint for the motion profiled robot angle controller
    // public static final TrapezoidProfile.Constraints kThetaControllerConstraints
    // = new TrapezoidProfile.Constraints(
    // Units.radiansToDegrees(kMaxAngularSpeedRadiansPerSecond),
    // Units.radiansToDegrees(kMaxAngularSpeedRadiansPerSecondSquared));
  }
}
