package com.example.tms.entity;

import java.math.BigDecimal;

import com.example.tms.entity.enums.InstructorType;
import com.example.tms.entity.enums.RecordStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "instructor_code", nullable = false, unique = true, length = 50)
    private String instructorCode;

    @Column(name = "instructor_name", nullable = false)
    private String instructorName;

    @Enumerated(EnumType.STRING)
    @Column(name = "instructor_type", nullable = false, length = 30)
    private InstructorType instructorType;

    @Column(name = "organization")
    private String organization;

    @Column(name = "expertise")
    private String expertise;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", length = 30)
    private String phone;

    @Column(name = "hourly_rate", nullable = false, precision = 18, scale = 2)
    private BigDecimal hourlyRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private RecordStatus status;

    public Long getId() {
        return id;
    }

    public String getInstructorCode() {
        return instructorCode;
    }

    public void setInstructorCode(String instructorCode) {
        this.instructorCode = instructorCode;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public InstructorType getInstructorType() {
        return instructorType;
    }

    public void setInstructorType(InstructorType instructorType) {
        this.instructorType = instructorType;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public RecordStatus getStatus() {
        return status;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
    }
}
