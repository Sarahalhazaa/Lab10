package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {

    @NotEmpty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "not null")
    private String id ;

    @NotEmpty
    @Size(min = 5)
    @Column(columnDefinition = "  CHECK (LENGTH(name) > 4) not null")
    private String title ;

    @NotEmpty
    @Column(columnDefinition = "not null")
    private String description ;

    @NotEmpty
    @Column(columnDefinition = "not null")
    private String location ;

    @NotEmpty
    @Positive
    @Column(columnDefinition = "not null")
    private String salary;


    private Date postingDate;

}
