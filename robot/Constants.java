/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //driver
    public static int vroom_stick = 0;
    public static int drA = 1;
    public static int drB = 2;
    public static int drY = 3;
    public static int drX = 4;
    public static int drLB = 5;
    public static int drRB = 6;
    //operater
    public static int beepboop_stick = 1;
    public static int opA = 1;
    public static int opB = 2;
    public static int opX = 3;
    public static int opY = 4;
    public static int opLB = 5;
    public static int opRB = 6;

    //Drive Motors
    public static final int lMaster = 2;
    public static final int lSlave1 = 3;
    public static final int lSlave2 = 4;
    public static final int rMaster = 5;
    public static final int rSlave1 = 6;
    public static final int rSlave2 = 7;
    //Intake Motors
    public static final int intake = 21;
    public static final int arm = 22;
    //Shwoop motor + sensor
    public static final int shwoop = 23;

    //Shooter motors   
    public static final int shoot1 = 31;
    public static final int shoot2 = 32;

    //Climber motors
    public static final int climber1 = 41;
    public static final int climber2 = 42;

}
