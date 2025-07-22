import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOpDrive")
public class TeleopDrive extends OpMode {

    private RobotHardware robot;
    private MechState currentState;

    @Override
    public void init() {
        robot = new RobotHardware(hardwareMap);
        currentState = MechState.IDLE_POSITION; //Update with whatever you call your idle position
    }

    @Override
    public void loop() {
        // Drive control (UPDATE ACCORDING TO YOUR CODE)
        double drive = -gamepad1.left_stick_y; // forward/backward
        double turn  = gamepad1.left_stick_x;  // turning
        robot.leftDrive.setPower(drive + turn);
        robot.rightDrive.setPower(drive - turn);

        // FSM/button mapping
        if (gamepad1.x) {
           //do task for x button
        } else if (gamepad1.y) {
            //do task for y button pressed

        // Example limit switch safety reset
        if (!robot.limitSwitchLeft.getState()) {
            currentState = MechState.RESET_POSITION;
        }

        // Apply mechanism setpoint
        robot.arm.setPosition(currentState.armPosition);

        telemetry.addData("Arm State", currentState.name());
        telemetry.addData("Limit Left", robot.limitSwitchLeft.getState());
        telemetry.addData("Limit Right", robot.limitSwitchRight.getState());
    }
}
