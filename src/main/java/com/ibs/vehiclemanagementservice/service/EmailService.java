package com.ibs.vehiclemanagementservice.service;

import java.util.Locale;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class EmailService {

    public final JavaMailSender emailSender;
    private final TemplateEngine templateEngine;
    private final SpringTemplateEngine thymeleafTemplateEngine;

    public EmailService(
            JavaMailSender emailSender,
            TemplateEngine templateEngine,
            SpringTemplateEngine thymeleafTemplateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
        this.thymeleafTemplateEngine = thymeleafTemplateEngine;
    }

    public void sendSimpleMessage(
            String to,
            String subject,
            String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }

    @Async
    public void sendMessageUsingThymeleafTemplate(
            String to,
            String subject) throws MessagingException {

        final Context ctx = new Context(Locale.US);
        ctx.setVariable("name", "Ajith");

        final MimeMessage mimeMessage = this.emailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper =
                new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setTo(to);


        final String htmlContent = this.templateEngine.process("vehicle-pass-approved.html", ctx);
        mimeMessageHelper.setText(htmlContent, true);

        emailSender.send(mimeMessage);
    }
}
