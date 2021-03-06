package com.loitrem.CharacterSheet.controllers;

import com.loitrem.CharacterSheet.models.Players;
import com.loitrem.CharacterSheet.services.CharacterService;
import com.loitrem.CharacterSheet.services.GamesService;
import com.loitrem.CharacterSheet.services.PlayersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("player")
public class PlayersController {

    CharacterService characterService;
    GamesService gamesService;
    PlayersService playersService;

    //constructor
    @Autowired
    public PlayersController(CharacterService characterService, GamesService gamesService, PlayersService playersService) {
        this.characterService = characterService;
        this.gamesService = gamesService;
        this.playersService = playersService;
    }

    //Model attribute for players
    @ModelAttribute("players")
    public Players initPlayers(){ return new Players(); }

    //Displays home page for players (logged in)
    @GetMapping("/home")
    public String home(){ return "home"; }

    //Shows list of all players
    @GetMapping("/show")
    public String showPlayers(Model mPlayers){
        List<Players> p = playersService.findAllPlayers();
        mPlayers.addAttribute("players", p);

        return "showplayers";
    }

    //Search players by name - returns list like search
    @PostMapping("/playerbyname")
    public String findPlayerByName(Model mPlayers, @RequestParam("name") String name){
        List<Players> p = playersService.findPlayerByName(name);
        mPlayers.addAttribute("players", p);

        return "playersbyname";
    }

    //Search players by name - returns exact match
    @PostMapping("/playerbypusername")
    public String findByPUsername(Model mPlayers, @RequestParam("name") String name){
        Players p = playersService.findByPUsername(name);
        mPlayers.addAttribute("players", p);

        return "playersbyname";
    }

}
