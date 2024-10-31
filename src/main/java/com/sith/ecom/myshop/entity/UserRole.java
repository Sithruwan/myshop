package com.sith.ecom.myshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "user_role")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserRole {

    @Id
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "userRole", fetch = FetchType.LAZY)
    private Set<UserRoleHasUser> userRoleHasUser;
}
