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
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private Date appointmentDate;
    private String doctorName;
    private String purposeOfVisit;
    @ManyToOne
    private Patient patient;

    // Getters and setters
    // Constructors, equals, hashcode, and toString methods
}