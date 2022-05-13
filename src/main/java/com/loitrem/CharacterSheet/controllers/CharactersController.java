package com.loitrem.CharacterSheet.controllers;

import com.loitrem.CharacterSheet.models.*;
import com.loitrem.CharacterSheet.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("character")
public class CharactersController {

    PlayersService playersService;
    GamesService gamesService;
    CharacterLanguagesService characterLanguagesService;
    CharacterSkillsService  characterSkillsService;
    CharacterSpellsService  characterSpellsService;
    CharacterWeaponsService characterWeaponsService;
    CharacterService characterService;

    @Autowired
    public CharactersController(PlayersService playersService, GamesService gamesService, CharacterLanguagesService characterLanguagesService,
                                CharacterSkillsService characterSkillsService, CharacterSpellsService characterSpellsService,
                                CharacterWeaponsService characterWeaponsService, CharacterService  characterService) {

        this.playersService = playersService;
        this.gamesService = gamesService;
        this.characterLanguagesService = characterLanguagesService;
        this.characterSkillsService = characterSkillsService;
        this.characterSpellsService = characterSpellsService;
        this.characterWeaponsService = characterWeaponsService;
        this.characterService = characterService;
    }

    //Model attributes for characters
    @ModelAttribute("Characters")
    public Characters initCharacters(){ return new Characters(); }

    //Show all characters
    @GetMapping("/showallcharacters")
    public String showCharacters(Model model){
        List<Characters> c = characterService.findAllCharacters();
        model.addAttribute("Characters", c);
        return "showallcharacters";
    }

    //Show character by id
    @GetMapping("/characters/{cId}")
    public String characterById(Model mCharacter, Model mCharacterSkills, Model mCharacterSpells, Model mCharacterLanguages , Model mPlayer, Model mGames, @PathVariable("cId") Long id){
        Characters c = characterService.findById(id);
        List<CharacterLanguages> cl = c.getCLanguages();
        List<CharacterSpells> csp = c.getCSpells();
        List<CharacterSkills> csk = c.getCSkills();
        Players p = c.getCPlayer();
        Games g = c.getCGames();

        mCharacter.addAttribute("characters", c);
        mCharacterLanguages.addAttribute("characterLanguages", cl);
        mCharacterSkills.addAttribute("characterSkills", csk);
        mCharacterSpells.addAttribute("characterSpells", csp);
        mGames.addAttribute("games", g);
        mPlayer.addAttribute("player", p);

        return "characters";
    }

    //Show all games for a character
    @GetMapping("/characters/{gId}")
    public String charactergames(Model mCharacter, Model mCharacterSkills, Model mCharacterSpells, Model mCharacterLanguages , Model mPlayer, Model mGames, @PathVariable("gId") Long id){
        Characters c = characterService.findById(id);
        List<CharacterLanguages> cl = c.getCLanguages();
        List<CharacterSpells> csp = c.getCSpells();
        List<CharacterSkills> csk = c.getCSkills();
        Players p = c.getCPlayer();
        Games g = c.getCGames();

        mCharacter.addAttribute("characters", c);
        mCharacterLanguages.addAttribute("characterLanguages", cl);
        mCharacterSkills.addAttribute("characterSkills", csk);
        mCharacterSpells.addAttribute("characterSpells", csp);
        mGames.addAttribute("games", g);
        mPlayer.addAttribute("player", p);

        return "charactersgames";
    }

    //Search characters by name
    @PostMapping("/characternamesearch")
    public String characterNameSearch(Model mCharacter, @RequestParam("name") String name){
        List<Characters> c = characterService.findByCharacterName(name);

        mCharacter.addAttribute("characters", c);

        return "characterbyname";
    }

    //Search characters by level
    @PostMapping("/characterlevelsearch")
    public String characterLevelSearch(Model mCharacter, @RequestParam("name") String name){
        List<Characters> c = characterService.findByCharacterName(name);

        mCharacter.addAttribute("characters", c);

        return "characterbylevel";
    }

    //Search characters by game
    @PostMapping("/charactergamesearch")
    public String characterSearch(Model mCharacter, @RequestParam("name") String name){
        List<Characters> c = characterService.findByCharacterName(name);

        mCharacter.addAttribute("characters", c);

        return "characterbygame";
    }

    @GetMapping("/createcharacter")
    public String displayCreateCharacter(){ return "createcharacter"; }

    @PostMapping("/createcharacter2")
    public String createCharacter(@ModelAttribute("characters") @Valid Characters characters, Model mCharacter,@RequestParam("characterclass") String cClass, @RequestParam("charactername") String cName, @RequestParam("characteralignment") String cAlignment,
                                  @RequestParam("characterlevel") int cLevel, @RequestParam("characterdeity") String cDeity, @RequestParam("characterrace") String cRace,
                                  @RequestParam("characterage") int cAge, @RequestParam("characterheight") int cHeight, @RequestParam("characterweight") int cWeight,
                                  @RequestParam("characterhair") String cHair, @RequestParam("charactereye") String cEye){

        //add collected info into model
        Characters c = new Characters();
        c.setCClass(cClass);
        c.setCCharacterName(cName);
        c.setCAlignment(cAlignment);
        c.setCLevel(cLevel);
        c.setCDeity(cDeity);
        c.setCRace(cRace);
        c.setCAge(cAge);
        c.setCHeight(cHeight);
        c.setCWeight(cWeight);
        c.setCHairColor(cHair);
        c.setCEyeColor(cEye);

        //save to model
        characterService.addCharacter(c);

        c.setCId(c.getCId());

        mCharacter.addAttribute("characters", c);

        return "createcharacter2";

    }



}
