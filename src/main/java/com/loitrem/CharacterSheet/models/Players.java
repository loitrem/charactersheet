package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class Players {

    @Id
    Long pId;

    @NotBlank @NonNull
    String pPlayerName;

    @NonNull @NotBlank @Column(unique = true) //cannot be null/blank and must be unique
    @Pattern(regexp = "^[A-Za-z0-9]\\w{5,}$", message = "Must contain at least 6 characters\n" +
            "Must only contain letters or numbers")
    String pUserName;

    @NonNull @NotBlank//cannot be null/blank
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Must contain at least 8 characters\n" +
            "At least 1 upper case letter\n" +
            "At least 1 lower case letter\n" +
            "At least 1 number\n" +
            "At least 1 special character")
    String pPassword;

    @OneToMany(mappedBy = "gGameCreator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Games> pGamesCreated;

}
