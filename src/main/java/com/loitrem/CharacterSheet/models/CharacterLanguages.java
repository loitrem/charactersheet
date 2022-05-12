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
public class CharacterLanguages implements Serializable {

    private static final long serialVersionUID = -63216786411689107L;

    @Id //ID field
    @SequenceGenerator( //creates a sequence
            name = "CharacterLanguages_sequence", //names the table in the database
            sequenceName = "CharacterLanguages_sequence", // sequence name
            allocationSize = 1 // incriment by 1
    )
    @GeneratedValue(//tells what value to input
            strategy = GenerationType.SEQUENCE, // says to use a sequence instead of auto increment aka GenerationType.IDENTITY
            generator = "CharacterLanguages_sequence" // use sequence name
    )
    Long lId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Characters_Id")
    Characters lCharacters;

    @NonNull @NotBlank
    String lName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CharacterLanguages that = (CharacterLanguages) o;
        return lId != null && Objects.equals(lId, that.lId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
