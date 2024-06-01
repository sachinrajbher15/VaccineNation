package com.acciojob.VaccineNation.service;

import com.acciojob.VaccineNation.Enum.VaccineBrand;
import com.acciojob.VaccineNation.exception.PatientNotFoundException;
import com.acciojob.VaccineNation.model.Dose;
import com.acciojob.VaccineNation.model.Patient;
import com.acciojob.VaccineNation.repository.DoseRepository;
import com.acciojob.VaccineNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;
    @Autowired
    PatientRepository patientRepository;

    public Dose addDose(int patientId, VaccineBrand vaccineBrand){
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if(optionalPatient.isEmpty()){
            throw new PatientNotFoundException("Invalid Patient ID");
        }

        Patient patient = optionalPatient.get();
        if(patient.isVaccinated()){
            throw new RuntimeException("Already Vaccinated");
        }
        patient.setVaccinated(true);

        Dose dose = new Dose();
        dose.setVaccineBrand(vaccineBrand);
        dose.setSerialNumber(String.valueOf(UUID.randomUUID()));
        dose.setPatient(patient);
        return doseRepository.save(dose);
    }
}
