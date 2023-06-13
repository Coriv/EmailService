package com.microservices.emailservice;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MailMessageConfig {

    @Value("${cryptocurrency.market.email}")
    private String email;
    private final String NEW_USER_EMAIL_TOPIC = "Welcome on Cryptocurrency Market!";
    private final String NEW_USER_EMAIL_MESSAGE = "We are glad that you choose our service." +
            "If you need our help write: " + email;
}
