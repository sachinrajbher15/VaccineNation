package com.acciojob.VaccineNation.service;

import com.acciojob.VaccineNation.Enum.AppointmentStatus;
import com.acciojob.VaccineNation.exception.DoctorNotFoundException;
import com.acciojob.VaccineNation.exception.PatientNotFoundException;
import com.acciojob.VaccineNation.model.Appointment;
import com.acciojob.VaccineNation.model.Doctor;
import com.acciojob.VaccineNation.model.Patient;
import com.acciojob.VaccineNation.repository.AppointmentRepository;
import com.acciojob.VaccineNation.repository.DoctorRepository;
import com.acciojob.VaccineNation.repository.DoseRepository;
import com.acciojob.VaccineNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    public Appointment bookAppointment(int patientId, int doctorId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if(optionalPatient.isEmpty()){
            throw new PatientNotFoundException("Invalid Patient ID");
        }
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Invalid Doctor ID");
        }
        Patient patient = optionalPatient.get();
        Doctor doctor = optionalDoctor.get();
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);
    }
}
