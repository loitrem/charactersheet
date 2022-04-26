package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.CharacterSpells;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharacterSpellsRepo extends JpaRepository<CharacterSpells, Long> {
}
