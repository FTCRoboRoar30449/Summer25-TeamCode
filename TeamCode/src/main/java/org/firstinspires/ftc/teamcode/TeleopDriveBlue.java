package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp Drive Blue", group = "Blue OpModes")
public class TeleopDriveBlue extends LinearOpMode {

    RobotHardware robot;
    MechController mechController;
    MechState currentState;
    boolean clawOpen = true;

    @Override
    public void runOpMode() {

        robot = new RobotHardware(hardwareMap, telemetry);
        mechController = new MechController(robot);
        currentState = MechState.IDLE_POSITION;

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;
            double max = Math.max(Math.abs(drive) + Math.abs(turn) + Math.abs(strafe), 1);
            driveRobot(drive, strafe, turn, max);

            if (gamepad1.x) {
                currentState = MechState.SUB_POSITION;
                mechController.handleMechState(currentState);
                toggleClaw();
                currentState = MechState.RESET_POSITION;
                mechController.handleMechState(currentState);
            }

            if (gamepad1.y) {
                currentState = MechState.HIGH_BASKET_POSITION;
                mechController.handleMechState(currentState);
                toggleClaw();
                currentState = MechState.RESET_POSITION;
                mechController.handleMechState(currentState);
            }

            if (gamepad1.a) {
                currentState = MechState.ENDGAME_POSITION;
                mechController.handleMechState(currentState);
            }

            if (gamepad1.b) {
                toggleClaw();
            }

            telemetry.addData("Current State", currentState);
            telemetry.update();
        }
    }

    public void driveRobot(double drive, double strafe, double turn, double max) {
        robot.LFMotor.setPower((drive + turn + strafe) / max);
        robot.RFMotor.setPower((drive - turn - strafe) / max);
        robot.LBMotor.setPower((drive + turn - strafe) / max);
        robot.RBMotor.setPower((drive - turn + strafe) / max);
    }

    public void toggleClaw() {
        clawOpen = !clawOpen;
        robot.ClawOC.setPosition(clawOpen ? 1.0 : 0.0); // Change these if needed
    }
}
