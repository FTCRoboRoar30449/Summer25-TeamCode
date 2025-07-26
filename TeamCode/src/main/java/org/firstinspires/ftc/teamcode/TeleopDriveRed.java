package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.*;

@TeleOp(name = "TeleOp Drive Red", group = "Red OpModes")
public class TeleopDriveRed extends LinearOpMode {

    org.firstinspires.ftc.teamcode.hardware.RobotHardware robot;
    MechController mechController;
    MechState currentState;

    @Override
    public void runOpMode() {

        robot = new org.firstinspires.ftc.teamcode.hardware.RobotHardware(hardwareMap);
        mechController = new MechController(robot);
        currentState = MechState.IDLE_POSITION;

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();


        while (opModeIsActive()) {
            // ===== DRIVING =====
            double drive = -gamepad1.left_stick_y;  // Forward/Back
            double strafe = gamepad1.left_stick_x;  // Left/Right
            double turn = gamepad1.right_stick_x;   // Rotation

            // Call method to drive the robot (implement this later)
            driveRobot(drive, strafe, turn);

            // ===== MECHANISM CONTROLS =====

            // --- X Button ---
            if (gamepad1.x) {

                //TODO: CODE TO DRIVE TO COLLECTION LOCATION

                currentState = MechState.SUB_POSITION;
                mechController.handleMechState(currentState);

                //TODO: CODE TO DETECT AND GRAB THE GAME ELEMENT
                toggleClaw();

                currentState = MechState.RESET_POSITION;
                mechController.handleMechState(currentState);
            }

            // --- Y Button ---
            if (gamepad1.y) {

                //TODO: CODE TO DRIVE TO DROP LOCATION

                currentState = MechState.HIGH_BASKET_POSITION;
                mechController.handleMechState(currentState);
                toggleClaw();

                // Add an if statement or some form of checker to make sure you drop the game element and once you do then do the below:
                currentState = MechState.RESET_POSITION;
                mechController.handleMechState(currentState);
            }

            // --- A Button ---
            if (gamepad1.a) {

                //TODO: CODE TO DRIVE TO ENDGAME

                currentState = MechState.ENDGAME_POSITION;
                mechController.handleMechState(currentState);
            }

            // --- B Button ---
            if (gamepad1.b) {
                // Toggle claw open/close (implement this in MechController or here)
                toggleClaw();
            }

            telemetry.addData("Current State", currentState);
            telemetry.update();
        }
    }

    // Method to handle Mecanum drive
    public void driveRobot(double drive, double strafe, double turn) {
        // TODO: Add code for mecanum drive

    }

    // Method to toggle the claw (open/close)
    public void toggleClaw() {
        // TODO: Add logic to toggle the claw position
        // Use a boolean flag to track claw state
    }

    //If you need any other custom methods you can write that here
}
