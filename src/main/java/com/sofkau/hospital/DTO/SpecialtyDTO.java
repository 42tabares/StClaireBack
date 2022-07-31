package com.sofkau.hospital.DTO;

import com.sofkau.hospital.records.Patient;
import lombok.Data;

import java.util.List;

@Data
public class SpecialtyDTO {

    private Long specialtyID;
    private String name;
    private String physician;
    private List<Patient> patients;

    public SpecialtyDTO(Long specialtyID, String name, String physician, List<Patient> patients) {
        this.specialtyID = specialtyID;
        this.name = name;
        this.physician = physician;
        this.patients = patients;
    }
}
