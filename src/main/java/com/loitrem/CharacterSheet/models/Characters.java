package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class Characters {

    @Id //ID field
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

    @OneToMany(mappedBy = "wCharacterID", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NonNull @NotBlank
    List<CharacterWeapons> cWeapon;

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

    @OneToMany(mappedBy = "cspCharacters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NonNull @NotBlank
    List<CharacterSpells> cSpells;

    @OneToMany(mappedBy = "lCharacters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NonNull @NotBlank
    List<CharacterLanguages> cLanguages;
}
