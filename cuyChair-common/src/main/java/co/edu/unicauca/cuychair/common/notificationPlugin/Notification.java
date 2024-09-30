package co.edu.unicauca.cuychair.common.notificationPlugin;

/**
 * Notification that is "send" from the main app
 *
 * @author Frdy
 */
public record Notification(
        Contact contact,
        Action action,
        Entity entity,
        ActionState actionState) {

    /**
     * Action that has been done
     */
    public enum Action {
        CREATION,
        MODIFICATION,
        DELETION,
    }

    /**
     * Entity that has been "affected"
     */
    public enum Entity {
        USER,
        CONFERENCE
    }

    /**
     * State of the action that has been made
     */
    public enum ActionState {
        OK,
        FAIL
    }
}
