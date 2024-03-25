package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @NotEmpty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "not null")
    private String id ;

    @NotEmpty
    @Size(min = 5)
    @Column(columnDefinition = "not null CHECK (LENGTH(name) > 4)")
    @Pattern(regexp = "^([A-Za-z])$")
    private String name ;

    @NotEmpty
    @Column(columnDefinition = "not null")
    private String password ;


    @Email
    @Column(columnDefinition = " unique")
    private String email;

    @NotEmpty
    @Column(columnDefinition = "not null")
    @Max(21)
    @Digits(integer = 10 ,fraction = 0)
    private Integer age;

    @NotEmpty
    @Pattern(regexp ="^(JOB_SEEKER|EMPLOYER)$")
    @Column(columnDefinition = "not null check role='JOB_SEEKER' or role='EMPLOYER')")
    private String role;

}
