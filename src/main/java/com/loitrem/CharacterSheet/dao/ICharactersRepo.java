package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharactersRepo extends JpaRepository<Characters, Long> {

    Characters findByeId(Long id);

}
