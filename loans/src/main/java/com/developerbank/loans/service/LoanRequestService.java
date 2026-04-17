package com.developerbank.loans.service;

import com.developerbank.loans.dto.LoanRequestDto;
import com.developerbank.loans.event.LoanRequestEvent;

public interface LoanRequestService {
    void sendMessageToTopic(LoanRequestDto loanRequestDto);

    /*Moving this in cards service
     */
    //void processEvent(LoanRequestEvent event);
}
