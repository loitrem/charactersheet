package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class Characters implements Serializable {

    private static final long serialVersionUID = -3829796007095099036L;

    @Id //ID field
    @SequenceGenerator( //creates a sequence
            name = "Characters_sequence", //names the table in the database
            sequenceName = "Characters_sequence", // sequence name
            allocationSize = 1 // incriment by 1
    )
    @GeneratedValue(//tells what value to input
            strategy = GenerationType.SEQUENCE, // says to use a sequence instead of auto increment aka GenerationType.IDENTITY
            generator = "Characters_sequence" // use sequence name
    )
    Long cId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pId")
    Players cPlayer;

    String cCharacterName;
    String cAlignment;
    int cLevel;
    String cDeity;
    String cRace;
    String cSize;
    String cGender;
    int cAge;
    int cHeight;
    int cWeight;
    String cHairColor;
    String cEyeColor;
    int cStr;
    int cDex;
    int cCon;
    int cInt;
    int cWis;
    int cCha;
    int cHp;
    int cSpeed;
    int cInitMiscModifier;
    int cFort;
    int cReflex;
    int cWill;
    int cAttackBonus;
    String cClass;
    int cAC;
    int cTouchAC;
    int cFlatFootedAC;
    int cSpellResist;

    @ToString.Exclude
    @OneToMany(mappedBy = "wCharacters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<CharacterWeapons> cWeapon;

    @ToString.Exclude
    @OneToOne(mappedBy = "csCharacters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    CharacterSkills cSkills;

    int cSpellsKnows0;
    int cSpellsKnows1;
    int cSpellsKnows2;
    int cSpellsKnows3;
    int cSpellsKnows4;
    int cSpellsKnows5;
    int cSpellsKnows6;
    int cSpellsKnows7;
    int cSpellsKnows8;
    int cSpellsKnows9;

    int cSpellSave0;
    int cSpellSave1;
    int cSpellSave2;
    int cSpellSave3;
    int cSpellSave4;
    int cSpellSave5;
    int cSpellSave6;
    int cSpellSave7;
    int cSpellSave8;
    int cSpellSave9;

    int cSpellsPerDay0;
    int cSpellsPerDay1;
    int cSpellsPerDay2;
    int cSpellsPerDay3;
    int cSpellsPerDay4;
    int cSpellsPerDay5;
    int cSpellsPerDay6;
    int cSpellsPerDay7;
    int cSpellsPerDay8;
    int cSpellsPerDay9;

    int cBonusSpells1;
    int cBonusSpells2;
    int cBonusSpells3;
    int cBonusSpells4;
    int cBonusSpells5;
    int cBonusSpells6;
    int cBonusSpells7;
    int cBonusSpells8;
    int cBonusSpells9;

    @ToString.Exclude
    @OneToMany(mappedBy = "cspCharacters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<CharacterSpells> cSpells;

    @ToString.Exclude
    @OneToMany(mappedBy = "lCharacters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<CharacterLanguages> cLanguages;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Games_Id")
    Games cGames;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Characters that = (Characters) o;
        return cId != null && Objects.equals(cId, that.cId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
