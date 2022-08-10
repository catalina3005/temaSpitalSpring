package com.example.temaspitalspring.repository;
import com.example.temaspitalspring.model.Doctor;
import com.example.temaspitalspring.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAll();
    Optional<Doctor> findById(Integer id);
    List<Doctor> findBySpeciality(Speciality speciality);
}