package com.example.jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Check(constraints = "age>=18")
@Check(constraints = "length(name)>=4")
@Check(constraints = "email like '%_@__%.__%'")
public class Employee {
    // id email is leave name age
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 4)
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Email
    private String email;
    @NotNull
    @Column(columnDefinition = "bool not null")
    private Boolean is_leave = false;
    @NotNull
    @Min(18)
    @Column(columnDefinition = "int not null")
    private Integer age;

}
