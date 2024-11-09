package com.example.msaccount.account;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransferRequest {
    @NotBlank(message = "Cart number cannot be blank")
    private String myCartNumber;

    @NotBlank(message = "Cart number cannot be blank")
    private String transferCartNumber;

    @NotNull(message = "Price cannot be null")
    @Min(value = 1, message = "Price must be at least 1")
    private BigDecimal balance;
}
