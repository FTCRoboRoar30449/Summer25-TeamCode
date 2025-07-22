# Summer ’25 FTC Robot — Team Code

## FILE STRUCTURE

src/
└── org/firstinspires/ftc/teamcode/
    ├── LConstants.java         // Robot/location constants (optional)
    ├── FConstants.java         // Other field or function constants (optional)
    ├── AutoBlue.java           // Autonomous for blue side
    ├── AutoRed.java            // Autonomous for red side
    ├── TeleopDriveRed.java        // TeleOp control with FSM/button mapping logic Red
    |── TeleopDriveRed.java        // TeleOp control with FSM/button mapping logic Blue
    ├── MechState.java          // Enum for mechanism 'preset' positions and state logic
    ├── RobotHardware.java      // Handles all motors, servos, sensors (limit switches, etc.)
