/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  //CONTROLLERs
  //driver
  public static int vroom_stick = 0;
  public static int drA = 1;
  public static int drB = 2;
  public static int drY = 3;
  public static int drX = 4;
  public static int drLB = 5;
  public static int drRB = 6;
  //operater
  public static int beepboop_stick = 3;
  public static int op1 = 1;
  public static int op2 = 2;
  public static int op3 = 3;
  public static int op4 = 4;
  public static int op5 = 5;
  public static int op6 = 6;
  public static int op7 = 7;
  public static int op8 = 8;
  public static int op9 = 9;
  public static int op10 = 10;


  //DRIVE MOTORS
  public static int _lMaster = 2;
  public static int _rMaster = 5;
  public static int _lSlave1 = 3;
  public static int _rSlave1 = 6;
  public static int _lSlave2 = 4;
  public static int _rSlave2 = 7;

  //Shooter motors
  public static int shooter1 = 31;
  public static int shooter2 = 32;

  //intake motor
  public static int intake = 21;
  public static int arm = 22;

  //schwoop motors + sensor
  public static int schwoop = 23;
  
  //climber motors
  public static int climber1 = 41;
  public static int climber2 = 42;
  //cameras

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
