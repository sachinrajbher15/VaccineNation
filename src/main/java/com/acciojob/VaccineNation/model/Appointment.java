package com.acciojob.VaccineNation.model;

import com.acciojob.VaccineNation.Enum.AppointmentStatus;
import com.acciojob.VaccineNation.repository.PatientRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String appointmentId;

    @CreationTimestamp
    private Date dateOfApppointment;

    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus status;

    @OneToOne
    @JoinColumn
    Patient patient;

    @ManyToOne
    @JoinColumn
    Doctor doctor;
}
