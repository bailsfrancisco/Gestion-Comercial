package ar.com.gestioncomercial.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailUtils {

    private static final Logger logger = Logger.getLogger(EmailUtils.class.getName());

    private static final String fromEmail = "ezequielcimiotto@gmail.com";

    private static final String EMAIL_TEMPLATE_REPARACION = "Hola %s \n" +
            "La reparacion de tu dispositivo esta en %s, Usted sera notificad@ cuando el estado" +
            " de la reparacion cambie." +
            "\n" +
            "\n" +
            "Saludos, "+ fromEmail;

    public static void sendEmail(String nombre, String mail, String estado){
        try {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("ferrmail08@gmail.com",
                "hsdaqekrgusxnkdg"));
        email.setSSLOnConnect(true);

        email.setFrom(fromEmail);

        email.setSubject("TestMail");
        email.setMsg(String.format(EMAIL_TEMPLATE_REPARACION, nombre, estado));
        email.addTo(mail);
        email.send();
        } catch (EmailException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private String getEmailTemplate(){return null;}



}
