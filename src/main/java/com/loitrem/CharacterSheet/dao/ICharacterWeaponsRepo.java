package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.CharacterWeapons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterWeaponsRepo extends JpaRepository<CharacterWeapons, Long> {
}
