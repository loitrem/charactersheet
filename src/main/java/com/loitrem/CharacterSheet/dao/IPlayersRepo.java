package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayersRepo extends JpaRepository<Players, Long> {

    Players findBypId(Long id);

    @Query("SELECT e FROM Players e WHERE e.pPlayerName LIKE %:name%")
    List<Players> findByPlayerName(@Param("name") String name);

    Players findPlayerByPUsername(String name);
}
