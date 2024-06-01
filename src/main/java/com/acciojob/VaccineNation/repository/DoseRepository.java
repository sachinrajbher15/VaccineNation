package com.acciojob.VaccineNation.repository;

import com.acciojob.VaccineNation.model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose, Integer> {
}
