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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cId")
    Characters csCharacters;
    int csSkillPoints;

    int csAcrobaticsAbilityMod;
    int csAcrobaticsRanks;
    int csAcrobaticsMiscMod;
    boolean csAcrobaticClass;

    int csAppraiseAbilityMod;
    int csAppraiseRanks;
    int csAppraiseMiscMod;
    boolean csAppraiseClass;

    int csBluffAbilityMod;
    int csBluffRanks;
    int csBluffMiscMod;
    boolean csBluffClass;

    int csClimbAbilityMod;
    int csClimbRanks;
    int csClimbMiscMod;
    boolean csClimbClass;

    int csCraftAbilityMod;
    int csCraftRanks;
    int csCraftMiscMod;
    boolean csCraftClass;

    int csDiplomacyAbilityMod;
    int csDiplomacyRanks;
    int csDiplomacyMiscMod;
    boolean csDiplomacyClass;

    int csDisableDeviceAbilityMod;
    int csDisableDeviceRanks;
    int csDisableDeviceMiscMod;
    boolean csDisableDeviceClass;

    int csDisguiseAbilityMod;
    int csDisguiseRanks;
    int csDisguiseMiscMod;
    boolean csDisguiseClass;

    int csEscapeArtistAbilityMod;
    int csEscapeArtistRanks;
    int csEscapeArtistMiscMod;
    boolean csEscapeArtistClass;

    int csFlyAbilityMod;
    int csFlyRanks;
    int csFlyMiscMod;
    boolean csFlyClass;

    int csHandleAnimalAbilityMod;
    int csHandleAnimalRanks;
    int csHandleAnimalMiscMod;
    boolean csHandleAnimalClass;

    int csHealAbilityMod;
    int csHealRanks;
    int csHealMiscMod;
    boolean csHealClass;

    int csIntimidateAbilityMod;
    int csIntimidateRanks;
    int csIntimidateMiscMod;
    boolean csIntimidateClass;

    int csKnowledgeArcanaAbilityMod;
    int csKnowledgeArcanaRanks;
    int csKnowledgeArcanaMiscMod;
    boolean csKnowledgeArcanaClass;

    int csKnowledgeDungeoneeringAbilityMod;
    int csKnowledgeDungeoneeringRanks;
    int csKnowledgeDungeoneeringMiscMod;
    boolean csKnowledgeDungeoneeringClass;


    int csKnowledgeEngineeringAbilityMod;
    int csKnowledgeEngineeringRanks;
    int csKnowledgeEngineeringMiscMod;
    boolean csKnowledgeEngineeringClass;

    int csKnowledgeGeographyAbilityMod;
    int csKnowledgeGeographyRanks;
    int csKnowledgeGeographyMiscMod;
    boolean csKnowledgeGeographyClass;

    int csKnowledgeHistoryAbilityMod;
    int csKnowledgeHistoryRanks;
    int csKnowledgeHistoryMiscMod;
    boolean csKnowledgeHistoryClass;

    int csKnowledgeLocalAbilityMod;
    int csKnowledgeLocalRanks;
    int csKnowledgeLocalMiscMod;
    boolean csKnowledgeLocalClass;

    int csKnowledgeNatureAbilityMod;
    int csKnowledgeNatureRanks;
    int csKnowledgeNatureMiscMod;
    boolean csKnowledgeNatureClass;

    int csKnowledgeNobilityAbilityMod;
    int csKnowledgeNobilityRanks;
    int csKnowledgeNobilityMiscMod;
    boolean csKnowledgeNobilityClass;

    int csKnowledgePlanesAbilityMod;
    int csKnowledgePlanesRanks;
    int csKnowledgePlanesMiscMod;
    boolean csKnowledgePlanesClass;

    int csKnowledgeReligionAbilityMod;
    int csKnowledgeReligionRanks;
    int csKnowledgeReligionMiscMod;
    boolean csKnowledgeReligionClass;

    int csLinguisticsAbilityMod;
    int csLinguisticsRanks;
    int csLinguisticsMiscMod;
    boolean csLinguisticsClass;

    int csPerceptionAbilityMod;
    int csPerceptionRanks;
    int csPerceptionMiscMod;
    boolean csPerceptionClass;

    int csPerformAbilityMod;
    int csPerformRanks;
    int csPerformMiscMod;
    boolean csPerformClass;

    int csProfessionAbilityMod;
    int csProfessionRanks;
    int csProfessionMiscMod;
    boolean csProfessionClass;

    int csRideAbilityMod;
    int csRideRanks;
    int csRideMiscMod;
    boolean csRideClass;

    int csSenseMotiveAbilityMod;
    int csSenseMotiveRanks;
    int csSenseMotiveMiscMod;
    boolean csSenseMotiveClass;

    int csSleightOfHandAbilityMod;
    int csSleightOfHandRanks;
    int csSleightOfHandMiscMod;
    boolean csSleightOfHandClass;

    int csSpellcraftAbilityMod;
    int csSpellcraftRanks;
    int csSpellcraftMiscMod;
    boolean csSpellcraftClass;

    int csStealthAbilityMod;
    int csStealthRanks;
    int csStealthMiscMod;
    boolean csStealthClass;

    int csSurvivalAbilityMod;
    int csSurvivalRanks;
    int csSurvivalMiscMod;
    boolean csSurvivalClass;

    int csSwimAbilityMod;
    int csSwimRanks;
    int csSwimMiscMod;
    boolean csSwimClass;

    int csUseMagicDeviceAbilityMod;
    int csUseMagicDeviceRanks;
    int csUseMagicDeviceMiscMod;
    boolean csUseMagicDeviceClass;

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
