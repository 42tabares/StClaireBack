package com.sofkau.hospital.records;


import com.sofkau.hospital.DTO.SpecialtyDTO;
import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity(name="Specialty")
@Table(name="specialties")
@Data
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialtyID;

    private String name;
    private String physician;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Patient> patients;

    public Specialty addPatient(Patient patient){
        this.patients.add(patient);
        return this;
    }

    public SpecialtyDTO toDTO(){
        return new SpecialtyDTO(this.specialtyID,this.name,this.physician,this.patients);
    }

}
