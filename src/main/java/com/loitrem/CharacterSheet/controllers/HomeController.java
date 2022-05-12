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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public String register(Model mPlayers){
        Players p = new Players();
        mPlayers.addAttribute("players", p);
        return "register"; }

    // register employee as a user
    @PostMapping("/register")
    public String authenticate(@ModelAttribute("players") @Valid Players player, BindingResult result, Model mError, Model mPlayer,
                               @RequestParam("password") String pass, @RequestParam("password2") String pass2, @RequestParam("username") String username,
                               @RequestParam("playername") String playerName){


        String regexUsername = "^[A-Za-z0-9]\\w{5,}$";
        String regexPassword = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";

        Pattern pPassword = Pattern.compile(regexUsername);
        Pattern pUsername = Pattern.compile(regexPassword);

        Matcher uMatch = pPassword.matcher(username);
        Matcher pMatch = pUsername.matcher(pass);

        //checks if password and re-entered password match
        if (!pass.equals(pass2)){
            log.warn(player.getPPassword());
            log.warn(pass2);
            mError.addAttribute("error", "Passwords do not match");
            List<Players> p = playersService.findAllPlayers();
            player.setPPlayerName(playerName);
            player.setPPassword(pass);
            player.setPUsername(username);
            mPlayer.addAttribute("player", p);

            return "register";
        }

        //checks if username is already taken
        if (playersService.findByPUsername(player.getPUsername())!=null){
            log.warn(player.getPUsername());
            mError.addAttribute("error", "Username is already taken");
            List<Players> p = playersService.findAllPlayers();

            player.setPPlayerName(playerName);
            player.setPPassword(pass);
            player.setPUsername(username);
            mPlayer.addAttribute("player", p);

            return "register";
        }

        //checks if username conforms to regex
        if (!uMatch.matches()){
            mError.addAttribute("error", "Username must contain at least 6 characters" + "<br/>" +
                    "Must only contain letters or numbers");
            Players p = new Players();
            player.setPPlayerName(playerName);
            player.setPPassword(pass);
            player.setPUsername(username);
            mPlayer.addAttribute("player", p);

            return "register";
        }

        //checks if password conforms to regex
        if (!pMatch.matches()){
            mError.addAttribute("error", "Password must contain at least 8 characters" +"<br/>" +
                    "At least 1 upper case letter" +"<br/>" +
                    "At least 1 lower case letter" +"<br/>" +
                    "At least 1 number" +"<br/>" +
                    "At least 1 special character");
            Players p = new Players();
            player.setPPlayerName(playerName);
            player.setPPassword(pass);
            player.setPUsername(username);
            mPlayer.addAttribute("player", p);

            return "register";
        }

        // sets user object into employee object, sets usertype object of user into user object, and sends user obj and employee obj to user service to save
        Players p = new Players();
        p.setPUserType("ROLE_USER");
        p.setPUsername(username);
        p.setPPlayerName(playerName);

        //Encode password for security
        p.setPPassword(AppSecurityConfiguration.getPasswordEncoder().encode(pass));

        iPlayersRepo.save(p);

        return "login";
    }

}
