package com.acciojob.VaccineNation.service;

import com.acciojob.VaccineNation.model.Patient;
import com.acciojob.VaccineNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public void addPatient(Patient patient) {
        //Patient savedPatient = patientRepository.save(patient);
        //return savedPatient;
        patientRepository.save(patient);
    }
}
