package ar.com.gestioncomercial.utils;

import org.apache.commons.mail.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailUtils {

    private static final Logger logger = Logger.getLogger(EmailUtils.class.getName());

    private static final String fromEmail = "ezequielcimiotto@gmail.com";

    private static final String EMAIL_TEMPLATE_REPARACION = "<html> <p>Estimado %s \n" +
            "La reparacion de su dispositivo se encuentra %s, Usted sera notificad@ cuando el estado" +
            " de la reparacion cambie." +
            "\n" +
            "%s"+
            "\n" +
            "Saludos, " +
            "Electronic Junin."+
            "</p></html>";

    private static final String EMAIL_TEMPLATE_STOCK_MINIMO = "Estimado Administrador, \n" +
            "El producto %s, se encuentra en stock minimo (%d)," +
            "Por favor verifique su stock. " +
            "\n" +
            "\n" +
            "Saludos.";

    private static final String EMAIL_TEMPLATE_NUEVA_SOLICITUD = "<html>" +
            "<p>Estimado Administrador, \n" +
            "El cliente %s, a solicitado una nueva \n" +
            "<a href=\"%s\" target=\"blank\">Reparacion.</a> " +
            "\n" +
            "\n" +
            "Saludos. </p> " +
            "</html>";

    private static final String EMAIL_TEMPLATE_CAMBIO_ESTADO_SOLICITUD = "<html>" +
            "<p>Estimado Administrador, \n" +
            "El cliente %s, %s la \n" +
            "<a href=\"%s\" target=\"blank\">Cotizacion.</a> " +
            "\n" +
            "Su respuesta fue: \"%s\""+
            "\n" +
            "Saludos. </p> " +
            "</html>";

    private static final String EMAIL_TEMPLATE_NUEVA_COTIZACION = "<html>" +
            "<p>Estimado Cliente %s, \n" +
            "Su solicitud de reparacion ha sido contestada con la siguiente " +
            "<a href=\"%s\" target=\"blank\">Cotizacion.</a>\n" +
            "Por favor verifique la cotizacion para tomar una decision. \n" +
            "\n" +
            "\n" +
            "Saludos. </p> " +
            "</html>";

    private static void sendEmail(String template, String fromEmail, String mail ){
        try {
        Email email = new HtmlEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("ferrmail08@gmail.com",
                "hsdaqekrgusxnkdg"));
        email.setSSLOnConnect(true);

        email.setFrom(fromEmail);

        email.setSubject("TestMail");
        email.setMsg(template);
        email.addTo(mail);
        email.send();
        } catch (EmailException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public static void reparacionCambioEstadoEmail(String nombreCliente, String emailCliente, String estado, String mensaje){

        String template = String.format(EMAIL_TEMPLATE_REPARACION, nombreCliente, estado, mensaje);

        sendEmail(template, fromEmail, emailCliente);
    }

    public static void solicitudReparacionCambioEstadoEmail(String nombreCliente, String emailCliente, String estado){

        String template = String.format(EMAIL_TEMPLATE_REPARACION, nombreCliente, estado);

        sendEmail(template, fromEmail, emailCliente);
    }

    public static void cotizacionCambioEstadoEmail(Long cotizacionId,
                                                   String nombreCliente,
                                                   String verbo,
                                                   String respuesta,
                                                   List<String> adminEmails){

        String cotizacionURL = JSFUtils.getAbsoluteURL()  +"/details.xhtml?id=" + cotizacionId;

        String template = String.format(EMAIL_TEMPLATE_CAMBIO_ESTADO_SOLICITUD, nombreCliente,verbo,cotizacionURL, respuesta);

        adminEmails.forEach(email -> sendEmail(template, fromEmail, email) );
    }

    public static void productoStockMinimoEmail(String productoNombre, int stockMinimo, List<String> adminEmails){
        String template = String.format(EMAIL_TEMPLATE_STOCK_MINIMO, productoNombre, stockMinimo);
        adminEmails.forEach(email -> sendEmail(template, fromEmail, email) );

    }

    public static void nuevaSolicitudReparacionEmail(String nombreCliente, Long solicitudReparacionId, List<String> adminEmails){

        String solicitudURL = JSFUtils.getAbsoluteURL() +"/details.xhtml?id=" +"?id=" + solicitudReparacionId;

        String template = String.format(EMAIL_TEMPLATE_NUEVA_SOLICITUD, nombreCliente, solicitudURL);
        adminEmails.forEach(email -> sendEmail(template, fromEmail, email) );
    }

    public static void nuevaCotizacionEmail(String nombreCliente, Long CotizacionId, String clienteMail){

        String cotizacionURL = JSFUtils.getAbsoluteURL() + "/respuesta_cotizacion.xhtml?id=" + CotizacionId;

        String template = String.format(EMAIL_TEMPLATE_NUEVA_COTIZACION, nombreCliente, cotizacionURL);
        sendEmail(template, fromEmail, clienteMail);
    }

    private String getEmailTemplate(){return null;}



}
