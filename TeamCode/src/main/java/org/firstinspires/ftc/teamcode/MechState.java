// Import needed libraries


public enum MechState {

    // Updatewith your states these are just samples for yall to get started
    IDLE_POSITION(FConstants.LOW_BASKET_ARM_POS),
    COLLECTING_PS_POSITION(FConstants.LOW_BASKET_ARM_POS),

    public final double armPosition;

    MechState(double armPosition) {
        this.armPosition = armPosition;
    }

    // Transition logic and custom actions can be added here if needed
}