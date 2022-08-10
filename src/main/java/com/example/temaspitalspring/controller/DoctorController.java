package com.example.temaspitalspring.controller;
import com.example.temaspitalspring.exception.NoDoctorException;
import com.example.temaspitalspring.exception.NoPatientException;
import com.example.temaspitalspring.model.Doctor;
import com.example.temaspitalspring.model.Speciality;
import com.example.temaspitalspring.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/GetBySpeciality")
    public List<Doctor> getDoctorBySpeciality(@RequestParam Speciality speciality) {
        return doctorService.findDoctorBySpeciality(speciality);
    }

    @PostMapping("/addDoctor")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @PostMapping("/addToDoctor/doctorId/{doctorId}/patientId/{patientId}")
    public void addPatientToDoctor(@PathVariable Integer doctorId, @PathVariable Integer patientId) throws NoDoctorException, NoPatientException {
        doctorService.addPatientToDoctor(doctorId,patientId);
    }
}
