package com.example.msaccount.Service;

import com.example.msaccount.client.AuthFeignClient;
import com.example.msaccount.client.UserFeignClient;
import com.example.msaccount.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserFeignClient feignClient;

     public Optional<UserDto> getUser(String fin){
         return feignClient.getUserByFin(fin);
     }
}
