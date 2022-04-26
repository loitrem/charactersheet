package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.Characters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharactersRepo extends JpaRepository<Characters, Long> {
}
