package com.sst.medical.medical.DTOs;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AppointmentDTO {

    private Long id;
    private Long patientId;
    private Date appointmentDate;
    private String doctorName;
    private String purposeOfVisit;

    // Constructors, getters, setters
}
