package com.loitrem.CharacterSheet.services;

import com.loitrem.CharacterSheet.dao.ICharacterSkillsRepo;
import com.loitrem.CharacterSheet.models.CharacterSkills;
import com.loitrem.CharacterSheet.models.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addClassSkills(Long id){
        //find characters info
        Characters c =  characterService.findById(id);

        //create new characterSkills
        CharacterSkills cs = new CharacterSkills();


        //set found character in skills
        cs.setCsCharacters(c);

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

}
