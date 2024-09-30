package co.edu.unicauca.cuychair.common.notificationPlugin;

/**
 * Plugin that is capable of Notification Managing
 * @author Frdy
 */
public interface INotificationPlugin {

    /**
     * Things that the plugin has to do at plugin initialization
     */
    void start();

    /**
     * Processes the notification to be sent
     * @param notification notification to be processed by the plugin
     */
    void sendNotification(Notification notification);

}
