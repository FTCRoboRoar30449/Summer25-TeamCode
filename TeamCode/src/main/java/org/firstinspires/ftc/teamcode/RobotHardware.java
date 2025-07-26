package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class RobotHardware {

    public DcMotor LFMotor, LBMotor, RFMotor, RBMotor, PivotRot, Arm1, Arm2;
    public Servo ClawOC, ClawRot, HeadRot;

    public RobotHardware(HardwareMap hwMap) {
        //Declaring all motors
        LFMotor = hwMap.get(DcMotor.class, "LFMotor"); // Left Front Motor
        RFMotor = hwMap.get(DcMotor.class, "RFMotor"); // Right Front Motor
        LBMotor = hwMap.get(DcMotor.class, "LBMotor"); // Left Back Motor
        RBMotor = hwMap.get(DcMotor.class, "RBMotor"); // Right Back Motor

        PivotRot = hwMap.get(DcMotor.class, "PivotRot"); // Pivots linear slides
        Arm1 = hwMap.get(DcMotor.class, "Arm1"); // Extends/Retracts linear slides 1
        Arm2 = hwMap.get(DcMotor.class, "Arm2"); // Extends/Retracts linear slides 2


        //Declaring all servos
        ClawOC = hwMap.get(Servo.class, "ClawOC"); // Servo opens and closes the claw
        ClawRot = hwMap.get(Servo.class, "ClawRot"); // Servo rotates claw
        HeadRot = hwMap.get(Servo.class, "HeadRot"); // Servo moves the claw up and down


        // Add other motors, servos, sensors as needed
    }


}
