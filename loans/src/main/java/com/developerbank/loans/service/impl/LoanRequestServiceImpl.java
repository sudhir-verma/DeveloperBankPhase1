package com.developerbank.loans.service.impl;


import com.developerbank.loans.dto.LoanRequestDto;
import com.developerbank.loans.event.EventType;
import com.developerbank.loans.event.LoanRequestEvent;
import com.developerbank.loans.kafka.LoadRequestProducer;
import com.developerbank.loans.service.LoanRequestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class LoanRequestServiceImpl implements LoanRequestService {

    @Autowired
    private LoadRequestProducer loadRequestProducer;

    @Override
    public void sendMessageToTopic(LoanRequestDto loanRequestDto) {

        Long loanId = 1000000000L + new Random().nextInt(900000000);
        LoanRequestEvent event = new LoanRequestEvent(loanId,loanRequestDto.getMobileNumber(), EventType.LOAN_REQUEST_INITIATED);
        loadRequestProducer.sendLoanEvent(event);
    }

    /*Moving this in cards service
     */
   /* @Override
    public void processEvent(LoanRequestEvent event) {
        System.out.println("Received event : " + event.getLoadRequestId());
        System.out.println("Received event: " + event.getEventType());
        System.out.println("Received event: " + event.getMobileNumber());
        System.out.println("Received event: " + event.getTimestamp());
    }*/
}
