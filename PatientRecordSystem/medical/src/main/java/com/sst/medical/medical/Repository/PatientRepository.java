package com.sst.medical.medical.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sst.medical.medical.Models.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    // You can add custom methods here if needed
    Optional<Patient> findById(Long patientId);
}
