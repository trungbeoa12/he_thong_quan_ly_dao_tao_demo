package com.example.tms.dto;

import java.math.BigDecimal;

import com.example.tms.entity.enums.InstructorType;
import com.example.tms.entity.enums.RecordStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InstructorDto {

    private Long id;

    @NotBlank(message = "Mã giảng viên là bắt buộc")
    @Size(max = 50, message = "Mã giảng viên không được vượt quá 50 ký tự")
    private String instructorCode;

    @NotBlank(message = "Tên giảng viên là bắt buộc")
    @Size(max = 255, message = "Tên giảng viên không được vượt quá 255 ký tự")
    private String instructorName;

    @NotNull(message = "Loại giảng viên là bắt buộc")
    private InstructorType instructorType = InstructorType.INTERNAL;

    private String organization;
    private String expertise;

    @NotBlank(message = "Email là bắt buộc")
    @Email(message = "Email không hợp lệ")
    private String email;

    private String phone;

    @NotNull(message = "Hourly rate là bắt buộc")
    @DecimalMin(value = "0.0", message = "Hourly rate phải lớn hơn hoặc bằng 0")
    private BigDecimal hourlyRate = BigDecimal.ZERO;

    @NotNull(message = "Trạng thái là bắt buộc")
    private RecordStatus status = RecordStatus.ACTIVE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
