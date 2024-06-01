package com.acciojob.VaccineNation.controller;

import com.acciojob.VaccineNation.Enum.VaccineBrand;
import com.acciojob.VaccineNation.model.Doctor;
import com.acciojob.VaccineNation.model.Dose;
import com.acciojob.VaccineNation.model.Patient;
import com.acciojob.VaccineNation.service.DoctorService;
import com.acciojob.VaccineNation.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")

public class DoseController {
    @Autowired
    DoseService doseService;

    //Add a dose
    @PostMapping("/vaccinate")
    public Dose addDose(@RequestParam("id") int patientId, @RequestParam("brand") VaccineBrand vaccineBrand){
        return doseService.addDose(patientId,vaccineBrand);
    }
}
