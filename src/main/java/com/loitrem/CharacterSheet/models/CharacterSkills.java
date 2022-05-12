package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class CharacterSkills implements Serializable {

    private static final long serialVersionUID = -3699777654897745089L;

    @Id //ID field
    @SequenceGenerator( //creates a sequence
            name = "CharacterSkills_sequence", //names the table in the database
            sequenceName = "CharacterSkills_sequence", // sequence name
            allocationSize = 1 // incriment by 1
    )
    @GeneratedValue(//tells what value to input
            strategy = GenerationType.SEQUENCE, // says to use a sequence instead of auto increment aka GenerationType.IDENTITY
            generator = "CharacterSkills_sequence" // use sequence name
    )
    Long csId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cId")
    Characters csCharacters;

    @NotNull
    int csAcrobaticsAbilityMod;

    @NotNull
    int csAcrobaticsRanks;

    @NotNull
    int csAcrobaticsMiscMod;

    @NotNull
    int csAppraiseAbilityMod;

    @NotNull
    int csAppraiseRanks;

    @NotNull
    int csAppraiseMiscMod;

    @NotNull
    int csBluffAbilityMod;

    @NotNull
    int csBluffRanks;

    @NotNull
    int csBluffMiscMod;

    @NotNull
    int csClimbAbilityMod;

    @NotNull
    int csClimbRanks;

    @NotNull
    int csClimbMiscMod;

    @NotNull
    int csCraftAbilityMod;

    @NotNull
    int csCraftRanks;

    @NotNull
    int csCraftMiscMod;

    @NotNull
    int csDiplomacyAbilityMod;

    @NotNull
    int csDiplomacyRanks;

    @NotNull
    int csDiplomacyMiscMod;

    @NotNull
    int csDisableDeviceAbilityMod;

    @NotNull
    int csDisableDeviceRanks;

    @NotNull
    int csDisableDeviceMiscMod;

    @NotNull
    int csDisguiseAbilityMod;

    @NotNull
    int csDisguiseRanks;

    @NotNull
    int csDisguiseMiscMod;

    @NotNull
    int csEscapeArtistAbilityMod;

    @NotNull
    int csEscapeArtistRanks;

    @NotNull
    int csEscapeArtistMiscMod;

    @NotNull
    int csFlyAbilityMod;

    @NotNull
    int csFlyRanks;

    @NotNull
    int csFlyMiscMod;

    @NotNull
    int csHandleAnimalAbilityMod;

    @NotNull
    int csHandleAnimalRanks;

    @NotNull
    int csHandleAnimalMiscMod;

    @NotNull
    int csHealAbilityMod;

    @NotNull
    int csHealRanks;

    @NotNull
    int csHealMiscMod;

    @NotNull
    int csIntimidateAbilityMod;

    @NotNull
    int csIntimidateRanks;

    @NotNull
    int csIntimidateMiscMod;

    @NotNull
    int csKnowledgeArcanaAbilityMod;

    @NotNull
    int csKnowledgeArcanaRanks;

    @NotNull
    int csKnowledgeArcanaMiscMod;

    @NotNull
    int csKnowledgeDungeoneeringAbilityMod;

    @NotNull
    int csKnowledgeDungeoneeringRanks;

    @NotNull
    int csKnowledgeDungeoneeringMiscMod;

    @NotNull
    int csKnowledgeEngineeringAbilityMod;

    @NotNull
    int csKnowledgeEngineeringRanks;

    @NotNull
    int csKnowledgeEngineeringMiscMod;

    @NotNull
    int csKnowledgeGeographyAbilityMod;

    @NotNull
    int csKnowledgeGeographyRanks;

    @NotNull
    int csKnowledgeGeographyMiscMod;

    @NotNull
    int csKnowledgeHistoryAbilityMod;

    @NotNull
    int csKnowledgeHistoryRanks;

    @NotNull
    int csKnowledgeHistoryMiscMod;

    @NotNull
    int csKnowledgeLocalAbilityMod;

    @NotNull
    int csKnowledgeLocalRanks;

    @NotNull
    int csKnowledgeLocalMiscMod;

    @NotNull
    int csKnowledgeNatureAbilityMod;

    @NotNull
    int csKnowledgeNatureRanks;

    @NotNull
    int csKnowledgeNatureMiscMod;

    @NotNull
    int csKnowledgeNobilityAbilityMod;

    @NotNull
    int csKnowledgeNobilityRanks;

    @NotNull
    int csKnowledgeNobilityMiscMod;

    @NotNull
    int csKnowledgePlanesAbilityMod;

    @NotNull
    int csKnowledgePlanesRanks;

    @NotNull
    int csKnowledgePlanesMiscMod;

    @NotNull
    int csKnowledgeReligionAbilityMod;

    @NotNull
    int csKnowledgeReligionRanks;

    @NotNull
    int csKnowledgeReligionMiscMod;

    @NotNull
    int csLinguisticsAbilityMod;

    @NotNull
    int csLinguisticsRanks;

    @NotNull
    int csLinguisticsMiscMod;

    @NotNull
    int csPerceptionAbilityMod;

    @NotNull
    int csPerceptionRanks;

    @NotNull
    int csPerceptionMiscMod;

    @NotNull
    int csPerformAbilityMod;

    @NotNull
    int csPerformRanks;

    @NotNull
    int csPerformMiscMod;

    @NotNull
    int csProfessionAbilityMod;

    @NotNull
    int csProfessionRanks;

    @NotNull
    int csProfessionMiscMod;

    @NotNull
    int csRideAbilityMod;

    @NotNull
    int csRideRanks;

    @NotNull
    int csRideMiscMod;

    @NotNull
    int csSenseMotiveAbilityMod;

    @NotNull
    int csSenseMotiveRanks;

    @NotNull
    int csSenseMotiveMiscMod;

    @NotNull
    int csSleightOfHandAbilityMod;

    @NotNull
    int csSleightOfHandRanks;

    @NotNull
    int csSleightOfHandMiscMod;

    @NotNull
    int csSpellcraftAbilityMod;

    @NotNull
    int csSpellcraftRanks;

    @NotNull
    int csSpellcraftMiscMod;

    @NotNull
    int csStealthAbilityMod;

    @NotNull
    int csStealthRanks;

    @NotNull
    int csStealthMiscMod;

    @NotNull
    int csSurvivalAbilityMod;

    @NotNull
    int csSurvivalRanks;

    @NotNull
    int csSurvivalMiscMod;

    @NotNull
    int csSwimAbilityMod;

    @NotNull
    int csSwimRanks;

    @NotNull
    int csSwimMiscMod;

    @NotNull
    int csUseMagicDeviceAbilityMod;

    @NotNull
    int csUseMagicDeviceRanks;

    @NotNull
    int csUseMagicDeviceMiscMod;
}
