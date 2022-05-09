package com.loitrem.CharacterSheet.services;

import com.loitrem.CharacterSheet.dao.ICharacterSkillsRepo;
import com.loitrem.CharacterSheet.models.CharacterSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterSkillsService {

    ICharacterSkillsRepo iCharacterSkillsRepo;

    @Autowired
    public CharacterSkillsService(ICharacterSkillsRepo iCharacterSkillsRepo) { this.iCharacterSkillsRepo = iCharacterSkillsRepo; }

    public List<CharacterSkills> findById(Long id) {
        if (id != 0)
        {
            return iCharacterSkillsRepo.findBycskId(id);
        }
        return null;
    }

}
