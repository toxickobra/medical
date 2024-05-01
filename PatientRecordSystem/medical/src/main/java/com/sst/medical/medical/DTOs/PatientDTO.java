package com.sst.medical.medical.DTOs;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter

@Setter

public class PatientDTO {

    private Long id;
    private String name;
    private String email;
    private String contactNumber;
    private Date dateOfBirth;

    // Constructors, getters, setters
}
