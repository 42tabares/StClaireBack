package com.sofkau.hospital.records;


import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity(name="Specialty")
@Table(name="specialties")
@Data
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialtyID;

    private String name;
    private String physician_in_charge;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Patient> patients;

    public Specialty addPatient(Patient patient){
        this.patients.add(patient);
        return this;
    }

}
