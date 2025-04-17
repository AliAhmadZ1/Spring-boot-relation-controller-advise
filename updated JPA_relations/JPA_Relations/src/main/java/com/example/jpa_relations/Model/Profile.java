package com.example.jpa_relations.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

//@Data
@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Profile {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)-> ;because it is following customer in one - one relation
    private Integer id;
    @Column(columnDefinition = "varchar(30)")
    private String email;
    @Column(columnDefinition = "varchar(10)")
    private String phone_number;
    @Column(columnDefinition = "varchar(6)")
    @Check(constraints = "gender like 'male' or gender like 'female'")
    private String gender;

    @OneToOne
    @MapsId // mapped by leader
    @JsonIgnore // to avoid infinity loop
    private Customer customer;


}
