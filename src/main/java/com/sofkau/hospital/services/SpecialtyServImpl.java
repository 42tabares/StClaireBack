package com.sofkau.hospital.services;

import com.sofkau.hospital.records.Appointment;
import com.sofkau.hospital.records.Patient;
import com.sofkau.hospital.records.Specialty;
import com.sofkau.hospital.respositories.AppointmentRepo;
import com.sofkau.hospital.respositories.PatientRepo;
import com.sofkau.hospital.respositories.SpecialtyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServImpl implements SpecialtyServ {

    @Autowired
    private SpecialtyRepo specialtiesRepo;

    @Autowired
    private PatientRepo patientsRepo;

    @Autowired
    private AppointmentRepo appointmentsrepo;

    @Override
    public Specialty createSpecialty(Specialty specialty) {
        return null;
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        return null;
    }

    @Override
    public void deleteSpecialty(Specialty specialty) {

    }

    @Override
    public Specialty createPatient(Patient patient) {
        return null;
    }

    @Override
    public List<Patient> getSpecialtyPatients(Specialty specialty) {
        return null;
    }

    @Override
    public void deletePatient(Patient patient) {

    }

    @Override
    public Patient addAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public List<Appointment> getPatientAppointments(Patient patient) {
        return null;
    }

    @Override
    public void deleteAppointment(Appointment appointment) {

    }
}
