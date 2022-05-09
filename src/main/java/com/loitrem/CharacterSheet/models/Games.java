package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class Games {

    @Id
    Long gId;

    @NotBlank @NonNull
    String gName;

    String gDescription;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NonNull @NotNull
    Date gStartDate;

    @ToString.Exclude
    @OneToMany(mappedBy = "cGames", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Characters> gCharacters;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pGamesCreated", nullable = false)
    Players gGameCreator;

    public Games(Long gId, @NonNull String gName, String gDescription, @NonNull Date gStartDate, List<Characters> gCharacters, Players gGameCreator) {
        this.gId = gId;
        this.gName = gName;
        this.gDescription = gDescription;
        this.gStartDate = gStartDate;
        this.gCharacters = gCharacters;
        this.gGameCreator = gGameCreator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Games games = (Games) o;
        return gId != null && Objects.equals(gId, games.gId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
