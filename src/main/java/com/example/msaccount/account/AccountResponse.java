package com.example.msaccount.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountResponse {
    private String cartNumber;
    private BigDecimal balance;
    private String accountStatus;
}
