package com.sofkau.hospital.services;

import com.sofkau.hospital.records.Appointment;
import com.sofkau.hospital.records.Patient;
import com.sofkau.hospital.records.Specialty;
import java.util.List;

public interface SpecialtyServ {

    Specialty createSpecialty(Specialty specialty);
    List<Specialty> getAllSpecialties();
    void deleteSpecialty(Specialty specialty);


    Specialty createPatient(Patient patient);
    List<Patient> getSpecialtyPatients(Specialty specialty);
    void deletePatient(Patient patient);

    Patient addAppointment(Appointment appointment);
    List<Appointment> getPatientAppointments(Patient patient);
    void deleteAppointment(Appointment appointment);

}
