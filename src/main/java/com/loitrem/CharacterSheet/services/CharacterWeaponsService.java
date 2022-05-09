package com.loitrem.CharacterSheet.services;

import com.loitrem.CharacterSheet.dao.ICharacterWeaponsRepo;
import com.loitrem.CharacterSheet.dao.ICharacterWeaponsRepo;
import com.loitrem.CharacterSheet.models.CharacterWeapons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterWeaponsService {

    ICharacterWeaponsRepo iCharacterWeaponsRepo;

    @Autowired
    public CharacterWeaponsService(ICharacterWeaponsRepo iCharacterWeaponsRepo) { this.iCharacterWeaponsRepo = iCharacterWeaponsRepo; }

    public List<CharacterWeapons> findById(Long id) {
        if (id != 0)
        {
            return iCharacterWeaponsRepo.findBywId(id);
        }
        return null;
    }
}
