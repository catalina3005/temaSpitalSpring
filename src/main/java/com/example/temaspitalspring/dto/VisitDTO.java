package com.example.temaspitalspring.dto;
import com.example.temaspitalspring.model.Doctor;
import com.example.temaspitalspring.model.Patient;
import com.example.temaspitalspring.model.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {
    private Date date;
    private String patientCnp;
    private String doctorName;

    public VisitDTO(Visit visit){
        this.date = visit.getDate();
        this.patientCnp = visit.getPatient().getCnp();
        this.doctorName = visit.getDoctor().getName();
    }
}