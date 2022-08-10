package com.example.temaspitalspring.dto;
import com.example.temaspitalspring.model.Doctor;
import com.example.temaspitalspring.model.Speciality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private String name;
    private Speciality speciality;

    public DoctorDTO(Doctor doctor){
        this.name = doctor.getName();
        this.speciality = doctor.getSpeciality();
    }
}
