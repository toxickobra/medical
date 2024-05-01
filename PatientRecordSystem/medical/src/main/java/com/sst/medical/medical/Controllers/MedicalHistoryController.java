package com.sst.medical.medical.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sst.medical.medical.Models.MedicalHistory;
import com.sst.medical.medical.Services.MedicalHistoryService;

@RestController
@RequestMapping("/medicalhistories")
public class MedicalHistoryController {

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @GetMapping("/{patientId}")
    public ResponseEntity<List<MedicalHistory>> getAllMedicalHistoriesByPatientId(@PathVariable("patientId") Long patientId) {
        List<MedicalHistory> medicalHistories = medicalHistoryService.getAllMedicalHistoriesByPatientId(patientId);
        return new ResponseEntity<>(medicalHistories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicalHistory> addMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
        MedicalHistory newMedicalHistory = medicalHistoryService.addMedicalHistory(medicalHistory);
        return new ResponseEntity<>(newMedicalHistory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalHistory> updateMedicalHistory(@PathVariable("id") Long id, @RequestBody MedicalHistory medicalHistory) {
        MedicalHistory updatedMedicalHistory = medicalHistoryService.updateMedicalHistory(id, medicalHistory);
        return new ResponseEntity<>(updatedMedicalHistory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalHistory(@PathVariable("id") Long id) {
        medicalHistoryService.deleteMedicalHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

