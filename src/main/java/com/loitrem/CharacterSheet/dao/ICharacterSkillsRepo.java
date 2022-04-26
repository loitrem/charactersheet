package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.CharacterSkills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharacterSkillsRepo extends JpaRepository<CharacterSkills, Long> {
}
