package com.example.temaspitalspring.service;
import com.example.temaspitalspring.exception.NoDoctorException;
import com.example.temaspitalspring.exception.NoPatientException;
import com.example.temaspitalspring.exception.NoVisitException;
import com.example.temaspitalspring.model.Doctor;
import com.example.temaspitalspring.model.Patient;
import com.example.temaspitalspring.model.Speciality;
import com.example.temaspitalspring.model.Visit;
import com.example.temaspitalspring.repository.DoctorRepository;
import com.example.temaspitalspring.repository.PatientRepository;
import com.example.temaspitalspring.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public List<Visit> getAllVisits(){
        return visitRepository.findAll();
    }

    public Visit addVisit(Visit visit){
        return visitRepository.save(visit);
    }

    public List<Visit> getVisitsByCnpAndSpeciality(String CNP, Speciality speciality) throws NoPatientException {
        Patient p = patientRepository.findByCnp(CNP).orElseThrow(NoPatientException::new);
        if (p.getDoctor().getSpeciality() == speciality)
            return p.getVisitList();
        else {
            System.out.println("The doctor does not have this speciality");
            return null;
        }
    }

    public void addPatientToVisit(Integer visitId, Integer patientId) throws NoPatientException, NoVisitException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(NoPatientException::new);
        Visit visit = visitRepository.findById(visitId).orElseThrow(NoVisitException::new);
        visit.setPatient(patient);
        visitRepository.save(visit);
    }

    public void addDoctorToVisit(Integer visitId, Integer doctorId) throws NoDoctorException, NoVisitException {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(NoDoctorException::new);
        Visit visit = visitRepository.findById(visitId).orElseThrow(NoVisitException::new);
        visit.setDoctor(doctor);
        visitRepository.save(visit);
    }
}