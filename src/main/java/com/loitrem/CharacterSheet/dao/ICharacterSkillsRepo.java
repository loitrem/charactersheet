package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.CharacterSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICharacterSkillsRepo extends JpaRepository<CharacterSkills, Long> {

    List<CharacterSkills> findBycskId(long id);
}
