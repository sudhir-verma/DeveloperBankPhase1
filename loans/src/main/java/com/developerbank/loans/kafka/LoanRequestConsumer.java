package com.developerbank.loans.kafka;

import com.developerbank.loans.event.LoanRequestEvent;
import com.developerbank.loans.service.LoanRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class LoanRequestConsumer {

    /*This consumer Moved in cards service
     */
    /*@Autowired
    LoanRequestService loanRequestService;

    @KafkaListener(topics = "loan-request", groupId = "loan-service-group")
    public void consume(LoanRequestEvent event) {
        loanRequestService.processEvent(event);
    }*/
}
