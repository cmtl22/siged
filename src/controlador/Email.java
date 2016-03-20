package controlador;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class Email {

    private final Properties properties = new Properties();
    private Session session;

    private void init() {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.mail.sender", "cmautl1990@gmail.com");
        properties.put("mail.smtp.password", "anto021990");
        properties.put("mail.smtp.user", "cmautl1990@gmail.com");
        properties.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(properties);
    }

    public boolean sendAjunto(String destino, String asunto, String mensaje, String path, String nombreArchivo) {
        init();
        try {
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(path)));
            adjunto.setFileName(nombreArchivo);

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            message.setSubject(asunto);
            message.setContent(multiParte);

            Transport t = session.getTransport("smtp");
            t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            return true;
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al enviar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean send(String destino, String asunto, String mensaje) {
        init();
        try {
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            message.setSubject(asunto);
            message.setContent(multiParte);

            Transport t = session.getTransport("smtp");
            t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            return true;
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al enviar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
