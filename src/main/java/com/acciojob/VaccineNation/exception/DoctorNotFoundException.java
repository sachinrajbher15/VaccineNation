package com.acciojob.VaccineNation.exception;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message){
        super(message);
    }
}
