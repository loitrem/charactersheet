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
public class CharacterLanguages implements Serializable {

    private static final long serialVersionUID = -63216786411689107L;

    @Id //ID field
    @Column(name = "Languages Id")
    Long lId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Characters_Id")
    Characters lCharacters;

    @NonNull @NotBlank
    String lName;

    public CharacterLanguages(Long lId, Characters lCharacters, @NonNull String lName) {
        this.lId = lId;
        this.lCharacters = lCharacters;
        this.lName = lName;
    }
}
