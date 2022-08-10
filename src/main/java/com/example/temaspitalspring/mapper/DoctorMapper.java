package com.example.temaspitalspring.mapper;
import com.example.temaspitalspring.dto.DoctorDTO;
import com.example.temaspitalspring.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorDTO toDoctorDTO(Doctor doctor);
}