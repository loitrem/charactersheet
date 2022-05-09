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
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class CharacterWeapons implements Serializable {

    private static final long serialVersionUID = 1854615832432628775L;

    @Id //ID field
    Long wId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cId")
    Characters wCharacters;

    @NonNull @NotBlank
    String wName;

    @NotNull
    int wAttackBonus;

    @NonNull @NotBlank
    String wCrit;

    @NonNull @NotBlank
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
