package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.Characters;
import com.loitrem.CharacterSheet.models.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGamesRepo extends JpaRepository<Games, Long> {

    List<Games> findBygId(long id);

    @Query("SELECT g FROM Games g WHERE g.gGameCreator LIKE %:player%")
    List<Games> findByDM(@Param("player") Long pId);

    List<Characters> findCharactersByGame(Games game);

    List<Games> findGamesbyPlayer(Long id);

}
