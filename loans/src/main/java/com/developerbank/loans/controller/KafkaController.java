package com.developerbank.loans.controller;


import com.developerbank.loans.dto.ErrorResponseDto;
import com.developerbank.loans.dto.LoanRequestDto;
import com.developerbank.loans.dto.LoansDto;
import com.developerbank.loans.service.LoanRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sudhir Verma
 */

@Tag(
        name = "CRUD REST APIs for Loans in Developer Bank",
        description = "CRUD REST APIs in DeveloperBank to CREATE, UPDATE, FETCH AND DELETE loan details"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class KafkaController {

    private LoanRequestService loanRequestService;

    @Operation(
            summary = "Create Loan Request With Kafka",
            description = "REST API to create new loan request inside DeveloperBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping(value = "/submit-loan-request")
    public String sendMessage(@RequestBody LoanRequestDto loanRequestDto)
    {
        loanRequestService.sendMessageToTopic(loanRequestDto);
        return "Request sent Successfully to the your bank ";
    }
}
