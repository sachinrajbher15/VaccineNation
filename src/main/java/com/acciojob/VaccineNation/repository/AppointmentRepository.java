package com.acciojob.VaccineNation.repository;

import com.acciojob.VaccineNation.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
