package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.CharacterLanguages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICharacterLanguagesRepo extends JpaRepository<CharacterLanguages, Long> {

    List<CharacterLanguages> findBylId(long id);

}
