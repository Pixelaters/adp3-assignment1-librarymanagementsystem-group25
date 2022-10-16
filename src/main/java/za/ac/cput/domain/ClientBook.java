package za.ac.cput.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ClientBook implements Serializable {

//    @EmbeddedId
//    ClientBookId id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("bookId")
//    @JoinColumn(name = "bookId")
//    private Book books;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("clientId")
//    @JoinColumn(name = "clientId")
//    private Client clients;
//
//
//    private String dateOrdered;

    @Id
    String clientBookId;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book books;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client clients;

    private String dateOrdered;
}



