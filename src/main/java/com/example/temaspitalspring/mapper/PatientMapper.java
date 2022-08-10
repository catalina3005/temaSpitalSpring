package com.example.temaspitalspring.mapper;
import com.example.temaspitalspring.dto.PatientDTO;
import com.example.temaspitalspring.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientDTO toPatientDTO(Patient patient);
}