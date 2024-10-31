package com.sith.ecom.myshop.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;



public class ApplicationUser implements UserDetails {

    private final Set<? extends GrantedAuthority> grantedAuthorities;
    private final String username;
    private final String password;
    private final boolean isAcountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;
    public ApplicationUser(Set<? extends GrantedAuthority> grantedAuthorities,
                           String username, String password, boolean isAcountNonExpired,
                           boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
        this.grantedAuthorities = grantedAuthorities;
        this.username = username;
        this.password = password;
        this.isAcountNonExpired = isAcountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAcountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
