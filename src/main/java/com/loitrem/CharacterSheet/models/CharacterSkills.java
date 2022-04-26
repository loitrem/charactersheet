package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class CharacterSkills {

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


}
