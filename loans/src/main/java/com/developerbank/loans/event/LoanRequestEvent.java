package com.developerbank.loans.event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoanRequestEvent {
    private Long loadRequestId;
    private String mobileNumber;
    private EventType eventType;
    private LocalDateTime timestamp;

    public LoanRequestEvent() {}

    public LoanRequestEvent(Long loadRequestId, String mobileNumber, EventType eventType) {
        this.loadRequestId = loadRequestId;
        this.mobileNumber = mobileNumber;
        this.eventType = eventType;
        this.timestamp = LocalDateTime.now();
    }
}
