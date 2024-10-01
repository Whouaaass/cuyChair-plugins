package plugin.simple.java.mail;

import co.edu.unicauca.cuychair.common.notificationPlugin.IEmailPlugin;
import domain.Conference;
import domain.Paper;
import domain.User;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class SimpleJava implements IEmailPlugin {
    @Override
    public void notifySendJobs(Paper paper, Conference conference, User author) {
        Mailer ma= MailerBuilder.withSMTPServer("smtp.gmail.com", 587, "cuychair@gmail.com", "cies amcp hfot rxhh")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .buildMailer();

        Email email= EmailBuilder.startingBlank()
                .from("Notificaciones cuyChair","cuychair@gmail.com")
                .to("Hola",author.getUserEmail())
                .withSubject("Estado de los productos")
                .withPlainText("Estimado autor\n\n\n" +
                        "Notificamos que se recibió de forma exitosa su trabajo para la Conferencia: "+conference.getTitle()+"\n\n"
                        +"Autor: "+author.getUserName()+"\n"
                        +"Trabajo: "+paper.getTitle()+"\n\n\n\n"
                        +"Gracias por todo su esfuerzo :)")
                .buildEmail();

        ma.sendMail(email);
    }

}
