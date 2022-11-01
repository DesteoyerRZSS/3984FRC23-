// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.auto.SplineAuto;
import frc.robot.commands.swerve.SetSwerveDriveCmd;
import frc.robot.commands.swerve.ZeroHeadingCmd;
import frc.robot.subsystems.SwerveSys;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  final SwerveSys m_swerveSys = new SwerveSys();

  private final SendableChooser<Command> m_autoChooser = new SendableChooser<Command>();

  // The driver's controller

  //FIXME: Currently set to work with two joysticks (lateral movement on left and rotation on right). You may want to change.

  private final Joystick m_leftJoystick = new Joystick(0);
  private final Joystick m_rightJoystick = new Joystick(1);

  private final JoystickButton m_rightTrigger = new JoystickButton(m_rightJoystick, 1);
  private final JoystickButton m_rightThumbBtn = new JoystickButton(m_rightJoystick, 2);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_swerveSys.setIdleMode(true);

    // Configure the button bindings
    configDriverBindings();
    configOperatorBindings();

    initializeAutoChooser();
  }

  private void configDriverBindings() {
    m_swerveSys.setDefaultCommand(
    new SetSwerveDriveCmd(
        m_swerveSys,
        //FIXME: Configure driver controls here
        () -> m_leftJoystick.getY(), // Throttle input
        () -> m_leftJoystick.getX(), // Strafe input
        () -> m_rightJoystick.getX(), // Rotation input
        () -> m_rightTrigger.get())); // Lock wheels trigger

    m_rightThumbBtn.whenPressed(new ZeroHeadingCmd(m_swerveSys)); // Zeroes robot heading when pressed
  }

  private void configOperatorBindings() {

  }

  private void initializeAutoChooser() {
    m_autoChooser.setDefaultOption("Do Nothing", new WaitCommand(0));
    m_autoChooser.addOption("Spline", new SplineAuto(m_swerveSys));

    SmartDashboard.putData("Auto Selector", m_autoChooser);

  }

  public void simulationPeriodic() {
    periodic();
  }

  public void periodic() {

  }

  public double getThrottle() {
    return -m_leftJoystick.getThrottle();
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoChooser.getSelected();
  }

}
