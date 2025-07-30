package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.*;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MechController {

    private final RobotHardware robot;
    private final Telemetry telemetry;

    private static final double TICKS_PER_FULL_ROTATION = 537.6;
    private static final double MAX_SERVO_ROTATION = 300.0;
    private static final double MAX_LENGTH_PER_STAGE = 244.0;
    private static final double DISTANCE_PER_ROTATION = 120.0;

    private double ClawOCConstant = 0;
    private double HeadRotConstant = 0;
    private double ClawRotConstant = 0;

    public MechController(RobotHardware robot) {
        this.robot = robot;
        this.telemetry = robot.telemetry;
    }

    private double CalculateServoPosition(double input, double offset) {
        double position = (input + offset) / MAX_SERVO_ROTATION;
        return Math.max(0.0, Math.min(1.0, position));
    }

    private double CalculatePivotTicks(double degrees) {
        return (TICKS_PER_FULL_ROTATION / 360.0) * degrees;
    }

    private double CalculateArmTicks(double numOfStages) {
        double travelDistance = numOfStages * MAX_LENGTH_PER_STAGE;
        double numOfRotations = travelDistance / DISTANCE_PER_ROTATION;
        return numOfRotations * TICKS_PER_FULL_ROTATION;
    }

    public void handleMechState(MechState state) {
        switch (state) {
            case IDLE_POSITION:
                movePivotAndArms(0, 0);
                break;

            case HIGH_BASKET_POSITION:
                setClawAndHead(60, 135, 90);
                movePivotAndArms(-10, 4);
                break;

            case ENDGAME_POSITION:
                setClawAndHead(-60, 225, 90);
                movePivotAndArms(-10, 1);
                break;

            case RESET_POSITION:
            case SUB_POSITION:
            case COLLECTING_PS_POSITION:
            case LOW_BASKET_POSITION:
            case SPECIMEN_POSITION:
                // TODO: Fill in these states
                break;
        }


        telemetry.addData("PivotRot isBusy", robot.PivotRot.isBusy());
        telemetry.addData("PivotRot Pos", robot.PivotRot.getCurrentPosition());
        telemetry.addData("PivotRot Target", robot.PivotRot.getTargetPosition());

        telemetry.addData("ArmL isBusy", robot.ArmL.isBusy());
        telemetry.addData("ArmL Pos", robot.ArmL.getCurrentPosition());
        telemetry.addData("ArmL Target", robot.ArmL.getTargetPosition());

        telemetry.addData("ArmR isBusy", robot.ArmR.isBusy());
        telemetry.addData("ArmR Pos", robot.ArmR.getCurrentPosition());
        telemetry.addData("ArmR Target", robot.ArmR.getTargetPosition());
        telemetry.update();

    }

    private void setClawAndHead(double clawOC, double clawRot, double headRot) {
        robot.ClawOC.setPosition(CalculateServoPosition(clawOC, ClawOCConstant));
        robot.ClawRot.setPosition(CalculateServoPosition(clawRot, ClawRotConstant));
        robot.HeadRot.setPosition(CalculateServoPosition(headRot, HeadRotConstant));
    }

    private void movePivotAndArms(double pivotDeg, double armStages) {
        double pivotTicks = CalculatePivotTicks(pivotDeg);
        robot.PivotRot.setTargetPosition((int) pivotTicks);
        robot.PivotRot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.PivotRot.setPower(0.5);

        double armTicks = CalculateArmTicks(armStages);
        for (DcMotor arm : new DcMotor[]{robot.ArmL, robot.ArmR}) {
            arm.setTargetPosition((int) armTicks);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(0.5);
        }

        telemetry.addData("Pivot Target", pivotTicks);
        telemetry.addData("Arm Target", armTicks);
        telemetry.update();

        System.out.println("Pivot Ticks: " + pivotTicks);
        System.out.println("Arm Ticks: " + armTicks);
    }
}
