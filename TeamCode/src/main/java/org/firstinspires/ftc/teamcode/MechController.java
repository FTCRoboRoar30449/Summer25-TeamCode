package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;


public class MechController {

    // Reference to the robot’s hardware
    org.firstinspires.ftc.teamcode.hardware.RobotHardware robot;

    // Constructor
    public MechController(org.firstinspires.ftc.teamcode.hardware.RobotHardware robot) {
        this.robot = robot;
    }


    public void handleMechState(MechState state) {
        switch (state) {
            case IDLE_POSITION:
                robot.PivotRot.setPower(100); // robot gives you access to all the available robot hardware and pivotRot, Arm1 are all different motors following that you can add the task you want that motor to do.
                // TODO: ADD CODE
                robot.ClawOC.setPosition(0);
                robot.ClawRot.setPosition(135/300);
                robot.HeadRot.setPosition(90/300);
                robot.PivotRot.setTargetPosition(597);
                robot.PivotRot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.ArmL.setPower(0);
                robot.ArmR.setPower(0);
                break;

            case COLLECTING_PS_POSITION:
                // TODO: Add code for Collecting Pixel Stack
                break;

            case RESET_POSITION:
                // TODO: Add code for Reset
                break;

            case HIGH_BASKET_POSITION:
                // TODO: Add code for High Basket scoring
                break;

            case SUB_POSITION:
                // TODO: Add code for Substation
                break;

            case ENDGAME_POSITION:
                // TODO: Add code for Endgame position
                break;

            case LOW_BASKET_POSITION:
                // TODO: Add code for Low Basket
                break;

            case SPECIMEN_POSITION:
                // TODO: Add code for Specimen handling
                break;

            default:
                // TODO: handle unknown states
                break;
        }
    }
}
