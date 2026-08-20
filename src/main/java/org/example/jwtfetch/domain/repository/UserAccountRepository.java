package org.example.jwtfetch.domain.repository;

import org.example.jwtfetch.domain.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}