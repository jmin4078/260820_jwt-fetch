package org.example.jwtfetch.service;

import lombok.RequiredArgsConstructor;
import org.example.jwtfetch.domain.entity.UserAccount;
import org.example.jwtfetch.domain.repository.UserAccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(UserAccount entity) {
        String encoded = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(
                encoded
        );
        userAccountRepository.save(entity); // DB에는 암호화된 형태로 저장
    }
}