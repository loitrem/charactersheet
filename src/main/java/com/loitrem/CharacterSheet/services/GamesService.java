package com.loitrem.CharacterSheet.services;

import com.loitrem.CharacterSheet.dao.IGamesRepo;
import com.loitrem.CharacterSheet.dao.IPlayersRepo;
import com.loitrem.CharacterSheet.models.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {

    IGamesRepo iGamesRepo;
    IPlayersRepo iPlayersRepo;

    @Autowired
    public GamesService(IGamesRepo iGamesRepo, IPlayersRepo iPlayersRepo){
        this.iGamesRepo = iGamesRepo;
        this.iPlayersRepo = iPlayersRepo;
    }

    public List<Games> findAllGames(){ return iGamesRepo.findAll(); }

    public List<Games> findBygId(Long id){
        if(id !=0){
            return iGamesRepo.findBygId(id);
        }
    return null;
    }

}
