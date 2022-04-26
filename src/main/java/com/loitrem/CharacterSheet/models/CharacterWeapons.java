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
}
