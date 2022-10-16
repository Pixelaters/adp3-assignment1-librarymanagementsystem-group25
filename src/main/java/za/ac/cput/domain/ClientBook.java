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
@IdClass(ClientBookId.class)
public class ClientBook implements Serializable {

//    @PrimaryKeyJoinColumn(name="bookId",referencedColumnName = "bookId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Book books;
    @ManyToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn(name="clientId",referencedColumnName = "clientId")
    private Client clients;

    @Id
    @GeneratedValue
    private String clientBookId;

    private String clientId;

    private String bookId;

    private String dateOrdered;
}



