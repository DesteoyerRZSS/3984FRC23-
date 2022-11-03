package frc.robot.commands.auto.paths;

import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.commands.PPSwerveControllerCommand;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.swerve.SetSwerveIdleModeCmd;
import frc.robot.commands.swerve.SetSwerveOdometryCmd;
import frc.robot.subsystems.SwerveSys;

public class Figure8Path extends SequentialCommandGroup {
  public Figure8Path(SwerveSys swerveDrive) {
    PathPlannerTrajectory trajectory = PathPlanner.loadPath("Figure8", 3,
        3, false);
    PPSwerveControllerCommand command = new PPSwerveControllerCommand(
        trajectory,
        swerveDrive::getPoseMeters,
        DriveConstants.kSwerveKinematics,
        swerveDrive.getXPidController(),
        swerveDrive.getYPidController(),
        swerveDrive.getThetaPidController(),
        swerveDrive::setSwerveModuleStatesAuto,
        swerveDrive);
    addCommands(
        new SetSwerveOdometryCmd(swerveDrive, trajectory.getInitialPose()),
        command,
        new SetSwerveIdleModeCmd(swerveDrive, false)
            .andThen(() -> swerveDrive.drive(0, 0, 0, false, false)));
  }
}
