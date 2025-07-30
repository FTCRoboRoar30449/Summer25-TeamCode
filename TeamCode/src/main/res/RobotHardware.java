package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotHardware {

    public DcMotor LFMotor, LBMotor, RFMotor, RBMotor, PivotRot, ArmL, ArmR;
    public Servo ClawOC, ClawRot, HeadRot;

    public DigitalChannel BottomLimitSwitch;
    public DigitalChannel TopLimitSwitch;

    public RobotHardware(HardwareMap hwMap) {
        //Declaring all motors
        LFMotor = hwMap.get(DcMotor.class, "LFMotor"); // Left Front Motor
        RFMotor = hwMap.get(DcMotor.class, "RFMotor"); // Right Front Motor
        LBMotor = hwMap.get(DcMotor.class, "LBMotor"); // Left Back Motor
        RBMotor = hwMap.get(DcMotor.class, "RBMotor"); // Right Back Motor

        PivotRot = hwMap.get(DcMotor.class, "PivotRot"); // Pivots linear slides
        ArmL = hwMap.get(DcMotor.class, "ArmL"); // Extends/Retracts linear slides 1
        ArmR = hwMap.get(DcMotor.class, "ArmR"); // Extends/Retracts linear slides 2

        //Declaring all servos
        ClawOC = hwMap.get(Servo.class, "ClawOC"); // Servo opens and closes the claw
        ClawRot = hwMap.get(Servo.class, "ClawRot"); // Servo rotates claw
        HeadRot = hwMap.get(Servo.class, "HeadRot"); // Servo moves the claw up and down

        //Declaring Limit Switches
        BottomLimitSwitch = hwMap.get(DigitalChannel.class, "BottomSwitch");
        TopLimitSwitch = hwMap.get(DigitalChannel.class, "TopSwitch");

        //Declaring DcMotor Direction
        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        RFMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RBMotor.setDirection(DcMotor.Direction.REVERSE);
        RBMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LFMotor.setDirection(DcMotor.Direction.FORWARD);
        LFMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LBMotor.setDirection(DcMotor.Direction.FORWARD);
        LBMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        PivotRot.setDirection(DcMotor.Direction.FORWARD);
        PivotRot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ArmL.setDirection(DcMotor.Direction.REVERSE);
        ArmL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ArmR.setDirection(DcMotor.Direction.FORWARD);
        ArmR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }


}
