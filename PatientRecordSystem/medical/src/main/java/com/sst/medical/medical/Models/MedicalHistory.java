package com.sst.medical.medical.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Patient patient;
    private Long patientId;
    private String diseaseName;
    private String treatmentDetails;
    private Date dateOfDiagnosis;

    // Getters and setters
    // Constructors, equals, hashcode, and toString methods
}