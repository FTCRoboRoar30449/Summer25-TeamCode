package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotHardware {

    public DcMotor LFMotor, LBMotor, RFMotor, RBMotor, PivotRot, ArmL, ArmR;
    public Servo ClawOC, ClawRot, HeadRot;
    public Telemetry telemetry;

    public RobotHardware(HardwareMap hwMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        LFMotor = hwMap.get(DcMotor.class, "LFMotor");
        RFMotor = hwMap.get(DcMotor.class, "RFMotor");
        LBMotor = hwMap.get(DcMotor.class, "LBMotor");
        RBMotor = hwMap.get(DcMotor.class, "RBMotor");

        PivotRot = hwMap.get(DcMotor.class, "PivotRot");
        ArmL = hwMap.get(DcMotor.class, "ArmL");
        ArmR = hwMap.get(DcMotor.class, "ArmR");

        ClawOC = hwMap.get(Servo.class, "ClawOC");
        ClawRot = hwMap.get(Servo.class, "ClawRot");
        HeadRot = hwMap.get(Servo.class, "HeadRot");

        setMotorDirections();
        initMotorModes();
    }

    private void setMotorDirections() {
        LFMotor.setDirection(DcMotor.Direction.FORWARD);
        LBMotor.setDirection(DcMotor.Direction.FORWARD);
        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        RBMotor.setDirection(DcMotor.Direction.REVERSE);
        PivotRot.setDirection(DcMotor.Direction.FORWARD);
        ArmL.setDirection(DcMotor.Direction.REVERSE);
        ArmR.setDirection(DcMotor.Direction.FORWARD);
    }

    private void initMotorModes() {
        for (DcMotor motor : new DcMotor[]{LFMotor, LBMotor, RFMotor, RBMotor, PivotRot, ArmL, ArmR}) {
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}

