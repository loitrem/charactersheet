package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.CharacterWeapons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICharacterWeaponsRepo extends JpaRepository<CharacterWeapons, Long> {

    List<CharacterWeapons> findBywId(long id);

}
