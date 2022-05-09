package com.loitrem.CharacterSheet.services;

import com.loitrem.CharacterSheet.dao.IPlayersRepo;
import com.loitrem.CharacterSheet.models.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersService {

    IPlayersRepo iPlayersRepo;

    @Autowired
    public PlayersService(IPlayersRepo iPlayersRepo){ this.iPlayersRepo = iPlayersRepo; }

    public List<Players> findAllPlayers(){ return iPlayersRepo.findAll(); }
    public Players findBygId(Long id){
        if(id !=0){
            return iPlayersRepo.findBypId(id);
        }
        return null;
    }
}
