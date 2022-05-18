package com.loitrem.CharacterSheet.services;

import com.loitrem.CharacterSheet.dao.ICharactersRepo;
import com.loitrem.CharacterSheet.models.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    //find characters by level
    public List<Characters> findByCharacterLevel(int level) {
        if (level != 0){
            return iCharactersRepo.findByCharacterLevel(level);
        }
        else {
            return null;
        }
    }

    //determine ability modifiers
    public int setAbilityModifier(int ability) {
        int mod;

        switch (ability){
            case 1:
                mod = -5;
                return mod;

            case 2: case 3:
                mod = -4;
                return mod;

            case 4: case 5:
                mod = -3;
                return mod;

            case 6: case 7:
                mod = -2;
                return mod;

            case 8: case 9:
                mod = -1;
                return mod;

            case 10: case 11:
                mod = 0;
                return mod;

            case 12: case 13:
                mod = 1;
                return mod;

            case 14: case 15:
                mod = 2;
                return mod;

            case 16: case 17:
                mod = 3;
                return mod;

            case 18: case 19:
                mod = 4;
                return mod;

            case 20: case 21:
                mod = 5;
                return mod;

            case 22: case 23:
                mod = 6;
                return mod;

            case 24: case 25:
                mod = 7;
                return mod;

            case 26: case 27:
                mod = 8;
                return mod;

            case 28: case 29:
                mod = 9;
                return mod;

            case 30: case 31:
                mod = 10;
                return mod;
        }

        return -6;
    }

    //add new character step 1
    @Transactional
    public void addCharacter(Characters c){ iCharactersRepo.save(c); }

    //save character
    @Transactional
    public void saveCharacter(Characters c){
        iCharactersRepo.save(c);
    }
}
