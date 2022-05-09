package com.loitrem.CharacterSheet.services;

import com.loitrem.CharacterSheet.dao.ICharacterSpellsRepo;
import com.loitrem.CharacterSheet.models.CharacterSpells;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterSpellsService {

    ICharacterSpellsRepo iCharacterSpellsRepo;

    @Autowired
    public CharacterSpellsService(ICharacterSpellsRepo iCharacterSpellsRepo) { this.iCharacterSpellsRepo = iCharacterSpellsRepo; }

    public List<CharacterSpells> findById(Long id) {
        if (id != 0)
        {
            return iCharacterSpellsRepo.findBycspId(id);
        }
        return null;
    }
}
