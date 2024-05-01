package com.sst.medical.medical.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.medical.medical.Models.MedicalHistory;
import com.sst.medical.medical.Models.Patient;
import com.sst.medical.medical.Repository.MedicalHistoryRepository;
import com.sst.medical.medical.Repository.PatientRepository;

@Service
public class MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<MedicalHistory> getAllMedicalHistoriesByPatientId(Long patientId) {
        return medicalHistoryRepository.findAllByPatientId(patientId);
    }

    public MedicalHistory addMedicalHistory(MedicalHistory medicalHistory) {
        // Validate patient existence
        Optional<Patient> optionalPatient = patientRepository.findById(medicalHistory.getPatient().getId());
        Patient patient = optionalPatient.orElse(null); // Or handle the case when patient is not found
        
        medicalHistory.setPatient(patient);
        return medicalHistoryRepository.save(medicalHistory);
    }

    public MedicalHistory updateMedicalHistory(Long id, MedicalHistory medicalHistory) {
        Optional<MedicalHistory> optionalExistingMedicalHistory = medicalHistoryRepository.findById(id);
        if (optionalExistingMedicalHistory.isPresent()) {
            MedicalHistory existingMedicalHistory = optionalExistingMedicalHistory.get();
            // Update fields
            existingMedicalHistory.setDiseaseName(medicalHistory.getDiseaseName());
            existingMedicalHistory.setTreatmentDetails(medicalHistory.getTreatmentDetails());
            existingMedicalHistory.setDateOfDiagnosis(medicalHistory.getDateOfDiagnosis());
            return medicalHistoryRepository.save(existingMedicalHistory);
        } else {
            return null;
        }
    }
    
    public void deleteMedicalHistory(Long id) {
        medicalHistoryRepository.deleteById(id);
    }
}
