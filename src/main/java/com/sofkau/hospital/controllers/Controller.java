package com.sofkau.hospital.controllers;

import com.sofkau.hospital.records.Appointment;
import com.sofkau.hospital.records.Patient;
import com.sofkau.hospital.records.Specialty;
import com.sofkau.hospital.services.SpecialtyServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class Controller {

    @Autowired
    private SpecialtyServ service;

    @GetMapping("get/specialties")
    public List<Specialty> getAllSpecialties(){
        return service.getAllSpecialties();
    }

    @GetMapping("get/patients/{id}")
    public List<Patient> getSpecialtyPatients(@PathVariable("id") Long specialtyID){
        return service.getSpecialtyPatients(specialtyID);
    }

    @GetMapping("get/appointments/{id}")
    public List<Appointment> getPatientAppointments(@PathVariable("id") Long patientID){
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
        return service.createAppointment(appointment);
    }

    @DeleteMapping("delete/specialty/{id}")
    public void deleteSpecialty(@PathVariable("id") Long specialtyID){
        service.deleteSpecialty(specialtyID);
    }

    @DeleteMapping("delete/patient/{id}")
    public void deletePatient(@PathVariable("id") Long patientID){
        service.deletePatient(patientID);
    }

    @DeleteMapping("delete/appointment/{id}")
    public void deleteAppointment(@PathVariable("id") Long appointmentID){
        service.deleteAppointment(appointmentID);
    }
}
