package com.acciojob.VaccineNation.service;

import com.acciojob.VaccineNation.exception.PatientNotFoundException;
import com.acciojob.VaccineNation.model.Patient;
import com.acciojob.VaccineNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public void addPatient(Patient patient) {
        //Patient savedPatient = patientRepository.save(patient);
        //return savedPatient;
        patientRepository.save(patient);
    }

    public Patient getPatient(int id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if(optionalPatient.isEmpty()){
            throw new PatientNotFoundException("Invalid Patient ID");
        }
        Patient patient = optionalPatient.get();
        return patient;
    }
}
