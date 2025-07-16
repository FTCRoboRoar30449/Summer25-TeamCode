# Summer ’25 FTC Robot — Team Code

This repository hosts **all off‑season 2025 software** for our mecanum‑drive robot with a pivot‑and‑slide arm, grabber, and dual‑vision stack (AprilTag + TensorFlow).  
It follows the standard two‑module FTC layout:

## Folder Structure

```text
FtcRobotController/                     ← FIRST SDK (leave untouched)

TeamCode/                               ← **all team‑written code lives here**
├─ build.gradle                         ← add external deps (Road Runner, OpenCV…)
└─ src/
   └─ main/
      ├─ java/org/firstinspires/ftc/teamcode/
      │  ├─ config/                     # season constants (wheel dia, PID, ports)
      │  │   ├─ DriveConstants.java
      │  │   ├─ ArmConstants.java
      │  │   └─ VisionConstants.java
      │  ├─ hardware/                   # thin wrappers around DcMotor, Servo, IMU
      │  │   ├─ MotorEx.java
      │  │   ├─ ServoEx.java
      │  │   └─ IMUEx.java
      │  ├─ localization/               # PedroPath impl
      │  │   └─ Localizer.java
      │  ├─ subsystems/                 # Homeostasis “plants” (one per mechanism)
      │  │   ├─ drivetrain/ MecanumDriveRR.java
      │  │   ├─ arm/     {Pivot,LinearSlide,Grabber}.java
      │  │   └─ vision/  {AprilTagDetector,TFObjectDetector}.java
      │  ├─ commands/                   # reusable actions (command‑based style)
      │  │   ├─ drive/   {DriveFieldCentric,FollowPathAction}.java
      │  │   ├─ vision/  AutoAlignToTag.java
      │  │   └─ scoring/ PickupSequence.java
      │  ├─ opmodes/                    # what shows up on Driver Station
      │  │   ├─ auto/    {AutoBlueLeft,AutoRedRight,AutoCenter}.java
      │  │   ├─ teleop/  TeleOpMain.java
      │  │   └─ tuning/  {TrackWidthTuner,SlidePIDTuner}.java
      │  ├─ util/                       # math helpers, dashboard wrappers
      │  │   ├─ PoseMath.java
      │  │   └─ TelemetryPacketUtil.java
      │  └─ actions/                    # PedroPath actions (wait, series, etc.)
      │      └─ WaitUntilAction.java
      ├─ res/
      │  ├─ xml/ robot_config.xml       # pre‑baked HW map for Driver Station - (will come into play in the future)
      │  └─ raw/ model_2024‑25.tflite   # TF‑Lite model & camera calib - (will come into play in the future)
      └─ assets/
         ├─ trajectories/ *.json        # Pedro Pathing trajs
         └─ dashboard/                  # FTCDashboard layouts
test/java/…                             # JUnit tests

libs/                                   # third‑party .aar/.jar (AprilTag, FTCLib)
docs/                                   # CAD renders, wiring diagrams, season notes
```

## Contributing Guidelines

#### 1. One feature per branch / pull request
- Branch names like feature/slides-pid or fix/teleop-field-centric.

#### 2. Where does my code go?
- **New mechanism** → `subsystems/` (plus matching `commands/`)
- **New autonomous path** → JSON in `assets/trajectories/` + OpMode in `opmodes/auto/`
- **Math or utilities** → `util/`

#### 3. Commit style — start with a verb:
- Add SlidePIDTuner, Fix intake stall, Refactor PoseMath.

#### 4.Test before PR — test code if possible.
- /gradlew lint test and verify the APK installs.
