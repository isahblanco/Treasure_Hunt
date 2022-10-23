package com.example.util;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

// Envía emails asociados a un servidor Smtp

public class SimpleMail {

    // Clase auxiliar para enviar correos de recuperacion con la contraseña del usuario
    // Creamos una sesion conectada a un servidor de correo Smtp Gmail.
    public static void sendMail(String email, String user, String password) throws Exception{
        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "help.treasure.hunt@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("help.treasure.hunt@gmail.com", "treasurehuntPASSWORD");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Treasure Hunt. Recupera tu contraseña!");

            // Now set the actual message
            message.setText("Mensaje del equipo de Treasure Hunt:\n\nLa contraseña asociada a su usuario: " + user + "es: " + password + "\n\n(Mensaje generado automáticamente. Por favor, no conteste al mensaje.)");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}