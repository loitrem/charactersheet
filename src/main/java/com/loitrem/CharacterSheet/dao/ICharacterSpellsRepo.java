package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.CharacterSpells;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterSpellsRepo extends JpaRepository<CharacterSpells, Long> {
}
