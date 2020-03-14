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
    public static int drA = 4;
    public static int drB = 2;
    public static int drY = 1;
    public static int drX = 3;
    public static int drLB = 5;
    public static int drRB = 6;
    //operater
    public static int beepboop_stick = 1;
    public static int op1 = 1;
    public static int op2 = 2;
    public static int op3 = 3;
    public static int op4 = 4;
    public static int op5 = 5;
    public static int op6 = 6;
    public static int op8 = 8;
    public static int op7 = 7;
    public static int op9 = 9;
    public static int op10 = 10;
    public static int op11 = 11;
    public static int op12 = 12;
    public static int op13 = 13;
    public static int op14 = 14;
    public static int op15 = 15;
    public static int op16 = 16;
    public static int op17 = 17;
    public static int op18 = 18;
    public static int op19 = 19;
    public static int op20 = 20;
    public static int op21 = 21;
    public static int op22 = 22;
    public static int op23 = 23;
    public static int op24 = 24;

    //Drive Motors
    public static final int lMaster = 2;
    public static final int lSlave1 = 3;
    public static final int lSlave2 = 4;
    public static final int rMaster = 5;
    public static final int rSlave1 = 6;
    public static final int rSlave2 = 7;
    //Intake Motor
    public static final int intake = 21;

    //Shwoop motor + sensor
    public static final int shwoop = 23;
    public static final int shwoopSensor = 0;
    //Shooter motors   
    public static final int shoot1 = 31;
    public static final int shoot2 = 32;

    //Climber motors
    public static final int climber1 = 41;
    public static final int climber2 = 42;

    //parascope solenoid
    public static final int parascope1 = 2;
    public static final int parascope2 = 3;

    //arm + arm positions
    public static final int arm = 22;

    public static final int armVertical = 660;
    public static final int armDown = 0;
    public static final int armHome = 183;

    //SHOOTING DATA
    
    //20ft, 204pos angle, 80% power
    public static final int armFAR = 200;
    public static final double shooterFAR = 0.8;
    public static final double distanceFAR = 0.13; //Need to find distance in limelight ta

    //15ft, 188pos angle, 70% power
    public static final int armMED = 210;
    public static final double shooterMED = 0.7;
    public static final double distanceMED = 0.165; //Need to find distance in limelight ta

    //11-12ft, 212pos angle, 70% power
    public static final int armNEAR = 220;
    public static final double shooterNEAR = 0.7;
    public static final double distanceNEAR = 0.22; //Need to find in distance in limelight ta

}
