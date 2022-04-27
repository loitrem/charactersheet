package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class CharacterWeapons implements Serializable {

    private static final long serialVersionUID = 1854615832432628775L;

    @Id //ID field
    @Column(name = "Weapons Id")
    Long wId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Characters_Id")
    Characters wCharacters;

    @NonNull @NotBlank
    String wName;

    @NotBlank
    int wAttackBonus;

    @NonNull @NotBlank
    String wCrit;

    @NonNull @NotBlank
    String wDamage;

    int wRange;

    public CharacterWeapons(Long wId, Characters wCharacters, @NonNull String wName, int wAttackBonus, @NonNull String wCrit, @NonNull String wDamage, int wRange) {
        this.wId = wId;
        this.wCharacters = wCharacters;
        this.wName = wName;
        this.wAttackBonus = wAttackBonus;
        this.wCrit = wCrit;
        this.wDamage = wDamage;
        this.wRange = wRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CharacterWeapons that = (CharacterWeapons) o;
        return wId != null && Objects.equals(wId, that.wId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
