package co.edu.unicauca.cuychair.notificationplugin.email;

import co.edu.unicauca.cuychair.common.notificationPlugin.INotificationPlugin;
import co.edu.unicauca.cuychair.common.notificationPlugin.Notification;
import co.edu.unicauca.cuychair.common.notificationPlugin.Notification.Entity;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

/**
 * @author Frdy
 */
public class DefaultNotificationEmailPlugin implements INotificationPlugin {

    private static String sender = "fredyanaya@unicauca.edu.co";

    @Override
    public void start() {
    }

    @Override
    public void sendNotification(Notification notification) {
        String destinatario = notification.contact().email();

        Email email = getEmailByType(notification);
        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "easy.conference.prueba@gmail.com", "jeybwgiqzfmazdma")
                .buildMailer();
        if (mailer.validate(email)) {
            mailer.sendMail(email);
        } else {
            System.out.println("Hay un problema con el email");
        }
    }

    private Email getEmailByType(Notification notification) {
        StringBuilder sbCuerpo = new StringBuilder();

        switch (notification.actionState()) {
            case Notification.ActionState.OK:
                sbCuerpo.append("Se ha ");
                break;
            case Notification.ActionState.FAIL:
                sbCuerpo.append("No se ha ");
                break;
        }

        switch (notification.action()) {
            case Notification.Action.CREATION:
                sbCuerpo.append("creado ");
                break;
            case Notification.Action.DELETION:
                sbCuerpo.append("eliminado ");
                break;
            case Notification.Action.MODIFICATION:
                sbCuerpo.append("modificado ");
                break;
        }
        sbCuerpo.append("tu ");

        switch (notification.entity()) {
            case Entity.USER:
                sbCuerpo.append("usuario");
                break;
            case Entity.CONFERENCE:
                sbCuerpo.append("conferencia");
                break;
        }
        sbCuerpo.append(".");

        return EmailBuilder.startingBlank().from(sender).to(notification.contact().email()).withSubject("Notificacion de plugin").withPlainText(sbCuerpo.toString()).buildEmail();
    }

}
