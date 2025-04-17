package com.example.jpa_relations.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileDTO {

    // order by database for arrangement but doesn't affect

    private Integer customer_id;
    @Email
    private String email;
    @Pattern(regexp = "^(male|female)$")
    private String gender;
    @Size(max = 10)
    private String phone_number;

}
