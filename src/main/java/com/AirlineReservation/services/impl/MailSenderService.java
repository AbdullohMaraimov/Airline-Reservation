package com.AirlineReservation.services.impl;


import com.AirlineReservation.models.dtos.CreateFlightDto;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.Map;

@Component
public class MailSenderService {
    private final JavaMailSender javaMailSender;
    private final Configuration configuration;

    public MailSenderService(JavaMailSender javaMailSender,
                             Configuration configuration) {
        this.javaMailSender = javaMailSender;
        this.configuration = configuration;
    }

    @Async
    public void sendFreeMarkerMail(CreateFlightDto flight) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("pdponline");
            mimeMessageHelper.setTo("to@gmail.com");
            mimeMessageHelper.setSubject("Notification about flight");
            Template template = configuration.getTemplate("flight_notification.ftlh");

            Map<String, Object> objectModel = Map.of("flight", flight);
            String htmlMailContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, objectModel);
            mimeMessageHelper.setText(htmlMailContent, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

}
