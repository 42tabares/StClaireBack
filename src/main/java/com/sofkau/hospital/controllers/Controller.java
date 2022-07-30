package com.sofkau.hospital.controllers;

import com.sofkau.hospital.records.Appointment;
import com.sofkau.hospital.records.Patient;
import com.sofkau.hospital.records.Specialty;
import com.sofkau.hospital.services.SpecialtyServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/")
public class Controller {

    @Autowired
    private SpecialtyServ service;

    @GetMapping("get/specialties")
    public List<Specialty> getAllSpecialties(){
        return service.getAllSpecialties();
    }

    @GetMapping("get/patients")
    public List<Patient> getSpecialtyPatients(@RequestBody Long specialtyID){
        return service.getSpecialtyPatients(specialtyID);
    }

    @GetMapping("get/appointments")
    public List<Appointment> getPatientAppointments(@RequestBody Long patientID){
        return service.getPatientAppointments(patientID);
    }

    @PostMapping("create/specialty")
    public Specialty createSpecialty(@RequestBody Specialty specialty){
        return service.createSpecialty(specialty);
    }

    @PostMapping("create/patient")
    public Specialty createPatient(@RequestBody Patient patient){
        return service.createPatient(patient);
    }

    @PostMapping("create/appointment")
    public Patient createAppointment(@RequestBody Appointment appointment){
        return service.addAppointment(appointment);
    }

    @DeleteMapping("delete/specialty")
    public void deleteSpecialty(@RequestBody Long specialtyID){
        service.deleteSpecialty(specialtyID);
    }

    @DeleteMapping("delete/patient")
    public void deletePatient(@RequestBody Long patientID){
        service.deletePatient(patientID);
    }

    @DeleteMapping("delete/appointment")
    public void deleteAppointment(@RequestBody Long appointmentID){
        service.deleteAppointment(appointmentID);
    }
}
