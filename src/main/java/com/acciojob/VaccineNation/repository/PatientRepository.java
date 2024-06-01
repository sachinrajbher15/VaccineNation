package com.acciojob.VaccineNation.repository;

import com.acciojob.VaccineNation.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
