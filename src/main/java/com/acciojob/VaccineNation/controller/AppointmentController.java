package com.acciojob.VaccineNation.controller;

import com.acciojob.VaccineNation.model.Appointment;
import com.acciojob.VaccineNation.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestParam("pid") int patientId, @RequestParam("did") int doctorId) {
        try {
            Appointment appointment = appointmentService.bookAppointment(patientId, doctorId);
            return new ResponseEntity("Booked",HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
