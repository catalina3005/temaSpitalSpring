package com.example.temaspitalspring.service;
import com.example.temaspitalspring.exception.NoDoctorException;
import com.example.temaspitalspring.exception.NoPatientException;
import com.example.temaspitalspring.model.Doctor;
import com.example.temaspitalspring.model.Patient;
import com.example.temaspitalspring.model.Speciality;
import com.example.temaspitalspring.repository.DoctorRepository;
import com.example.temaspitalspring.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> findDoctorBySpeciality(Speciality speciality){
        return doctorRepository.findBySpeciality(speciality);
    }

    public void addPatientToDoctor(Integer doctorId, Integer patientId) throws NoDoctorException, NoPatientException {
        Doctor d = doctorRepository.findById(doctorId).orElseThrow(NoDoctorException::new);
        Patient p = patientRepository.findById(patientId).orElseThrow(NoPatientException::new);
        d.addPatient(p);
        doctorRepository.save(d);
    }
}