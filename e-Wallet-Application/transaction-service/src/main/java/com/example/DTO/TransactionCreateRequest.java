package com.example.DTO;

import com.example.Model.Transaction;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionCreateRequest {

    @NotBlank
    private String receiver;

    @NotBlank
    private String sender;

    @Min(1)
    private Long amount; // lowest denomination

    private String reason;
}
