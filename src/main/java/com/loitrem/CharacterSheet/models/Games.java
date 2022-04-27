package com.loitrem.CharacterSheet.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
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
public class Games {

    @Id
    @Column(name = "Game_Id")
    Long gId;

    @NotBlank @NonNull
    String gName;

    String gDescription;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NonNull @NotNull
    Date gStartDate;

    @ToString.Exclude
    @ManyToMany(mappedBy = "cGames", fetch = FetchType.LAZY)
    List<Characters> gCharacters;


}
