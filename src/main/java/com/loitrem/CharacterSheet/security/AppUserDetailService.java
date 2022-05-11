package com.loitrem.CharacterSheet.security;


import com.loitrem.CharacterSheet.dao.IPlayersRepo;
import com.loitrem.CharacterSheet.models.Players;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailService implements UserDetailsService {

    //establish repos
    private final IPlayersRepo iPlayersRepo;

    //constructor
    @Autowired
    public AppUserDetailService(IPlayersRepo iPlayersRepo) {
        this.iPlayersRepo = iPlayersRepo;
    }

    //load by username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Players p = iPlayersRepo.findPlayerByPUsername(username);
        if(p==null)
            throw new UsernameNotFoundException("Cannot find Username: " + username);

        return new AppUserPrincipal(p);
    }
}