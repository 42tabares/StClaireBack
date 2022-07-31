package com.sofkau.hospital.services;

import com.sofkau.hospital.DTO.SpecialtyDTO;
import com.sofkau.hospital.records.Appointment;
import com.sofkau.hospital.records.Patient;
import com.sofkau.hospital.records.Specialty;
import java.util.List;

public interface SpecialtyServ {

    Specialty createSpecialty(Specialty specialty);
    List<SpecialtyDTO> getAllSpecialties();
    void deleteSpecialty(Long specialtyID);
    Specialty updateSpecialtyFields(Specialty specialty);

    Specialty createPatient(Patient patient);
    List<Patient> getSpecialtyPatients(Long specialtyID);
    void deletePatient(Long patientID);

    Patient createAppointment(Appointment appointment);
    List<Appointment> getPatientAppointments(Long patientID);
    void deleteAppointment(Long appointmentID);

}
