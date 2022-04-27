package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface iPlayersRepo extends JpaRepository<Players, Long> {

    Players findByeId(Long id);

    @Query("SELECT e FROM Players e WHERE e.pPlayerName LIKE %:name%")
    Players findByPlayerName(@Param("name") String name);
}
