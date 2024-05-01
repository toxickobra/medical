package com.sst.medical.medical.DTOs;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MedicalHistoryDTO {

    private Long id;
    private Long patientId;
    private String diseaseName;
    private String treatmentDetails;
    private Date dateOfDiagnosis;

    // Constructors, getters, setters
}