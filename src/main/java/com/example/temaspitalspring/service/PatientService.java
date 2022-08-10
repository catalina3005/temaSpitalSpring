package com.example.temaspitalspring.service;


import com.example.temaspitalspring.exception.NoDoctorException;
import com.example.temaspitalspring.exception.NoPatientException;
import com.example.temaspitalspring.exception.NoVisitException;
import com.example.temaspitalspring.model.Doctor;
import com.example.temaspitalspring.model.Patient;
import com.example.temaspitalspring.model.Visit;
import com.example.temaspitalspring.repository.DoctorRepository;
import com.example.temaspitalspring.repository.PatientRepository;
import com.example.temaspitalspring.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final VisitRepository visitRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findPatientByCnp(String cnp) throws NoPatientException {
        return patientRepository.findByCnp(cnp).orElseThrow(NoPatientException::new);
    }

    public void addDoctorToPatient(Integer patientId, Integer doctorId) throws NoPatientException, NoDoctorException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(NoPatientException::new);
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(NoDoctorException::new);
        patient.setDoctor(doctor);
        patientRepository.save(patient);
    }

    public void addVisitToPatient(Integer patientId, Integer visitId) throws NoPatientException, NoVisitException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(NoPatientException::new);
        Visit visit = visitRepository.findById(visitId).orElseThrow(NoVisitException::new);
        patient.addVisit(visit);
        patientRepository.save(patient);
    }
}