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
public class CharacterWeapons implements Serializable {

    private static final long serialVersionUID = 1854615832432628775L;

    @Id //ID field
    @SequenceGenerator( //creates a sequence
            name = "CharacterWeapons_sequence", //names the table in the database
            sequenceName = "CharacterWeapons_sequence", // sequence name
            allocationSize = 1 // incriment by 1
    )
    @GeneratedValue(//tells what value to input
            strategy = GenerationType.SEQUENCE, // says to use a sequence instead of auto increment aka GenerationType.IDENTITY
            generator = "CharacterWeapons_sequence" // use sequence name
    )
    Long wId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cId")
    Characters wCharacters;
    String wName;
    int wAttackBonus;
    String wCrit;
    String wDamage;
    int wRange;

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
