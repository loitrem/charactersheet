package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.CharacterWeapons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharacterWeaponsRepo extends JpaRepository<CharacterWeapons, Long> {
}
