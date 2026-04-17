package com.developerbank.cards.kafka;

import com.developerbank.cards.event.LoanRequestEvent;
import com.developerbank.cards.service.ICardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class LoanRequestConsumer {

    @Autowired
    ICardsService cardsService;

    @KafkaListener(topics = "loan-request", groupId = "loan-service-group")
    public void consume(LoanRequestEvent event) {
        cardsService.processRequest(event);

    }
}
