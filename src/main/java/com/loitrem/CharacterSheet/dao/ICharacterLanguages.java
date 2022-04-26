package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.CharacterLanguages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterLanguages extends JpaRepository<CharacterLanguages, Long> {
}
