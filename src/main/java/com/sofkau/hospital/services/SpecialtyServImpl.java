package com.sofkau.hospital.services;

import com.sofkau.hospital.records.Appointment;
import com.sofkau.hospital.records.Patient;
import com.sofkau.hospital.records.Specialty;
import com.sofkau.hospital.respositories.AppointmentRepo;
import com.sofkau.hospital.respositories.PatientRepo;
import com.sofkau.hospital.respositories.SpecialtyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SpecialtyServImpl implements SpecialtyServ {

    @Autowired
    private SpecialtyRepo specialtiesRepo;

    @Autowired
    private PatientRepo patientsRepo;

    @Autowired
    private AppointmentRepo appointmentsRepo;

    @Override
    public Specialty createSpecialty(Specialty specialty) {
        return specialtiesRepo.save(specialty);
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        return specialtiesRepo.findAll();
    }

    @Override
    public void deleteSpecialty(Specialty specialty) {

        //Get all patients in the Specialty and delete them
        List<Patient> patientsToDelete = getSpecialtyPatients(specialty);
        if (!patientsToDelete.isEmpty()) {
            for (Patient patient : patientsToDelete) {
                deletePatient(patient);
            }
        }

        specialtiesRepo.deleteById(specialty.getSpecialtyID());

    }



    @Override
    public Specialty createPatient(Patient patient) {

        //Search if user is already in the Specialty, if not, add it!
        Specialty specialty = patient.getSpecialty();
        List<Patient> existingPatients = getSpecialtyPatients(specialty);
        if (existingPatients.contains(patient)){
            return null;
        } else {
            patientsRepo.save(patient);
            specialty.addPatient(patient);
            return specialtiesRepo.save(specialty);
        }

    }

    @Override
    public List<Patient> getSpecialtyPatients(Specialty specialty) {

        List<Patient> allPatients = patientsRepo.findAll();
        List<Patient> patientsInAppointment = new ArrayList<>();
        for (Patient patient: allPatients) {
            if (patient.getSpecialty().getSpecialtyID().equals(specialty.getSpecialtyID())){
                patientsInAppointment.add(patient);
            }
        }
        return  patientsInAppointment;

    }

    @Override
    public void deletePatient(Patient patient) {

        //Get all appointments of the patient and delete them
        List<Appointment> appointmentsToDelete = getPatientAppointments(patient);
        if (!appointmentsToDelete.isEmpty()) {
            for (Appointment appointment : appointmentsToDelete) {
                deleteAppointment(appointment);
            }
        }

        patientsRepo.deleteById(patient.getPatientID());

    }



    @Override
    public Patient addAppointment(Appointment appointment) {
        Patient patient = appointment.getPatient();
        patient.addAppointment(appointment);
        appointmentsRepo.save(appointment);
        return patientsRepo.save(patient);
    }

    @Override
    public List<Appointment> getPatientAppointments(Patient patient) {
        return appointmentsRepo.findAll();
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        appointmentsRepo.deleteById(appointment.getAppointment_ID());
    }
}
