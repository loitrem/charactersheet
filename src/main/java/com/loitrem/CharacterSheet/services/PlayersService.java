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

    //find player by id
    public Players findByeId(Long id){
        if (id!=0){
            return iPlayersRepo.findBypId(id);
        }
        return null;
    }

    //Find players by name
    public List<Players> findPlayerByName(String name) {
        if (name != null) {
            return iPlayersRepo.findByPlayerName(name);
        }
        return null;
    }

    //Find players by name
    public Players findByPUsername(String name) {
        if (name != null) {
            return iPlayersRepo.findPlayerByPUsername(name);
        }
        return null;
    }

}
