package com.sofkau.hospital.records;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity(name="Patient")
@Table(name="patients")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientID;

    @ManyToOne
    @JoinColumn(name = "Related Specialty")
    private Specialty specialty;

    private String name;
    private Integer age;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Appointment> appointments;

    public Patient addAppointment(Appointment appointment){
        this.appointments.add(appointment);
        return this;
    }

}
