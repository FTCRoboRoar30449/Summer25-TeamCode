package org.firstinspires.ftc.teamcode;

// MechState.java
public enum MechState {
<<<<<<< Updated upstream
    IDLE_POSITION,             // 1
    COLLECTING_PS_POSITION,    // 2
    RESET_POSITION,            // 3
    HIGH_BASKET_POSITION,      // 4
    SUB_POSITION,              // 5
    ENDGAME_POSITION,          // 6
    LOW_BASKET_POSITION,       // 7 - STRETCH GOAL
    SPECIMEN_POSITION          // 8 - STRETCH GOAL
}
=======

    public boolean checkState;
    public int currentState;
    /*

    Idle Position = 1
    Collecting PS Position = 2
    Reset Position = 3
    High Basket Position = 4
    Sub Position = 5
    Endgame Position = 6
    *Low Basket Position = 7
    *Specimen Position = 8

     */

    // Updatewith your states these are just samples for yall to get started
    IDLE_POSITION(FConstants.LOW_BASKET_ARM_POS),
    COLLECTING_PS_POSITION(FConstants.LOW_BASKET_ARM_POS),

    public final double armPosition;

    MechState(double armPosition) {
        this.armPosition = armPosition;
    }

    // Transition logic and custom actions can be added here if needed
    public changeState(int x, boolean checkState) {
        if (checkState == true) {

        }
        else {
            currentState = x;
        }
    }
}
>>>>>>> Stashed changes
