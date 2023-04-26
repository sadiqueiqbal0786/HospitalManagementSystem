package com.hospitalmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "hospital")
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "doctor_name")
    private String doctorName;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "appointment_date")
    private String appointmentDate;
    @Column(name = "patient_phone")
    private long patientPhone;
    @Column(name = "fee")
    private double fee;

    public Hospital() {
    }

    public Hospital(String doctorName, String patientName, String appointmentDate, long patientPhone, double fee) {
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.patientPhone = patientPhone;
        this.fee = fee;
    }
}
