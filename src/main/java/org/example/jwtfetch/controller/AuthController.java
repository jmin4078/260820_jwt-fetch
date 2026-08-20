package org.example.jwtfetch.controller;

import lombok.RequiredArgsConstructor;
import org.example.jwtfetch.auth.AuthCookieUtil;
import org.example.jwtfetch.dto.LoginForm;
import org.example.jwtfetch.service.UserAccountService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AuthController {
    private final UserAccountService userAccountService;
    private final AuthCookieUtil authCookieUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Validated @RequestBody LoginForm dto) {
        String token = userAccountService.login(dto.username(), dto.password());
        ResponseCookie accessTokenCookie = authCookieUtil.createAccessTokenCookie(token);
        return ResponseEntity.ok()
//                .header("Set-Cookie", accessTokenCookie.toString())
                .header(HttpHeaders.SET_COOKIE,
                        accessTokenCookie.toString())
                .body(token);
    }

    @DeleteMapping("/logout")
    public ResponseEntity<Void> logout() {
        ResponseCookie accessTokenCookie = authCookieUtil.deleteAccessTokenCookie();
        return ResponseEntity.noContent()
                .header(HttpHeaders.SET_COOKIE,
                        accessTokenCookie.toString())
                .build();
    }
}