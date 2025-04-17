package com.example.jpa_relations.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer number;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String area;


    @ManyToOne
    @JoinColumn(name = "merchant_id",referencedColumnName = "id") // custom name for column of merchant
    @JsonIgnore
    private Merchant merchant;

}