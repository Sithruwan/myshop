package com.sith.ecom.myshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "user")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "user_id", nullable = false, length = 80)
    private String userId;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "is_acount_non_expired", columnDefinition = "TINYINT")
    private   boolean isAcountNonExpired;
    @Column(name = "is_account_non_locked", columnDefinition = "TINYINT")
    private   boolean isAccountNonLocked;
    @Column(name = "is_credentials_non_expired", columnDefinition = "TINYINT")
    private   boolean isCredentialsNonExpired;
    @Column(name = "is_enabled", columnDefinition = "TINYINT")
    private   boolean isEnabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserRoleHasUser> userRoleHasUser;
}
