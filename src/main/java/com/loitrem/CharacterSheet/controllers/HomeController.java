package com.loitrem.CharacterSheet.controllers;

import com.loitrem.CharacterSheet.dao.IPlayersRepo;
import com.loitrem.CharacterSheet.models.Players;
import com.loitrem.CharacterSheet.security.AppSecurityConfiguration;
import com.loitrem.CharacterSheet.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class HomeController {

    PlayersService playersService;
    GamesService gamesService;
    CharacterLanguagesService characterLanguagesService;
    CharacterSkillsService characterSkillsService;
    CharacterSpellsService characterSpellsService;
    CharacterWeaponsService characterWeaponsService;
    CharacterService characterService;
    IPlayersRepo iPlayersRepo;

    public HomeController(PlayersService playersService, GamesService gamesService, CharacterLanguagesService characterLanguagesService,
                          CharacterSkillsService characterSkillsService, CharacterSpellsService characterSpellsService,
                          CharacterWeaponsService characterWeaponsService, CharacterService characterService, IPlayersRepo iPlayersRepo) {
        this.playersService = playersService;
        this.gamesService = gamesService;
        this.characterLanguagesService = characterLanguagesService;
        this.characterSkillsService = characterSkillsService;
        this.characterSpellsService = characterSpellsService;
        this.characterWeaponsService = characterWeaponsService;
        this.characterService = characterService;
        this.iPlayersRepo = iPlayersRepo;
    }

    @Autowired


    //display index page
    @GetMapping({"/","index"})
    public String index(){
        return "index";
    }

    //display login page
    @GetMapping({"/login"})
    public String login(){
        return "login";
    }

    //displays register player page
    @GetMapping("/register")
    public String register(){ return "register"; }

    // register employee as a user
    @PostMapping("/register")
    public String authenticate(@ModelAttribute("players") @Valid Players player, BindingResult result, Model mError, Model mPlayer,
                               @RequestParam("id") Long pId, @RequestParam("password") String pass, @RequestParam("password2") String pass2,@RequestParam("username") String username,
                               @RequestParam("playername") String playerName){

        //cehcks if password and re-entered password match
        if (!pass.equals(pass2)){
            log.warn(player.getPPassword());
            log.warn(pass2);
            mError.addAttribute("error", "Passwords do not match");
            List<Players> p = playersService.findAllPlayers();
            mPlayer.addAttribute("player", p);

            return "register";
        }

        //checks if username is already taken
        if (playersService.findByPUsername(player.getPUserName())!=null){
            log.warn(player.getPUserName());
            mError.addAttribute("error", "Username is already taken");
            List<Players> p = playersService.findAllPlayers();
            mPlayer.addAttribute("players", p);

            return "register";
        }

        // sets user object into employee object, sets usertype object of user into user object, and sends user obj and employee obj to user service to save
        Players p = new Players();
        p.setPUserType("ROLE_USER");
        p.setPUserName(username);
        p.setPPlayerName(playerName);

        //Encode password for security
        p.setPPassword(AppSecurityConfiguration.getPasswordEncoder().encode(pass));

        return "login";
    }

}
