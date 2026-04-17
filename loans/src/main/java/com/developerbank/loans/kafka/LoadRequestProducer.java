package com.developerbank.loans.kafka;

import com.developerbank.loans.event.LoanRequestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoadRequestProducer {

    private final KafkaTemplate<Long, Object> kafkaTemplate;

    LoadRequestProducer(KafkaTemplate<Long, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLoanEvent(LoanRequestEvent event) {

        kafkaTemplate.send("loan-request", event.getLoadRequestId(), event);
    }

}
