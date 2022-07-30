package com.sofkau.hospital.services;

import com.sofkau.hospital.records.Appointment;
import com.sofkau.hospital.records.Patient;
import com.sofkau.hospital.records.Specialty;
import com.sofkau.hospital.respositories.AppointmentRepo;
import com.sofkau.hospital.respositories.PatientRepo;
import com.sofkau.hospital.respositories.SpecialtyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;


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
    public void deleteSpecialty(Long specialtyID) {

        //Get all patients in the Specialty and delete them
        List<Patient> patientsToDelete = getSpecialtyPatients(specialtyID);
        if (!patientsToDelete.isEmpty()) {
            for (Patient patient : patientsToDelete) {
                deletePatient(patient.getPatientID());
            }
        }

        specialtiesRepo.deleteById(specialtyID);

    }



    @Override
    public Specialty createPatient(Patient patient) {

        //Search if user is already in the Specialty, if not, add it!
        Specialty specialty = specialtiesRepo.findById(patient.getFkSpecialtyID()).get();
        List<Patient> existingPatients = getSpecialtyPatients(specialty.getSpecialtyID());

        for(Patient comparator: existingPatients) {
            if (comparator.getName().equals(patient.getName())) {
                return null;
            }
        }

        patientsRepo.save(patient);
        specialty.addPatient(patient);
        return specialtiesRepo.save(specialty);
    }

    @Override
    public List<Patient> getSpecialtyPatients(@RequestBody Long specialtyID) {

        List<Patient> allPatients = patientsRepo.findAll();
        List<Patient> patientsInSpecialty = new ArrayList<>();
        for (Patient patient: allPatients) {
            if (patient.getFkSpecialtyID().equals(specialtyID)){
                patientsInSpecialty.add(patient);
            }
        }
        return  patientsInSpecialty;

    }

    @Override
    public void deletePatient(Long patientID) {

        //Get all appointments of the patient and delete them
        List<Appointment> appointmentsToDelete = getPatientAppointments(patientID);
        if (!appointmentsToDelete.isEmpty()) {
            for (Appointment appointment : appointmentsToDelete) {
                deleteAppointment(appointment.getAppointment_ID());
            }
        }

        patientsRepo.deleteById(patientID);

    }



    @Override
    public Patient addAppointment(Appointment appointment) {
        Patient patient = patientsRepo.findById(appointment.getFkPatientID()).get();
        patient.addAppointment(appointment);
        appointmentsRepo.save(appointment);
        return patientsRepo.save(patient);
    }

    @Override
    public List<Appointment> getPatientAppointments(Long patientID) {
        return appointmentsRepo.findAll();
    }

    @Override
    public void deleteAppointment(Long appointmentID) {
        appointmentsRepo.deleteById(appointmentID);
    }
}
