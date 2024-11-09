package com.example.msaccount.account;

import com.example.msaccount.enums.AccountStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCartCreateRequest {
    @NotBlank(message = "Cart number is required")
    @Size(max = 16, message = "Cart number cannot exceed 16 characters")
    private String cartNumber;

    @NotNull(message = "Balance is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Balance cannot be negative")
    private BigDecimal balance;

    @NotNull(message = "Account status is required")
    private AccountStatus accountStatus;

    @Size(max = 4, message = "PIN cannot exceed 4 characters")
    private String pin;

    @Size(max = 3, message = "CVV cannot exceed 3 characters")
    private String cvv;

}
