package org.example.jwtfetch.service;

import lombok.RequiredArgsConstructor;
import org.example.jwtfetch.domain.entity.UserAccount;
import org.example.jwtfetch.domain.repository.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Transactional
    public void signUp(UserAccount entity) {

    }
}

