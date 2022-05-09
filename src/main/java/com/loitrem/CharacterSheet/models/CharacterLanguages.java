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
