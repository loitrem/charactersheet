package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class Players implements Serializable {

    private static final long serialVersionUID = 3262270526504307566L;
    @Id
    @SequenceGenerator( //creates a sequence
            name = "Players_sequence", //names the table in the database
            sequenceName = "Players_sequence", // sequence name
            allocationSize = 1 // incriment by 1
    )
    @GeneratedValue(//tells what value to input
            strategy = GenerationType.SEQUENCE, // says to use a sequence instead of auto increment aka GenerationType.IDENTITY
            generator = "Players_sequence" // use sequence name
    )
    Long pId;

    @NotBlank @NonNull
    String pPlayerName;

    @NotBlank @NonNull
    String pUserType;

    @NonNull @NotBlank @Column(unique = true) //cannot be null/blank and must be unique
    @Pattern(regexp = "^[A-Za-z0-9]\\w{5,}$", message = "Must contain at least 6 characters\n" +
            "Must only contain letters or numbers")
    String pUsername;

    @NonNull @NotBlank//cannot be null/blank
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Must contain at least 8 characters\n" +
            "At least 1 upper case letter\n" +
            "At least 1 lower case letter\n" +
            "At least 1 number\n" +
            "At least 1 special character")
    String pPassword;

    @OneToMany(mappedBy = "cPlayer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    List<Characters> pCharacters;

    @OneToMany(mappedBy = "gGameCreator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    List<Games> pGamesCreated;

    public void setpGamesCreated(List<Games> pGamesCreated) {
        this.pGamesCreated = pGamesCreated;
    }

    public List<Games> getpGamesCreated() {
        return pGamesCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Players players = (Players) o;
        return pId != null && Objects.equals(pId, players.pId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
