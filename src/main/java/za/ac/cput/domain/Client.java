/*
    Breyton Ernstzen (217203027)
    Applications Development
 */
package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @Column(name="clientId")
    private String clientId;

    @Embedded
    private Name name;

    @OneToMany(mappedBy = "clients", fetch = FetchType.EAGER)
        //Using this annotation will tell JPA that the CLIENTBOOK table
        // must have a foreign key column clientId(name="clientId") that references
        // the CLIENT table's ID column( referencedColumnName = "clientId").
        // @JoinColumn(name= "clientId", referencedColumnName = "clientId")
    private List<ClientBook> clientBooks;

    @OneToMany(mappedBy = "client")
    private Set<ClientContact> clientContactSet;



}
