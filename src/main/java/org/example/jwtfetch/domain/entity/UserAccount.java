package org.example.jwtfetch.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "user_account")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserAccount extends BaseEntity {
    private String username;
    private String password;
}
