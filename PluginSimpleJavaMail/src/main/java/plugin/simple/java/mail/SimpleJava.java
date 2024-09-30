package plugin.simple.java.mail;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class SimpleJava {

    public void notifySendJob() implements IEmailPlugin{

        @Override
        public void notifySendJob(Paper job, Conference confe,User author){
            Mailer ma= MailerBuilder.withSMTPServer("smtp.gmail.com", 587, "cuychair@gmail.com", "cies amcp hfot rxhh")
                    .withTransportStrategy(TransportStrategy.SMTP_TLS)
                    .buildMailer();

            Email email= EmailBuilder.startingBlank()
                    .from("Notificaciones cuyChair","cuychair@gmail.com")
                    .to("Hola",author.getEmail())
                    .withSubject("Estado de los productos")
                    .withPlainText("Los productos se agregaron correctamente")
                    .buildEmail();

            ma.sendMail(email);
        }
    }

}
