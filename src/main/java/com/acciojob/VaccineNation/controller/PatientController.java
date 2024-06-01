package com.acciojob.VaccineNation.controller;

import com.acciojob.VaccineNation.model.Patient;
import com.acciojob.VaccineNation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")

public class PatientController {

    @Autowired
    PatientService patientService;

    //Add a patient
    @PostMapping("/add-patient")
    public ResponseEntity addPatient(@RequestBody Patient patient){
        try{
            patientService.addPatient(patient);
            return new ResponseEntity("Patient Added Successfully", HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    //Find a patient
    @GetMapping("/get-patient")
    public Patient getPatient(@RequestParam("id") int id){
        return patientService.getPatient(id);
    }
}
