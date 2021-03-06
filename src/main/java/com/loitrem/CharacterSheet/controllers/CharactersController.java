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
import java.util.Objects;

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
        CharacterSkills csk = c.getCsId();
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
        CharacterSkills csk = c.getCsId();
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
    public String createCharacter(@ModelAttribute("characters") @Valid Characters characters, Model mCharacter,@RequestParam("characterclass") String cClass,
                                  @RequestParam("charactername") String cName, @RequestParam("characteralignment") String cAlignment, @RequestParam("characterlevel") int cLevel,
                                  @RequestParam("characterdeity") String cDeity, @RequestParam("characterrace") String cRace, @RequestParam("charactergender") String cGender, @RequestParam("characterage") int cAge,
                                  @RequestParam("characterheight") int cHeight, @RequestParam("characterweight") int cWeight, @RequestParam("characterhair") String cHair,
                                  @RequestParam("charactereye") String cEye){


            //add collected info into model
            Characters c = new Characters();

            c.setCClass(cClass);
            c.setCCharacterName(cName);
            c.setCAlignment(cAlignment);
            c.setCLevel(cLevel);
            c.setCDeity(cDeity);
            c.setCRace(cRace);
            c.setCGender(cGender);
            c.setCAge(cAge);
            c.setCHeight(cHeight);
            c.setCWeight(cWeight);
            c.setCHairColor(cHair);
            c.setCEyeColor(cEye);

            //save to model
            characterService.addCharacter(c);

            c.setCId(c.getCId());

            mCharacter.addAttribute("characters", c);

            if (Objects.equals(c.getCRace(), "Half Elf")){

                return "createcharacterhalfelf";
            }

            return "createcharacter2";
    }

    @PostMapping("/createcharacterhalfelf")
    public String createCharacterRacialSp(@ModelAttribute("characters") @Valid Characters characters, Model mCharacter, @RequestParam("racial") String cRacial, @RequestParam("cId") Long cId) {

        Characters c = characterService.findById(cId);

        c.setCHalfElfRacial(cRacial);

        characterService.saveCharacter(c);

        mCharacter.addAttribute("characters", c);

        return "createcharacter2";

    }

    @PostMapping("/createcharacter3")
    public String createCharacter2(@ModelAttribute("characters") @Valid Characters characters, Model mCharacter, @RequestParam("str") int cStr, @RequestParam("dex") int cDex,
                                   @RequestParam("con") int cCon, @RequestParam("int") int cInt, @RequestParam("wis") int cWis, @RequestParam("cha") int cCha, @RequestParam("cId") Long cId){

        //find character by id
        Characters c = characterService.findById(cId);

        //set ability modifiers
        c.setCStrMod(characterService.setAbilityModifier(cStr));
        c.setCDexMod(characterService.setAbilityModifier(cDex));
        c.setCConMod(characterService.setAbilityModifier(cCon));
        c.setCIntMod(characterService.setAbilityModifier(cInt));
        c.setCWisMod(characterService.setAbilityModifier(cWis));
        c.setCChaMod(characterService.setAbilityModifier(cCha));

        //add collected info into character
        c.setCStr(cStr);
        c.setCDex(cDex);
        c.setCCon(cCon);
        c.setCInt(cInt);
        c.setCWis(cWis);
        c.setCCha(cCha);

        //save to model
        characterService.saveCharacter(c);

        //pull current info of character
        Characters character = characterService.findById(cId);

        //add class skills for character skills
        characterSkillsService.addClassSkills(c.getCId());

        //add base and total skill points
        characterSkillsService.addBaseSkillPoints(cId);
        characterSkillsService.addTotalSkillPoints(cId);

        //add character to model
        mCharacter.addAttribute("characters", character);

        return "createcharacter3";

    }

}
