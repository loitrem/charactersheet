package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class Players {

    @Id
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

    public Players(Long pId, @NonNull String pPlayerName, @NonNull String pUsername, @NonNull String pPassword, List<Games> pGamesCreated) {
        this.pId = pId;
        this.pPlayerName = pPlayerName;
        this.pUsername = pUsername;
        this.pPassword = pPassword;
        this.pGamesCreated = pGamesCreated;
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
