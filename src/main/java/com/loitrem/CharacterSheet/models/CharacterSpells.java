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
public class CharacterSpells implements Serializable {

    private static final long serialVersionUID = -484664250685965320L;

    @Id //ID field
    @SequenceGenerator( //creates a sequence
            name = "CharacterSpells_sequence", //names the table in the database
            sequenceName = "CharacterSpells_sequence", // sequence name
            allocationSize = 1 // incriment by 1
    )
    @GeneratedValue(//tells what value to input
            strategy = GenerationType.SEQUENCE, // says to use a sequence instead of auto increment aka GenerationType.IDENTITY
            generator = "CharacterSpells_sequence" // use sequence name
    )
    Long cspId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cId")
    Characters cspCharacters;

    String cspName;
    int cspRank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CharacterSpells that = (CharacterSpells) o;
        return cspId != null && Objects.equals(cspId, that.cspId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}



