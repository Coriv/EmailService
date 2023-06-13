package com.microservices.emailservice;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMqListener {

    private final EmailService emailService;
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener
    public void sendEmail() {
        rabbitTemplate.
    }

}
