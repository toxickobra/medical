package com.sst.medical.medical.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.medical.medical.Models.Appointment;
import com.sst.medical.medical.Models.Patient;
import com.sst.medical.medical.Repository.AppointmentRepository;
import com.sst.medical.medical.Repository.PatientRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<Appointment> getAllAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public Appointment addAppointment(Appointment appointment) {
        // Validate patient existence
        Optional<Patient> optionalPatient = patientRepository.findById(appointment.getPatient().getId());
    
        if (!optionalPatient.isPresent()) {
            throw new RuntimeException("Patient not found");
        }
        
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment appointment) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
    
        if (!optionalAppointment.isPresent()) {
            throw new RuntimeException("Appointment not found");
        }
        
        Appointment existingAppointment = optionalAppointment.get();
        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
        
        // Save the updated appointment back to the database
        return appointmentRepository.save(existingAppointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}

