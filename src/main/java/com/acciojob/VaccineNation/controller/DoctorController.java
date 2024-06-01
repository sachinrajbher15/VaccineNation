package com.acciojob.VaccineNation.controller;

import com.acciojob.VaccineNation.model.Doctor;
import com.acciojob.VaccineNation.repository.DoctorRepository;
import com.acciojob.VaccineNation.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")

public class DoctorController {

    @Autowired
    DoctorService doctorService;

    //Add a doctor
    @PostMapping("/add-doctor")
    public String addDoctor(@RequestBody Doctor doctor){
        try{
            doctorService.addDoctor(doctor);
            return "Doctor Added Successfully";

        }
        catch (Exception e) {
            return "Some issues while adding the doctor";
        }
    }

    //Get a patient
    //Delete a doctor
    @DeleteMapping("/delete-doctor")
    public String deleteDoctor(int id){
        return doctorService.deleteDoctor(id);
    }
}
