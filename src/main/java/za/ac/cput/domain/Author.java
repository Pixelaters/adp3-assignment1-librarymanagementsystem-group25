package za.ac.cput.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Author {
    @Id
    @NotNull
    private String authorId;

    @NotNull
    private String name;

    private String middleName;

    @NotNull
    private String lastName;

    @ManyToMany(mappedBy = "authorSet")
    Set<Book> bookSet;
}
