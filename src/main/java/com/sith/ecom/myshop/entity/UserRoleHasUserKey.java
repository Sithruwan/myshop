package com.sith.ecom.myshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class UserRoleHasUserKey implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String userRole;
}
