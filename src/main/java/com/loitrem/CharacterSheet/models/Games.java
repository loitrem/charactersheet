package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class Games implements Serializable {

    private static final long serialVersionUID = 7220229467343593360L;
    @Id
    @SequenceGenerator( //creates a sequence
            name = "Games_sequence", //names the table in the database
            sequenceName = "Games_sequence", // sequence name
            allocationSize = 1 // incriment by 1
    )
    @GeneratedValue(//tells what value to input
            strategy = GenerationType.SEQUENCE, // says to use a sequence instead of auto increment aka GenerationType.IDENTITY
            generator = "Games_sequence" // use sequence name
    )
    Long gId;

    String gName;
    String gDescription;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date gStartDate;

    @ToString.Exclude
    @OneToMany(mappedBy = "cGames", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Characters> gCharacters;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pGamesCreated", nullable = false)
    Players gGameCreator;

    public Games(String gName, String gDescription, Date gStartDate) {
        this.gName = gName;
        this.gDescription = gDescription;
        this.gStartDate = gStartDate;
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
