package com.acciojob.VaccineNation.service;

import com.acciojob.VaccineNation.model.Doctor;
import com.acciojob.VaccineNation.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public void addDoctor(Doctor doctor) {
         doctorRepository.save(doctor);
    }

    public String deleteDoctor(int id) {
        doctorRepository.deleteById(id);
        return "Doctor Deleted Successfully";
    }
}
