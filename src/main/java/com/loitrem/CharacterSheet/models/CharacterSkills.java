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
public class CharacterSkills {

    @Id //ID field
    @Column(name = "Character Skills Id")
    Long csId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Characters_Id")
    Characters csCharacters;

    @NotBlank
    int csAbilityMod;

    @NotBlank
    int csRanks;

    @NotBlank
    int csMiscMod;

}
