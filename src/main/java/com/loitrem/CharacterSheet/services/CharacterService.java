package com.loitrem.CharacterSheet.services;

import com.loitrem.CharacterSheet.dao.ICharactersRepo;
import com.loitrem.CharacterSheet.models.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CharacterService {

    ICharactersRepo iCharactersRepo;

    @Autowired
    public CharacterService(ICharactersRepo iCharactersRepo){
        this.iCharactersRepo = iCharactersRepo;
    }

    //find all characters
    public List<Characters> findAllCharacters() {return iCharactersRepo.findAll(); }

    //find character by id
    public Characters findById(Long id) {
        if (id != 0 ) {
            return iCharactersRepo.findBycId(id);
        }
        else {
            return null;
        }
    }

    //find characters by character name
    public List<Characters> findByCharacterName(String name) {
        if (name != null){
            return iCharactersRepo.findByCharacterName(name);
        }
        else {
            return null;
        }
    }

    //find characters by play name
    public List<Characters> findByPlayerName(String name) {
        if (name != null){
            return iCharactersRepo.findByPlayerName(name);
        }
        else {
            return null;
        }
    }

    //find characters by level
    public List<Characters> findByCharacterLevel(Long level) {
        if (level != null){
            return iCharactersRepo.findByCharacterLevel(level);
        }
        else {
            return null;
        }
    }

}
