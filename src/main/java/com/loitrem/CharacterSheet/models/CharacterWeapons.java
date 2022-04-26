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
public class CharacterWeapons {

    @Id //ID field
    @Column(name = "Weapons Id")
    Long wId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Characters_Id")
    Characters wCharacters;

    @NonNull @NotBlank
    int wCharacterID;

    @NonNull @NotBlank
    String wName;

    @NotBlank
    int wAttackBonus;

    @NonNull @NotBlank
    String wCrit;

    @NonNull @NotBlank
    String wDamage;

    int wRange;
}
