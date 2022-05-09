package com.loitrem.CharacterSheet.services;

import com.loitrem.CharacterSheet.dao.ICharacterLanguagesRepo;
import com.loitrem.CharacterSheet.models.CharacterLanguages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterLanguagesService {

    ICharacterLanguagesRepo iCharacterLanguagesRepo;

    @Autowired
    public CharacterLanguagesService(ICharacterLanguagesRepo iCharacterLanguagesRepo) {this.iCharacterLanguagesRepo = iCharacterLanguagesRepo; }

    //find all languages for the character by character id
    public List<CharacterLanguages> findById(Long id) {
        if (id != 0)
        {
            return iCharacterLanguagesRepo.findByclId(id);
        }
        return null;
    }
}
