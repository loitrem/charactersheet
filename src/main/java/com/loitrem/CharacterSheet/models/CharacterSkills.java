package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class CharacterSkills implements Serializable {

    private static final long serialVersionUID = -3699777654897745089L;

    @Id //ID field
    @Column(name = "Character Skills Id")
    Long csId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Characters_Id")
    Characters csCharacters;

    @NotBlank
    int csAcrobaticsAbilityMod;

    @NotBlank
    int csAcrobaticsRanks;

    @NotBlank
    int csAcrobaticsMiscMod;

    @NotBlank
    int csAppraiseAbilityMod;

    @NotBlank
    int csAppraiseRanks;

    @NotBlank
    int csAppraiseMiscMod;

    @NotBlank
    int csBluffAbilityMod;

    @NotBlank
    int csBluffRanks;

    @NotBlank
    int csBluffMiscMod;

    @NotBlank
    int csClimbAbilityMod;

    @NotBlank
    int csClimbRanks;

    @NotBlank
    int csClimbMiscMod;

    @NotBlank
    int csCraftAbilityMod;

    @NotBlank
    int csCraftRanks;

    @NotBlank
    int csCraftMiscMod;

    @NotBlank
    int csDiplomacyAbilityMod;

    @NotBlank
    int csDiplomacyRanks;

    @NotBlank
    int csDiplomacyMiscMod;

    @NotBlank
    int csDisableDeviceAbilityMod;

    @NotBlank
    int csDisableDeviceRanks;

    @NotBlank
    int csDisableDeviceMiscMod;

    @NotBlank
    int csDisguiseAbilityMod;

    @NotBlank
    int csDisguiseRanks;

    @NotBlank
    int csDisguiseMiscMod;

    @NotBlank
    int csEscapeArtistAbilityMod;

    @NotBlank
    int csEscapeArtistRanks;

    @NotBlank
    int csEscapeArtistMiscMod;

    @NotBlank
    int csFlyAbilityMod;

    @NotBlank
    int csFlyRanks;

    @NotBlank
    int csFlyMiscMod;

    @NotBlank
    int csHandleAnimalAbilityMod;

    @NotBlank
    int csHandleAnimalRanks;

    @NotBlank
    int csHandleAnimalMiscMod;

    @NotBlank
    int csHealAbilityMod;

    @NotBlank
    int csHealRanks;

    @NotBlank
    int csHealMiscMod;

    @NotBlank
    int csIntimidateAbilityMod;

    @NotBlank
    int csIntimidateRanks;

    @NotBlank
    int csIntimidateMiscMod;

    @NotBlank
    int csKnowledgeArcanaAbilityMod;

    @NotBlank
    int csKnowledgeArcanaRanks;

    @NotBlank
    int csKnowledgeArcanaMiscMod;

    @NotBlank
    int csKnowledgeDungeoneeringAbilityMod;

    @NotBlank
    int csKnowledgeDungeoneeringRanks;

    @NotBlank
    int csKnowledgeDungeoneeringMiscMod;

    @NotBlank
    int csKnowledgeEngineeringAbilityMod;

    @NotBlank
    int csKnowledgeEngineeringRanks;

    @NotBlank
    int csKnowledgeEngineeringMiscMod;

    @NotBlank
    int csKnowledgeGeographyAbilityMod;

    @NotBlank
    int csKnowledgeGeographyRanks;

    @NotBlank
    int csKnowledgeGeographyMiscMod;

    @NotBlank
    int csKnowledgeHistoryAbilityMod;

    @NotBlank
    int csKnowledgeHistoryRanks;

    @NotBlank
    int csKnowledgeHistoryMiscMod;

    @NotBlank
    int csKnowledgeLocalAbilityMod;

    @NotBlank
    int csKnowledgeLocalRanks;

    @NotBlank
    int csKnowledgeLocalMiscMod;

    @NotBlank
    int csKnowledgeNatureAbilityMod;

    @NotBlank
    int csKnowledgeNatureRanks;

    @NotBlank
    int csKnowledgeNatureMiscMod;

    @NotBlank
    int csKnowledgeNobilityAbilityMod;

    @NotBlank
    int csKnowledgeNobilityRanks;

    @NotBlank
    int csKnowledgeNobilityMiscMod;

    @NotBlank
    int csKnowledgePlanesAbilityMod;

    @NotBlank
    int csKnowledgePlanesRanks;

    @NotBlank
    int csKnowledgePlanesMiscMod;

    @NotBlank
    int csKnowledgeReligionAbilityMod;

    @NotBlank
    int csKnowledgeReligionRanks;

    @NotBlank
    int csKnowledgeReligionMiscMod;

    @NotBlank
    int csLinguisticsAbilityMod;

    @NotBlank
    int csLinguisticsRanks;

    @NotBlank
    int csLinguisticsMiscMod;

    @NotBlank
    int csPerceptionAbilityMod;

    @NotBlank
    int csPerceptionRanks;

    @NotBlank
    int csPerceptionMiscMod;

    @NotBlank
    int csPerformAbilityMod;

    @NotBlank
    int csPerformRanks;

    @NotBlank
    int csPerformMiscMod;

    @NotBlank
    int csProfessionAbilityMod;

    @NotBlank
    int csProfessionRanks;

    @NotBlank
    int csProfessionMiscMod;

    @NotBlank
    int csRideAbilityMod;

    @NotBlank
    int csRideRanks;

    @NotBlank
    int csRideMiscMod;

    @NotBlank
    int csSenseMotiveAbilityMod;

    @NotBlank
    int csSenseMotiveRanks;

    @NotBlank
    int csSenseMotiveMiscMod;

    @NotBlank
    int csSleightOfHandAbilityMod;

    @NotBlank
    int csSleightOfHandRanks;

    @NotBlank
    int csSleightOfHandMiscMod;

    @NotBlank
    int csSpellcraftAbilityMod;

    @NotBlank
    int csSpellcraftRanks;

    @NotBlank
    int csSpellcraftMiscMod;

    @NotBlank
    int csStealthAbilityMod;

    @NotBlank
    int csStealthRanks;

    @NotBlank
    int csStealthMiscMod;

    @NotBlank
    int csSurvivalAbilityMod;

    @NotBlank
    int csSurvivalRanks;

    @NotBlank
    int csSurvivalMiscMod;

    @NotBlank
    int csSwimAbilityMod;

    @NotBlank
    int csSwimRanks;

    @NotBlank
    int csSwimMiscMod;

    @NotBlank
    int csUseMagicDeviceAbilityMod;

    @NotBlank
    int csUseMagicDeviceRanks;

    @NotBlank
    int csUseMagicDeviceMiscMod;

    public CharacterSkills(Long csId, Characters csCharacters, int csAcrobaticsAbilityMod, int csAcrobaticsRanks, int csAcrobaticsMiscMod, int csAppraiseAbilityMod, int csAppraiseRanks,
                           int csAppraiseMiscMod, int csBluffAbilityMod, int csBluffRanks, int csBluffMiscMod, int csClimbAbilityMod, int csClimbRanks, int csClimbMiscMod, int csCraftAbilityMod,
                           int csCraftRanks, int csCraftMiscMod, int csDiplomacyAbilityMod, int csDiplomacyRanks, int csDiplomacyMiscMod, int csDisableDeviceAbilityMod, int csDisableDeviceRanks,
                           int csDisableDeviceMiscMod, int csDisguiseAbilityMod, int csDisguiseRanks, int csDisguiseMiscMod, int csEscapeArtistAbilityMod, int csEscapeArtistRanks,
                           int csEscapeArtistMiscMod, int csFlyAbilityMod, int csFlyRanks, int csFlyMiscMod, int csHandleAnimalAbilityMod, int csHandleAnimalRanks, int csHandleAnimalMiscMod,
                           int csHealAbilityMod, int csHealRanks, int csHealMiscMod, int csIntimidateAbilityMod, int csIntimidateRanks, int csIntimidateMiscMod, int csKnowledgeArcanaAbilityMod,
                           int csKnowledgeArcanaRanks, int csKnowledgeArcanaMiscMod, int csKnowledgeDungeoneeringAbilityMod, int csKnowledgeDungeoneeringRanks, int csKnowledgeDungeoneeringMiscMod,
                           int csKnowledgeEngineeringAbilityMod, int csKnowledgeEngineeringRanks, int csKnowledgeEngineeringMiscMod, int csKnowledgeGeographyAbilityMod, int csKnowledgeGeographyRanks,
                           int csKnowledgeGeographyMiscMod, int csKnowledgeHistoryAbilityMod, int csKnowledgeHistoryRanks, int csKnowledgeHistoryMiscMod, int csKnowledgeLocalAbilityMod,
                           int csKnowledgeLocalRanks, int csKnowledgeLocalMiscMod, int csKnowledgeNatureAbilityMod, int csKnowledgeNatureRanks, int csKnowledgeNatureMiscMod,
                           int csKnowledgeNobilityAbilityMod, int csKnowledgeNobilityRanks, int csKnowledgeNobilityMiscMod, int csKnowledgePlanesAbilityMod, int csKnowledgePlanesRanks,
                           int csKnowledgePlanesMiscMod, int csKnowledgeReligionAbilityMod, int csKnowledgeReligionRanks, int csKnowledgeReligionMiscMod, int csLinguisticsAbilityMod,
                           int csLinguisticsRanks, int csLinguisticsMiscMod, int csPerceptionAbilityMod, int csPerceptionRanks, int csPerceptionMiscMod, int csPerformAbilityMod,
                           int csPerformRanks, int csPerformMiscMod, int csProfessionAbilityMod, int csProfessionRanks, int csProfessionMiscMod, int csRideAbilityMod, int csRideRanks,
                           int csRideMiscMod, int csSenseMotiveAbilityMod, int csSenseMotiveRanks, int csSenseMotiveMiscMod, int csSleightOfHandAbilityMod, int csSleightOfHandRanks,
                           int csSleightOfHandMiscMod, int csSpellcraftAbilityMod, int csSpellcraftRanks, int csSpellcraftMiscMod, int csStealthAbilityMod, int csStealthRanks,
                           int csStealthMiscMod, int csSurvivalAbilityMod, int csSurvivalRanks, int csSurvivalMiscMod, int csSwimAbilityMod, int csSwimRanks, int csSwimMiscMod,
                           int csUseMagicDeviceAbilityMod, int csUseMagicDeviceRanks, int csUseMagicDeviceMiscMod) {
        this.csId = csId;
        this.csCharacters = csCharacters;
        this.csAcrobaticsAbilityMod = csAcrobaticsAbilityMod;
        this.csAcrobaticsRanks = csAcrobaticsRanks;
        this.csAcrobaticsMiscMod = csAcrobaticsMiscMod;
        this.csAppraiseAbilityMod = csAppraiseAbilityMod;
        this.csAppraiseRanks = csAppraiseRanks;
        this.csAppraiseMiscMod = csAppraiseMiscMod;
        this.csBluffAbilityMod = csBluffAbilityMod;
        this.csBluffRanks = csBluffRanks;
        this.csBluffMiscMod = csBluffMiscMod;
        this.csClimbAbilityMod = csClimbAbilityMod;
        this.csClimbRanks = csClimbRanks;
        this.csClimbMiscMod = csClimbMiscMod;
        this.csCraftAbilityMod = csCraftAbilityMod;
        this.csCraftRanks = csCraftRanks;
        this.csCraftMiscMod = csCraftMiscMod;
        this.csDiplomacyAbilityMod = csDiplomacyAbilityMod;
        this.csDiplomacyRanks = csDiplomacyRanks;
        this.csDiplomacyMiscMod = csDiplomacyMiscMod;
        this.csDisableDeviceAbilityMod = csDisableDeviceAbilityMod;
        this.csDisableDeviceRanks = csDisableDeviceRanks;
        this.csDisableDeviceMiscMod = csDisableDeviceMiscMod;
        this.csDisguiseAbilityMod = csDisguiseAbilityMod;
        this.csDisguiseRanks = csDisguiseRanks;
        this.csDisguiseMiscMod = csDisguiseMiscMod;
        this.csEscapeArtistAbilityMod = csEscapeArtistAbilityMod;
        this.csEscapeArtistRanks = csEscapeArtistRanks;
        this.csEscapeArtistMiscMod = csEscapeArtistMiscMod;
        this.csFlyAbilityMod = csFlyAbilityMod;
        this.csFlyRanks = csFlyRanks;
        this.csFlyMiscMod = csFlyMiscMod;
        this.csHandleAnimalAbilityMod = csHandleAnimalAbilityMod;
        this.csHandleAnimalRanks = csHandleAnimalRanks;
        this.csHandleAnimalMiscMod = csHandleAnimalMiscMod;
        this.csHealAbilityMod = csHealAbilityMod;
        this.csHealRanks = csHealRanks;
        this.csHealMiscMod = csHealMiscMod;
        this.csIntimidateAbilityMod = csIntimidateAbilityMod;
        this.csIntimidateRanks = csIntimidateRanks;
        this.csIntimidateMiscMod = csIntimidateMiscMod;
        this.csKnowledgeArcanaAbilityMod = csKnowledgeArcanaAbilityMod;
        this.csKnowledgeArcanaRanks = csKnowledgeArcanaRanks;
        this.csKnowledgeArcanaMiscMod = csKnowledgeArcanaMiscMod;
        this.csKnowledgeDungeoneeringAbilityMod = csKnowledgeDungeoneeringAbilityMod;
        this.csKnowledgeDungeoneeringRanks = csKnowledgeDungeoneeringRanks;
        this.csKnowledgeDungeoneeringMiscMod = csKnowledgeDungeoneeringMiscMod;
        this.csKnowledgeEngineeringAbilityMod = csKnowledgeEngineeringAbilityMod;
        this.csKnowledgeEngineeringRanks = csKnowledgeEngineeringRanks;
        this.csKnowledgeEngineeringMiscMod = csKnowledgeEngineeringMiscMod;
        this.csKnowledgeGeographyAbilityMod = csKnowledgeGeographyAbilityMod;
        this.csKnowledgeGeographyRanks = csKnowledgeGeographyRanks;
        this.csKnowledgeGeographyMiscMod = csKnowledgeGeographyMiscMod;
        this.csKnowledgeHistoryAbilityMod = csKnowledgeHistoryAbilityMod;
        this.csKnowledgeHistoryRanks = csKnowledgeHistoryRanks;
        this.csKnowledgeHistoryMiscMod = csKnowledgeHistoryMiscMod;
        this.csKnowledgeLocalAbilityMod = csKnowledgeLocalAbilityMod;
        this.csKnowledgeLocalRanks = csKnowledgeLocalRanks;
        this.csKnowledgeLocalMiscMod = csKnowledgeLocalMiscMod;
        this.csKnowledgeNatureAbilityMod = csKnowledgeNatureAbilityMod;
        this.csKnowledgeNatureRanks = csKnowledgeNatureRanks;
        this.csKnowledgeNatureMiscMod = csKnowledgeNatureMiscMod;
        this.csKnowledgeNobilityAbilityMod = csKnowledgeNobilityAbilityMod;
        this.csKnowledgeNobilityRanks = csKnowledgeNobilityRanks;
        this.csKnowledgeNobilityMiscMod = csKnowledgeNobilityMiscMod;
        this.csKnowledgePlanesAbilityMod = csKnowledgePlanesAbilityMod;
        this.csKnowledgePlanesRanks = csKnowledgePlanesRanks;
        this.csKnowledgePlanesMiscMod = csKnowledgePlanesMiscMod;
        this.csKnowledgeReligionAbilityMod = csKnowledgeReligionAbilityMod;
        this.csKnowledgeReligionRanks = csKnowledgeReligionRanks;
        this.csKnowledgeReligionMiscMod = csKnowledgeReligionMiscMod;
        this.csLinguisticsAbilityMod = csLinguisticsAbilityMod;
        this.csLinguisticsRanks = csLinguisticsRanks;
        this.csLinguisticsMiscMod = csLinguisticsMiscMod;
        this.csPerceptionAbilityMod = csPerceptionAbilityMod;
        this.csPerceptionRanks = csPerceptionRanks;
        this.csPerceptionMiscMod = csPerceptionMiscMod;
        this.csPerformAbilityMod = csPerformAbilityMod;
        this.csPerformRanks = csPerformRanks;
        this.csPerformMiscMod = csPerformMiscMod;
        this.csProfessionAbilityMod = csProfessionAbilityMod;
        this.csProfessionRanks = csProfessionRanks;
        this.csProfessionMiscMod = csProfessionMiscMod;
        this.csRideAbilityMod = csRideAbilityMod;
        this.csRideRanks = csRideRanks;
        this.csRideMiscMod = csRideMiscMod;
        this.csSenseMotiveAbilityMod = csSenseMotiveAbilityMod;
        this.csSenseMotiveRanks = csSenseMotiveRanks;
        this.csSenseMotiveMiscMod = csSenseMotiveMiscMod;
        this.csSleightOfHandAbilityMod = csSleightOfHandAbilityMod;
        this.csSleightOfHandRanks = csSleightOfHandRanks;
        this.csSleightOfHandMiscMod = csSleightOfHandMiscMod;
        this.csSpellcraftAbilityMod = csSpellcraftAbilityMod;
        this.csSpellcraftRanks = csSpellcraftRanks;
        this.csSpellcraftMiscMod = csSpellcraftMiscMod;
        this.csStealthAbilityMod = csStealthAbilityMod;
        this.csStealthRanks = csStealthRanks;
        this.csStealthMiscMod = csStealthMiscMod;
        this.csSurvivalAbilityMod = csSurvivalAbilityMod;
        this.csSurvivalRanks = csSurvivalRanks;
        this.csSurvivalMiscMod = csSurvivalMiscMod;
        this.csSwimAbilityMod = csSwimAbilityMod;
        this.csSwimRanks = csSwimRanks;
        this.csSwimMiscMod = csSwimMiscMod;
        this.csUseMagicDeviceAbilityMod = csUseMagicDeviceAbilityMod;
        this.csUseMagicDeviceRanks = csUseMagicDeviceRanks;
        this.csUseMagicDeviceMiscMod = csUseMagicDeviceMiscMod;
    }
}
