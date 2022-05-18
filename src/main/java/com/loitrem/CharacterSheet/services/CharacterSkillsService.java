package com.loitrem.CharacterSheet.services;

import com.loitrem.CharacterSheet.dao.ICharacterSkillsRepo;
import com.loitrem.CharacterSheet.models.CharacterSkills;
import com.loitrem.CharacterSheet.models.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CharacterSkillsService {

    ICharacterSkillsRepo iCharacterSkillsRepo;
    CharacterService characterService;

    @Autowired
    public CharacterSkillsService(ICharacterSkillsRepo iCharacterSkillsRepo, CharacterService characterService) {
        this.iCharacterSkillsRepo = iCharacterSkillsRepo;
        this.characterService = characterService;
    }

    public List<CharacterSkills> findById(Long id) {
        if (id != 0)
        {
            return iCharacterSkillsRepo.findBycsId(id);
        }
        return null;
    }

    @Transactional
    public void addClassSkills(Long id){
        //find characters info
        Characters c =  characterService.findById(id);

        //create new characterSkills
        CharacterSkills cs = new CharacterSkills();

        c.setCsId(cs);

        switch (c.getCClass()){
            case "Barbarian":
                cs.setCsAcrobaticsClass(true);
                cs.setCsClimbClass(true);
                cs.setCsCraftClass(true);
                cs.setCsHandleAnimalClass(true);
                cs.setCsIntimidateClass(true);
                cs.setCsKnowledgeNatureClass(true);
                cs.setCsPerceptionClass(true);
                cs.setCsRideClass(true);
                cs.setCsSurvivalClass(true);
                cs.setCsSwimClass(true);

                break;

            case "Bard":
                cs.setCsAcrobaticsClass(true);
                cs.setCsAppraiseClass(true);
                cs.setCsBluffClass(true);
                cs.setCsClimbClass(true);
                cs.setCsCraftClass(true);
                cs.setCsDiplomacyClass(true);
                cs.setCsDisguiseClass(true);
                cs.setCsEscapeArtistClass(true);
                cs.setCsIntimidateClass(true);
                cs.setCsKnowledgeArcanaClass(true);
                cs.setCsKnowledgeDungeoneeringClass(true);
                cs.setCsKnowledgeEngineeringClass(true);
                cs.setCsKnowledgeGeographyClass(true);
                cs.setCsKnowledgeHistoryClass(true);
                cs.setCsKnowledgeLocalClass(true);
                cs.setCsKnowledgeNatureClass(true);
                cs.setCsKnowledgeNobilityClass(true);
                cs.setCsKnowledgePlanesClass(true);
                cs.setCsKnowledgeReligionClass(true);
                cs.setCsLinguisticsClass(true);
                cs.setCsPerceptionClass(true);
                cs.setCsPerformClass(true);
                cs.setCsProfessionClass(true);
                cs.setCsSenseMotiveClass(true);
                cs.setCsSleightOfHandClass(true);
                cs.setCsSpellcraftClass(true);
                cs.setCsStealthClass(true);
                cs.setCsUseMagicDeviceClass(true);

                break;

            case "Cleric":
                cs.setCsAppraiseClass(true);
                cs.setCsCraftClass(true);
                cs.setCsDiplomacyClass(true);
                cs.setCsHealClass(true);
                cs.setCsKnowledgeArcanaClass(true);
                cs.setCsKnowledgeHistoryClass(true);
                cs.setCsKnowledgeNobilityClass(true);
                cs.setCsKnowledgePlanesClass(true);
                cs.setCsKnowledgeReligionClass(true);
                cs.setCsLinguisticsClass(true);
                cs.setCsProfessionClass(true);
                cs.setCsSenseMotiveClass(true);
                cs.setCsSpellcraftClass(true);

                break;

            case "Druid":
                cs.setCsClimbClass(true);
                cs.setCsCraftClass(true);
                cs.setCsFlyClass(true);
                cs.setCsHandleAnimalClass(true);
                cs.setCsHealClass(true);
                cs.setCsKnowledgeGeographyClass(true);
                cs.setCsKnowledgeNatureClass(true);
                cs.setCsPerceptionClass(true);
                cs.setCsProfessionClass(true);
                cs.setCsRideClass(true);
                cs.setCsSpellcraftClass(true);
                cs.setCsSurvivalClass(true);
                cs.setCsSwimClass(true);

                break;

            case "Fighter":
                cs.setCsClimbClass(true);
                cs.setCsCraftClass(true);
                cs.setCsHandleAnimalClass(true);
                cs.setCsIntimidateClass(true);
                cs.setCsKnowledgeDungeoneeringClass(true);
                cs.setCsKnowledgeEngineeringClass(true);
                cs.setCsProfessionClass(true);
                cs.setCsRideClass(true);
                cs.setCsSurvivalClass(true);
                cs.setCsSwimClass(true);

                break;

            case "Monk":
                cs.setCsAcrobaticsClass(true);
                cs.setCsClimbClass(true);
                cs.setCsCraftClass(true);
                cs.setCsEscapeArtistClass(true);
                cs.setCsIntimidateClass(true);
                cs.setCsKnowledgeHistoryClass(true);
                cs.setCsKnowledgeReligionClass(true);
                cs.setCsPerceptionClass(true);
                cs.setCsPerformClass(true);
                cs.setCsProfessionClass(true);
                cs.setCsRideClass(true);
                cs.setCsSenseMotiveClass(true);
                cs.setCsStealthClass(true);
                cs.setCsSwimClass(true);

                break;

            case "Paladin":
                cs.setCsCraftClass(true);
                cs.setCsDiplomacyClass(true);
                cs.setCsHandleAnimalClass(true);
                cs.setCsHealClass(true);
                cs.setCsKnowledgeNobilityClass(true);
                cs.setCsKnowledgeReligionClass(true);
                cs.setCsProfessionClass(true);
                cs.setCsRideClass(true);
                cs.setCsSenseMotiveClass(true);
                cs.setCsSpellcraftClass(true);

                break;

            case "Ranger":
                cs.setCsClimbClass(true);
                cs.setCsCraftClass(true);
                cs.setCsHandleAnimalClass(true);
                cs.setCsHealClass(true);
                cs.setCsIntimidateClass(true);
                cs.setCsKnowledgeDungeoneeringClass(true);
                cs.setCsKnowledgeGeographyClass(true);
                cs.setCsKnowledgeNatureClass(true);
                cs.setCsPerceptionClass(true);
                cs.setCsProfessionClass(true);
                cs.setCsRideClass(true);
                cs.setCsSpellcraftClass(true);
                cs.setCsStealthClass(true);
                cs.setCsSurvivalClass(true);
                cs.setCsSwimClass(true);

                break;

            case "Rogue":
                cs.setCsAcrobaticsClass(true);
                cs.setCsAppraiseClass(true);
                cs.setCsBluffClass(true);
                cs.setCsClimbClass(true);
                cs.setCsCraftClass(true);
                cs.setCsDiplomacyClass(true);
                cs.setCsDisableDeviceClass(true);
                cs.setCsDisguiseClass(true);
                cs.setCsEscapeArtistClass(true);
                cs.setCsIntimidateClass(true);
                cs.setCsKnowledgeDungeoneeringClass(true);
                cs.setCsKnowledgeLocalClass(true);
                cs.setCsLinguisticsClass(true);
                cs.setCsPerceptionClass(true);
                cs.setCsPerformClass(true);
                cs.setCsProfessionClass(true);
                cs.setCsSenseMotiveClass(true);
                cs.setCsSleightOfHandClass(true);
                cs.setCsStealthClass(true);
                cs.setCsSwimClass(true);
                cs.setCsUseMagicDeviceClass(true);

                break;

            case "Sorcerer":
                cs.setCsAppraiseClass(true);
                cs.setCsBluffClass(true);
                cs.setCsCraftClass(true);
                cs.setCsFlyClass(true);
                cs.setCsIntimidateClass(true);
                cs.setCsKnowledgeArcanaClass(true);
                cs.setCsProfessionClass(true);
                cs.setCsSpellcraftClass(true);
                cs.setCsUseMagicDeviceClass(true);

                break;

            case "Wizard":
                cs.setCsAppraiseClass(true);
                cs.setCsCraftClass(true);
                cs.setCsFlyClass(true);
                cs.setCsDisguiseClass(true);
                cs.setCsEscapeArtistClass(true);
                cs.setCsIntimidateClass(true);
                cs.setCsKnowledgeArcanaClass(true);
                cs.setCsKnowledgeDungeoneeringClass(true);
                cs.setCsKnowledgeEngineeringClass(true);
                cs.setCsKnowledgeGeographyClass(true);
                cs.setCsKnowledgeHistoryClass(true);
                cs.setCsKnowledgeLocalClass(true);
                cs.setCsKnowledgeNatureClass(true);
                cs.setCsKnowledgeNobilityClass(true);
                cs.setCsKnowledgePlanesClass(true);
                cs.setCsKnowledgeReligionClass(true);
                cs.setCsLinguisticsClass(true);
                cs.setCsProfessionClass(true);
                cs.setCsSpellcraftClass(true);

                break;
        }

        iCharacterSkillsRepo.save(cs);

    }

    @Transactional
    public void addBaseSkillPoints(Long id) {

        //pull the objects for characters and skills
        Characters c = characterService.findById(id);
        CharacterSkills cs = iCharacterSkillsRepo.getById(c.getCsId().getCsId());

        int baseSkillPoints = 0;


        // set base skill points based on class and level
        switch (c.getCClass()) {
            case "Barbarian":
                baseSkillPoints = c.getCLevel() + (c.getCIntMod() + 4);
                c.setCTotalSp(baseSkillPoints);
                characterService.saveCharacter(c);

                break;

            case "Bard":
                baseSkillPoints = c.getCLevel() + (c.getCIntMod() + 6);
                c.setCTotalSp(baseSkillPoints);
                characterService.saveCharacter(c);

                break;

            case "Cleric":
                baseSkillPoints = c.getCLevel() + (c.getCIntMod() + 2);
                c.setCTotalSp(baseSkillPoints);
                characterService.saveCharacter(c);

                break;

            case "Druid":
                baseSkillPoints = c.getCLevel() + (c.getCIntMod() + 4);
                c.setCTotalSp(baseSkillPoints);
                characterService.saveCharacter(c);

                break;

            case "Fighter":
                baseSkillPoints = c.getCLevel() + (c.getCIntMod() + 2);
                c.setCTotalSp(baseSkillPoints);
                characterService.saveCharacter(c);

                break;

            case "Monk":
                baseSkillPoints = c.getCLevel() + (c.getCIntMod() + 4);
                c.setCTotalSp(baseSkillPoints);
                characterService.saveCharacter(c);

                break;

            case "Paladin":
                baseSkillPoints = c.getCLevel() + (c.getCIntMod() + 2);
                c.setCTotalSp(baseSkillPoints);
                characterService.saveCharacter(c);

                break;

            case "Ranger":
                baseSkillPoints = c.getCLevel() + (c.getCIntMod() + 6);
                c.setCTotalSp(baseSkillPoints);
                characterService.saveCharacter(c);

                break;

            case "Rogue":
                baseSkillPoints = c.getCLevel() + (c.getCIntMod() + 8);
                c.setCTotalSp(baseSkillPoints);
                characterService.saveCharacter(c);

                break;

            case "Sorcerer":
                baseSkillPoints = c.getCLevel() + (c.getCIntMod() + 2);
                c.setCTotalSp(baseSkillPoints);
                characterService.saveCharacter(c);

                break;

            case "Wizard":
                baseSkillPoints = c.getCLevel() + (c.getCIntMod() + 2);
                c.setCTotalSp(baseSkillPoints);
                characterService.saveCharacter(c);

                break;
        }
    }

    @Transactional
    public void addTotalSkillPoints(Long id){

        //pull the objects for characters and skills
        Characters c = characterService.findById(id);

        int currentTotal = c.getCTotalSp();

        // set racial skill points
        switch (c.getCRace()){
            case "Half Elf":
                if (Objects.equals(c.getCHalfElfRacial(), "sp")){
                    c.setCRacialSp(c.getCLevel());
                    c.setCTotalSp(currentTotal + c.getCRacialSp());

                    characterService.saveCharacter(c);

                    break;
                }


                c.setCRacialSp(0);
                c.setCTotalSp(currentTotal + c.getCRacialSp());

                characterService.saveCharacter(c);

                break;

            case "Human":
                c.setCRacialSp(c.getCLevel());
                c.setCTotalSp(c.getCTotalSp() + c.getCLevel() + c.getCRacialSp());

                characterService.saveCharacter(c);

                break;

        }

    }

}
