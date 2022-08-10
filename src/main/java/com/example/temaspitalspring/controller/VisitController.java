package com.example.temaspitalspring.controller;
import com.example.temaspitalspring.exception.NoDoctorException;
import com.example.temaspitalspring.exception.NoPatientException;
import com.example.temaspitalspring.exception.NoVisitException;
import com.example.temaspitalspring.model.Speciality;
import com.example.temaspitalspring.model.Visit;
import com.example.temaspitalspring.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("visit")
public class VisitController {
    private final VisitService visitService;

    @GetMapping("/all")
    public List<Visit> getAllVisits(){
        return visitService.getAllVisits();
    }

    @GetMapping("/getVisits")
    public List<Visit> getVisitsByCnpAndSpeciality(@RequestParam String cnp, @RequestParam Speciality speciality) throws NoPatientException {
        return visitService.getVisitsByCnpAndSpeciality(cnp, speciality);
    }

    @PostMapping("/addVisit")
    public Visit addVisit(@RequestBody Visit visit){
        return visitService.addVisit(visit);
    }

    @PostMapping("/addPatient/visitId/{visitId}/patientId/{patientId}")
    public void addPatientToVisit(@PathVariable Integer visitId, @PathVariable Integer patientId) throws NoVisitException, NoPatientException {
        visitService.addPatientToVisit(visitId,patientId);
    }

    @PostMapping("/addDoctor/visitId/{visitId}/doctorId/{doctorId}")
    public void addDoctorToVisit(@PathVariable Integer visitId,@PathVariable Integer doctorId) throws NoVisitException, NoDoctorException {
        visitService.addDoctorToVisit(visitId, doctorId);
    }
}