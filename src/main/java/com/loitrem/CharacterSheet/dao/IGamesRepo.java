package com.loitrem.CharacterSheet.dao;

import com.loitrem.CharacterSheet.models.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGamesRepo extends JpaRepository<Games, Long> {
}