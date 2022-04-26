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
public class CharacterSpells implements Serializable {

    private static final long serialVersionUID = -484664250685965320L;

    @Id //ID field
    @Column(name = "Character Spells Id")
    Long cspId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Characters_Id")
    Characters cspCharacters;

    @NonNull @NotBlank
    String cspName;

    @NotBlank
    int cspRank;

    public CharacterSpells(Long cspId, Characters cspCharacters, @NonNull String cspName, int cspRank) {
        this.cspId = cspId;
        this.cspCharacters = cspCharacters;
        this.cspName = cspName;
        this.cspRank = cspRank;
    }
}



