package za.ac.cput.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ClientBookId implements Serializable {

//    private Client client;
//    private Book book;

    private String clientId;
    private String bookId;

}
