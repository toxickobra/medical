package com.sst.medical.medical.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.medical.medical.DTOs.PatientDTO;
import com.sst.medical.medical.Models.Patient;
import com.sst.medical.medical.Repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDTO> getAllPatients() {
        Iterable<Patient> patients = patientRepository.findAll();
        List<Patient> patientList = StreamSupport.stream(patients.spliterator(), false).collect(Collectors.toList());
        return patientList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientDTO getPatientById(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        return optionalPatient.map(this::convertToDTO).orElse(null);
    }

    public PatientDTO addPatient(PatientDTO patientDTO) {
        Patient patient = convertToEntity(patientDTO);
        return convertToDTO(patientRepository.save(patient));
    }

    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            Patient updatedPatient = convertToEntity(patientDTO);
            updatedPatient.setId(existingPatient.getId());
            return convertToDTO(patientRepository.save(updatedPatient));
        }
        return null;
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    private PatientDTO convertToDTO(Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setName(patient.getName());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setContactNumber(patient.getContactNumber());
        java.sql.Date sqlDateOfBirth = new java.sql.Date(patient.getDateOfBirth().getTime());
        patientDTO.setDateOfBirth(sqlDateOfBirth);
        return patientDTO;
    }

    private Patient convertToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setEmail(patientDTO.getEmail());
        patient.setContactNumber(patientDTO.getContactNumber());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        return patient;
    }
}
