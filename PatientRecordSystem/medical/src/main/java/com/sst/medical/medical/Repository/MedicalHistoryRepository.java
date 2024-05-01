package com.sst.medical.medical.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sst.medical.medical.Models.MedicalHistory;

@Repository
public interface MedicalHistoryRepository extends CrudRepository<MedicalHistory, Long> {
    List<MedicalHistory> findAllByPatientId(Long patientId);
}

