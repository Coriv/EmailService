package com.microservices.emailservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final RabbitTemplate rabbitTemplate;
    private final JavaMailSender mailSender;
    private final MailMessageConfig messageConfig;

    public void sendWelcomeNotification(String email) {
        try {
            log.info("Trying to send email to: " + email);
            mailSender.send(prepareMailMessage(email));
            log.info("Mail to " + email + " sent successfully.");
        } catch (Exception e) {
            log.error("Something went wrong during sending email to: " + email);
        }
    }

   private SimpleMailMessage prepareMailMessage(String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject(messageConfig.getNEW_USER_EMAIL_TOPIC());
        mailMessage.setText(messageConfig.getNEW_USER_EMAIL_MESSAGE());
        return mailMessage;
   }
}
