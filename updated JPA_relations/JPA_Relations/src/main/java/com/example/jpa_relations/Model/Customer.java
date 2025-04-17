package com.example.jpa_relations.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

//@Data (replaced with setter and getter to avoid errors)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition ="varchar(20) not null")
    private String username;
    @NotEmpty
    @Column(columnDefinition ="varchar(16) not null")
    private String password;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer") //cascade full access process, mapped by to connect follower
    @PrimaryKeyJoinColumn
    private Profile profile;

}
