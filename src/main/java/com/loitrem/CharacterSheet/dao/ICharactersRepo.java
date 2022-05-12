package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICharactersRepo extends JpaRepository<Characters, Long> {

    Characters findBycId(Long id);

    @Query("SELECT e FROM Characters e WHERE e.cCharacterName LIKE %:name%")
    List<Characters> findByCharacterName(@Param("name") String name);

    @Query("SELECT e FROM Characters e WHERE e.cPlayerName LIKE %:name%")
    List<Characters> findByPlayerName(@Param("name") String name);

    @Query("SELECT e FROM Characters e WHERE e.cLevel = %:level%")
    List<Characters> findByCharacterLevel(@Param("level") Long level);

}
