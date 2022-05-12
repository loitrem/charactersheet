package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class CharacterSpells implements Serializable {

    private static final long serialVersionUID = -484664250685965320L;

    @Id //ID field

    Long cspId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cId")
    Characters cspCharacters;

    @NonNull @NotBlank
    String cspName;

    @NotNull
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



