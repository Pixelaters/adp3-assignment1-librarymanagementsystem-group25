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
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Client implements Serializable {

    @Id
    @Column(name="clientId")
    private String clientId;
    @Embedded
    @Column(name="name")
    private Name name;

    @ManyToMany(mappedBy = "clientBook")
    private Set<Book> books = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<ClientContact> clientContactSet;


}
