package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class Characters implements Serializable {

    private static final long serialVersionUID = -3829796007095099036L;

    @Id //ID field
    Long cId;

    @NonNull @NotBlank
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pId", nullable = false)
    Players cPlayer;

    @NonNull @NotBlank
    String cCharacterName;

    @NonNull @NotBlank
    String cAlignment;

    @NotNull
    int cLevel;

    String cDeity;

    @NonNull @NotBlank
    String cHomeland;

    @NonNull @NotBlank
    String cRace;

    @NotBlank
    String cSize;

    @NonNull @NotBlank
    String cGender;

    String cHeight;

    int cWeight;

    String cHairColor;

    String cEyeColor;

    @NotNull
    int cStr;

    @NotNull
    int cDex;

    @NotNull
    int cCon;

    @NotNull
    int cWis;

    @NotNull
    int cCha;

    @NotNull
    int cHp;

    @NotNull
    int cSpeed;

    int cInitMiscModifier;

    @NotNull
    int cFort;

    @NotNull
    int cReflex;

    @NotNull
    int cWill;

    @NotNull
    int cAttackBonus;

    @NonNull @NotBlank
    String cClass;

    @NotNull
    int cAC;

    @NotNull
    int cTouchAC;

    @NotNull
    int cFlatFootedAC;

    @NotNull
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Games_Id", nullable = false)
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
