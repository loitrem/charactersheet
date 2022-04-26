package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.CharacterLanguages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharacterLanguages extends JpaRepository<CharacterLanguages, Long> {
}
