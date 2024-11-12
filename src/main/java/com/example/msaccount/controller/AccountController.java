package com.example.msaccount.controller;

import com.example.msaccount.Service.AccountService;
import com.example.msaccount.Service.AuthService;
import com.example.msaccount.Service.UserService;
import com.example.msaccount.account.AccountDto;
import com.example.msaccount.account.AccountResponse;
import com.example.msaccount.account.AccountTransferRequest;
import com.example.msaccount.account.AccountUpdateRequest;
import com.example.msaccount.client.AuthFeignClient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;
    private final UserService userService;
    private final AuthService authService;


    @PostMapping("/create")
    public ResponseEntity<AccountDto> create(@RequestHeader("Authorization") String auth) {
        String finCode = authService.getFin(auth);
        return ResponseEntity.ok(service.createAccount(finCode));
    }

    @GetMapping("/")
    public ResponseEntity<List<AccountResponse>> account(@RequestHeader("Authorization") String auth) {
        String finCode = authService.getFin(auth);
        return ResponseEntity.ok(service.getMyAccount(finCode));
    }

    @PatchMapping("/update")
    public void update(@RequestHeader("Authorization") String auth, @RequestBody AccountUpdateRequest request) {
        String finCode = authService.getFin(auth);
        service.updatePin(finCode, request.getCartNumber(), request.getOldPin(), request.getNewPin());
    }
}