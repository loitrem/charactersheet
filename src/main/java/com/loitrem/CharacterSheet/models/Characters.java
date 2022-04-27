package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class Characters implements Serializable {

    private static final long serialVersionUID = -3829796007095099036L;

    @Id //ID field
    @SequenceGenerator( //creates a sequence
            name = "Character_sequence", //names the table in the database
            sequenceName = "Character_sequence", // sequence name
            allocationSize = 1 // incriment by 1
    )
    @GeneratedValue(//tells what value to input
            strategy = GenerationType.SEQUENCE, // says to use a sequence instead of auto increment aka GenerationType.IDENTITY
            generator = "Character_sequence" // use sequence name
    )
    @Column(name = "Character Id")
    Long cId;

    @NonNull @NotBlank
    String cPlayerName;

    @NonNull @NotBlank
    String cCharacterName;

    @NonNull @NotBlank
    String cAlignment;

    @NotBlank
    int cLevel;

    String cDeity;

    @NonNull @NotBlank
    String cHomeland;

    @NonNull @NotBlank
    String cRace;

    @NonNull @NotBlank
    String cSize;

    @NonNull @NotBlank
    String cGender;

    String cHeight;

    int cWeight;

    String cHairColor;

    String cEyeColor;

    @NotBlank
    int cStr;

    @NotBlank
    int cDex;

    @NotBlank
    int cCon;

    @NotBlank
    int cWis;

    @NotBlank
    int cCha;

    @NotBlank
    int cHp;

    @NotBlank
    int cSpeed;

    int cInitMiscModifier;

    @NotBlank
    int cFort;

    @NotBlank
    int cReflex;

    @NotBlank
    int cWill;

    @NotBlank
    int cAttackBonus;

    @NonNull @NotBlank
    String cClass;

    @NotBlank
    int cAC;

    @NotBlank
    int cTouchAC;

    @NotBlank
    int cFlatFootedAC;

    @NotBlank
    int cSpellResist;

    @ToString.Exclude
    @OneToMany(mappedBy = "wCharacters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NonNull @NotBlank
    List<CharacterWeapons> cWeapon;

    @ToString.Exclude
    @OneToMany(mappedBy = "csCharacters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NonNull @NotBlank
    List<CharacterSkills> cSkills;

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
    @NonNull @NotBlank
    List<CharacterSpells> cSpells;

    @ToString.Exclude
    @OneToMany(mappedBy = "lCharacters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NonNull @NotBlank
    List<CharacterLanguages> cLanguages;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "CharacterGames",
        joinColumns = {@JoinColumn(name = "Character_Id", referencedColumnName = "cId", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "Games_Id", referencedColumnName = "gId", nullable = false, updatable = false)})
    List<Games> cGames;

    public Characters(Long cId, @NonNull String cPlayerName, @NonNull String cCharacterName, @NonNull String cAlignment, int cLevel, String cDeity, @NonNull String cHomeland, @NonNull String cRace,
                      @NonNull String cSize, @NonNull String cGender, String cHeight, int cWeight, String cHairColor, String cEyeColor, int cStr, int cDex, int cCon, int cWis, int cCha, int cHp,
                      int cSpeed, int cInitMiscModifier, int cFort, int cReflex, int cWill, int cAttackBonus, @NonNull String cClass, int cAC, int cTouchAC, int cFlatFootedAC, int cSpellResist,
                      @NonNull List<CharacterWeapons> cWeapon, @NonNull List<CharacterSkills> cSkills, int cSpellsKnows0, int cSpellsKnows1, int cSpellsKnows2, int cSpellsKnows3, int cSpellsKnows4,
                      int cSpellsKnows5, int cSpellsKnows6, int cSpellsKnows7, int cSpellsKnows8, int cSpellsKnows9, int cSpellSave0, int cSpellSave1, int cSpellSave2, int cSpellSave3, int cSpellSave4,
                      int cSpellSave5, int cSpellSave6, int cSpellSave7, int cSpellSave8, int cSpellSave9, int cSpellsPerDay0, int cSpellsPerDay1, int cSpellsPerDay2, int cSpellsPerDay3,
                      int cSpellsPerDay4, int cSpellsPerDay5, int cSpellsPerDay6, int cSpellsPerDay7, int cSpellsPerDay8, int cSpellsPerDay9, int cBonusSpells1, int cBonusSpells2, int cBonusSpells3,
                      int cBonusSpells4, int cBonusSpells5, int cBonusSpells6, int cBonusSpells7, int cBonusSpells8, int cBonusSpells9, @NonNull List<CharacterSpells> cSpells, @NonNull List<CharacterLanguages> cLanguages) {
        this.cId = cId;
        this.cPlayerName = cPlayerName;
        this.cCharacterName = cCharacterName;
        this.cAlignment = cAlignment;
        this.cLevel = cLevel;
        this.cDeity = cDeity;
        this.cHomeland = cHomeland;
        this.cRace = cRace;
        this.cSize = cSize;
        this.cGender = cGender;
        this.cHeight = cHeight;
        this.cWeight = cWeight;
        this.cHairColor = cHairColor;
        this.cEyeColor = cEyeColor;
        this.cStr = cStr;
        this.cDex = cDex;
        this.cCon = cCon;
        this.cWis = cWis;
        this.cCha = cCha;
        this.cHp = cHp;
        this.cSpeed = cSpeed;
        this.cInitMiscModifier = cInitMiscModifier;
        this.cFort = cFort;
        this.cReflex = cReflex;
        this.cWill = cWill;
        this.cAttackBonus = cAttackBonus;
        this.cClass = cClass;
        this.cAC = cAC;
        this.cTouchAC = cTouchAC;
        this.cFlatFootedAC = cFlatFootedAC;
        this.cSpellResist = cSpellResist;
        this.cWeapon = cWeapon;
        this.cSkills = cSkills;
        this.cSpellsKnows0 = cSpellsKnows0;
        this.cSpellsKnows1 = cSpellsKnows1;
        this.cSpellsKnows2 = cSpellsKnows2;
        this.cSpellsKnows3 = cSpellsKnows3;
        this.cSpellsKnows4 = cSpellsKnows4;
        this.cSpellsKnows5 = cSpellsKnows5;
        this.cSpellsKnows6 = cSpellsKnows6;
        this.cSpellsKnows7 = cSpellsKnows7;
        this.cSpellsKnows8 = cSpellsKnows8;
        this.cSpellsKnows9 = cSpellsKnows9;
        this.cSpellSave0 = cSpellSave0;
        this.cSpellSave1 = cSpellSave1;
        this.cSpellSave2 = cSpellSave2;
        this.cSpellSave3 = cSpellSave3;
        this.cSpellSave4 = cSpellSave4;
        this.cSpellSave5 = cSpellSave5;
        this.cSpellSave6 = cSpellSave6;
        this.cSpellSave7 = cSpellSave7;
        this.cSpellSave8 = cSpellSave8;
        this.cSpellSave9 = cSpellSave9;
        this.cSpellsPerDay0 = cSpellsPerDay0;
        this.cSpellsPerDay1 = cSpellsPerDay1;
        this.cSpellsPerDay2 = cSpellsPerDay2;
        this.cSpellsPerDay3 = cSpellsPerDay3;
        this.cSpellsPerDay4 = cSpellsPerDay4;
        this.cSpellsPerDay5 = cSpellsPerDay5;
        this.cSpellsPerDay6 = cSpellsPerDay6;
        this.cSpellsPerDay7 = cSpellsPerDay7;
        this.cSpellsPerDay8 = cSpellsPerDay8;
        this.cSpellsPerDay9 = cSpellsPerDay9;
        this.cBonusSpells1 = cBonusSpells1;
        this.cBonusSpells2 = cBonusSpells2;
        this.cBonusSpells3 = cBonusSpells3;
        this.cBonusSpells4 = cBonusSpells4;
        this.cBonusSpells5 = cBonusSpells5;
        this.cBonusSpells6 = cBonusSpells6;
        this.cBonusSpells7 = cBonusSpells7;
        this.cBonusSpells8 = cBonusSpells8;
        this.cBonusSpells9 = cBonusSpells9;
        this.cSpells = cSpells;
        this.cLanguages = cLanguages;
    }

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
