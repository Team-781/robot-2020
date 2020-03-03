/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import frc.robot.commands.RunShooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //DRIVER
  Joystick vroomstick = new Joystick(RobotMap.vroom_stick);
  Joystick beepboopstick = new Joystick(RobotMap.beepboop_stick);
  Button driverA = new JoystickButton(vroomstick, RobotMap.drA); //the port # for buttons are linked to the RobotMap int equivelent.
  Button drB = new JoystickButton(vroomstick, RobotMap.drB);
  Button drY = new JoystickButton(vroomstick, RobotMap.drY);
  Button drX = new JoystickButton(vroomstick, RobotMap.drX);
  Button drLB = new JoystickButton(vroomstick, RobotMap.drLB);
  Button drRB = new JoystickButton(vroomstick, RobotMap.drRB);
  public double DriverX() {
    return vroomstick.getRawAxis(4);
  }
  public double DriverY() {
    return vroomstick.getRawAxis(1);
  }
  public boolean drLT() {
    if (vroomstick.getRawAxis(2) > 0.5) {
      return true;
    }
    else {
      return false;
    }
  }
  public boolean drRT() {
    if (vroomstick.getRawAxis(3) > 0.5) {
      return true;
    }
    else {
      return false;
    }
  }

  //command beep boop area
  public OI() {
    driverA.whileHeld(new RunShooter());
  }
  
  




  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  
}
