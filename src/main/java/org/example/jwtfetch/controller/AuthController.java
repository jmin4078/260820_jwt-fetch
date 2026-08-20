package org.example.jwtfetch.controller;

import lombok.RequiredArgsConstructor;
import org.example.jwtfetch.dto.LoginForm;
import org.example.jwtfetch.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AuthController {
    private final UserAccountService userAccountService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm dto) {
        String token = userAccountService.login(dto.username(), dto.password());
        return ResponseEntity.ok()
                .body(token);
    }
}
