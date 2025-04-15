package com.example.jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
//@Column(columnDefinition = "")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name cannot be empty..")
    @Pattern(regexp = "^([a-z]|[A-Z])*$",message = "should be letters only...")
    @Size(min = 4,max = 16,message = "name size is between 4 and 16")
    @Column(columnDefinition = "varchar(16) not null")
//    @Column(nullable = false)
    private String name;
    @NotEmpty(message = "category cannot be empty..")
    @Pattern(regexp = "^(sweets|drinks)+$",message = "category is only sweets or drinks")
    @Column(columnDefinition = "varchar(6) not null")
    private String category;
    @NotNull(message = "price cannot be null..")
    @PositiveOrZero(message = "cannot be negative price")
    @Max(value = 100,message = "max price is 100 SR")
    @Column(columnDefinition = "int not null")
    private Integer price;
    @NotNull
//    @Column(columnDefinition = "int ,foreign key (employee_id) references employee(id)")
    @Column(columnDefinition = "int not null")
    private Integer employee_id;

}
