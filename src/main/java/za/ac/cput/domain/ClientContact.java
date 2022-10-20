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

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@IdClass(ClientContactId.class)
public class ClientContact implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "clientContactId")
    private String clientContactId;

    @Id
    @Column(name = "contactId")
    private String contactId;


    @Id
    @Column(name = "clientId")
    private String clientId;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "contactId", referencedColumnName = "contactId")
    private Contact contact;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "clientId", referencedColumnName = "clientId")
    private Client client;

}