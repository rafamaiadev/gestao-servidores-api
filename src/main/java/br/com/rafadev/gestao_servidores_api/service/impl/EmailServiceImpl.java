package br.com.rafadev.gestao_servidores_api.service.impl;

import br.com.rafadev.gestao_servidores_api.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMessage(String to, String subject, String text) {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true, "text/html; charset=utf-8");
            helper.setTo(to);
            message.setSubject(subject);
            message.setContent(text, "text/html; charset=utf-8");
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
