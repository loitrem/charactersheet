package com.loitrem.CharacterSheet.security;


import com.loitrem.CharacterSheet.models.Players;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AppUserPrincipal implements UserDetails {

    //establish student object and auth group
    private Players players;

    //constructor
    public AppUserPrincipal(Players players) {
        this.players = players;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //if null return empty
        if(null == players){
            return Collections.emptySet();
        }
        //establish new set of simple granted authorities
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        //add each auth group for the user
        grantedAuthorities.add(new SimpleGrantedAuthority(players.getPUsername()));

        return grantedAuthorities;

    }

    @Override
    public String getPassword() {
        return this.players.getPPassword();
    }

    @Override
    public String getUsername() {
        return this.players.getPUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
