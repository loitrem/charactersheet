package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
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

    int csAcrobaticsAbilityMod;
    int csAcrobaticsRanks;
    int csAcrobaticsMiscMod;
    int csAppraiseAbilityMod;
    int csAppraiseRanks;
    int csAppraiseMiscMod;
    int csBluffAbilityMod;
    int csBluffRanks;
    int csBluffMiscMod;
    int csClimbAbilityMod;
    int csClimbRanks;
    int csClimbMiscMod;
    int csCraftAbilityMod;
    int csCraftRanks;
    int csCraftMiscMod;
    int csDiplomacyAbilityMod;
    int csDiplomacyRanks;
    int csDiplomacyMiscMod;
    int csDisableDeviceAbilityMod;
    int csDisableDeviceRanks;
    int csDisableDeviceMiscMod;
    int csDisguiseAbilityMod;
    int csDisguiseRanks;
    int csDisguiseMiscMod;
    int csEscapeArtistAbilityMod;
    int csEscapeArtistRanks;
    int csEscapeArtistMiscMod;
    int csFlyAbilityMod;
    int csFlyRanks;
    int csFlyMiscMod;
    int csHandleAnimalAbilityMod;
    int csHandleAnimalRanks;
    int csHandleAnimalMiscMod;
    int csHealAbilityMod;
    int csHealRanks;
    int csHealMiscMod;
    int csIntimidateAbilityMod;
    int csIntimidateRanks;
    int csIntimidateMiscMod;
    int csKnowledgeArcanaAbilityMod;
    int csKnowledgeArcanaRanks;
    int csKnowledgeArcanaMiscMod;
    int csKnowledgeDungeoneeringAbilityMod;
    int csKnowledgeDungeoneeringRanks;
    int csKnowledgeDungeoneeringMiscMod;
    int csKnowledgeEngineeringAbilityMod;
    int csKnowledgeEngineeringRanks;
    int csKnowledgeEngineeringMiscMod;
    int csKnowledgeGeographyAbilityMod;
    int csKnowledgeGeographyRanks;
    int csKnowledgeGeographyMiscMod;
    int csKnowledgeHistoryAbilityMod;
    int csKnowledgeHistoryRanks;
    int csKnowledgeHistoryMiscMod;
    int csKnowledgeLocalAbilityMod;
    int csKnowledgeLocalRanks;
    int csKnowledgeLocalMiscMod;
    int csKnowledgeNatureAbilityMod;
    int csKnowledgeNatureRanks;
    int csKnowledgeNatureMiscMod;
    int csKnowledgeNobilityAbilityMod;
    int csKnowledgeNobilityRanks;
    int csKnowledgeNobilityMiscMod;
    int csKnowledgePlanesAbilityMod;
    int csKnowledgePlanesRanks;
    int csKnowledgePlanesMiscMod;
    int csKnowledgeReligionAbilityMod;
    int csKnowledgeReligionRanks;
    int csKnowledgeReligionMiscMod;
    int csLinguisticsAbilityMod;
    int csLinguisticsRanks;
    int csLinguisticsMiscMod;
    int csPerceptionAbilityMod;
    int csPerceptionRanks;
    int csPerceptionMiscMod;
    int csPerformAbilityMod;
    int csPerformRanks;
    int csPerformMiscMod;
    int csProfessionAbilityMod;
    int csProfessionRanks;
    int csProfessionMiscMod;
    int csRideAbilityMod;
    int csRideRanks;
    int csRideMiscMod;
    int csSenseMotiveAbilityMod;
    int csSenseMotiveRanks;
    int csSenseMotiveMiscMod;
    int csSleightOfHandAbilityMod;
    int csSleightOfHandRanks;
    int csSleightOfHandMiscMod;
    int csSpellcraftAbilityMod;
    int csSpellcraftRanks;
    int csSpellcraftMiscMod;
    int csStealthAbilityMod;
    int csStealthRanks;
    int csStealthMiscMod;
    int csSurvivalAbilityMod;
    int csSurvivalRanks;
    int csSurvivalMiscMod;
    int csSwimAbilityMod;
    int csSwimRanks;
    int csSwimMiscMod;
    int csUseMagicDeviceAbilityMod;
    int csUseMagicDeviceRanks;
    int csUseMagicDeviceMiscMod;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CharacterSkills that = (CharacterSkills) o;
        return csId != null && Objects.equals(csId, that.csId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
