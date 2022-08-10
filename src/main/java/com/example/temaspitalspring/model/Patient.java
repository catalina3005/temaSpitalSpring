package com.example.temaspitalspring.model;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient //extends Observable {
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String cnp;

    @ManyToOne
    private Doctor doctor;


    @OneToMany
    List<Visit> visitList = new ArrayList<>();


    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public void addVisit(Visit visit){
        this.visitList.add(visit);
    }
}