package com.example.temaspitalspring.mapper;
import com.example.temaspitalspring.dto.VisitDTO;
import com.example.temaspitalspring.model.Visit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitMapper {
    VisitDTO toVisitDTO(Visit visit);
}