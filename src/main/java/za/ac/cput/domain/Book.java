package za.ac.cput.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Book implements Serializable {
    @Id
    @Column(name = "bookId")
    private String bookId;
    @NotNull
    private String bookName;
    @NotNull
    private String author;
    @NotNull
    private String genre;
    @NotNull
    private String description;
    @NotNull
    private String isRented;
    @NotNull
    private String imgUrl;

    @OneToMany(mappedBy = "book")
    private Set<ClientBook> clientBookSet;


}
