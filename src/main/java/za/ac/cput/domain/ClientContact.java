/*
Nondumiso Gaga(220430853)
08/08/2022
 */
package za.ac.cput.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ClientContact implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "clientContactId")
    private String clientContactId;

    @ManyToOne
    @JoinColumn(name = "contactId")
    @NotFound(action = NotFoundAction.IGNORE)
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @NotFound(action = NotFoundAction.IGNORE)
    private Client client;

}