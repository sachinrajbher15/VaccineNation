package com.acciojob.VaccineNation.repository;

import com.acciojob.VaccineNation.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
