package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class RobotHardware {

    public DcMotor frontLeft, frontRight, backLeft, backRight;
    public Servo arm, claw;

    public RobotHardware(HardwareMap hwMap) {
        frontLeft = hwMap.get(DcMotor.class, "frontLeft");
        frontRight = hwMap.get(DcMotor.class, "frontRight");
        backLeft = hwMap.get(DcMotor.class, "backLeft");
        backRight = hwMap.get(DcMotor.class, "backRight");

        
        claw = hwMap.get(Servo.class, "claw");

        // Add other motors, servos, sensors as needed
    }

    // Update wit your controler based drive functions
    public void setPower(double x, double y) {
        double leftPower = y + x;
        double rightPower = y - x;
        frontLeft.setPower(leftPower);
        backLeft.setPower(leftPower);
        frontRight.setPower(rightPower);
        backRight.setPower(rightPower);
    }

    // Add methods for controlling the arm, claw, etc.
}
