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

    //add new character step 1
    @Transactional
    public void addCharacter(Characters c){ iCharactersRepo.save(c); }

    //add new character step 2
    @Transactional
    public void addCharacterSetp2(Long id, Characters updateCharacter){
        Characters c = findById(id);
        c.setCStr(updateCharacter.getCStr());
        c.setCDex(updateCharacter.getCDex());
        c.setCCon(updateCharacter.getCCon());
        c.setCInt(updateCharacter.getCInt());
        c.setCWis(updateCharacter.getCWis());
        c.setCCha(updateCharacter.getCCha());

        iCharactersRepo.save(c);
    }
}
