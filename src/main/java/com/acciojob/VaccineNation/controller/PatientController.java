package com.acciojob.VaccineNation.controller;

import com.acciojob.VaccineNation.model.Patient;
import com.acciojob.VaccineNation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add-patient")
    public String addPatient(@RequestBody Patient patient){
        try{
            patientService.addPatient(patient);
            return "Patient Added Successfully";
        }
        catch (Exception e) {
            return "Some issues while adding the patient";
        }
    }
}
