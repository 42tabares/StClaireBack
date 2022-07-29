package com.sofkau.hospital.records;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Entity(name="Patient")
@Table(name="patients")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientID;

    private String name;
    private Integer age;
    private String dates;
    private Integer appointments_quantity;

}
