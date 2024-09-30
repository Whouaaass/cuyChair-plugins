/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.edu.unicauca.cuychair.notificationplugin.email;

import co.edu.unicauca.cuychair.common.notificationPlugin.Contact;
import co.edu.unicauca.cuychair.common.notificationPlugin.Notification;
import co.edu.unicauca.cuychair.common.notificationPlugin.Notification.Action;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.platform.commons.function.Try.success;

/**
 *
 * @author Frdy
 */
public class DefaultNotificationEmailPluginTest {
    
    
    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of start method, of class DefaultNotificationEmailPlugin.
     */
    @org.junit.jupiter.api.Test
    public void testStart() {
        System.out.println("start");
        DefaultNotificationEmailPlugin instance = new DefaultNotificationEmailPlugin();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sendNotification method, of class DefaultNotificationEmailPlugin.
     */
    @org.junit.jupiter.api.Test
    public void testSendNotification() {
        System.out.println("sendNotification");
        Contact contact = new Contact("juanmoran@unicauca.edu.co", null);
        Notification notification = new Notification(contact, Action.CREATION, Notification.Entity.CONFERENCE, Notification.ActionState.FAIL);
        DefaultNotificationEmailPlugin instance = new DefaultNotificationEmailPlugin();
        instance.sendNotification(notification);
        // TODO review the generated test code and remove the default call to fail.
    }

    
}
