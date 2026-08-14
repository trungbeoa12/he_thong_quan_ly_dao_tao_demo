package com.example.tms.dto;

import com.example.tms.entity.enums.DepartmentType;
import com.example.tms.entity.enums.RecordStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DepartmentDto {

    private Long id;

    @NotBlank(message = "Mã phòng ban là bắt buộc")
    @Size(max = 50, message = "Mã phòng ban không được vượt quá 50 ký tự")
    private String departmentCode;

    @NotBlank(message = "Tên phòng ban là bắt buộc")
    @Size(max = 255, message = "Tên phòng ban không được vượt quá 255 ký tự")
    private String departmentName;

    private Long parentDepartmentId;
    private String parentDepartmentName;

    @NotNull(message = "Loại phòng ban là bắt buộc")
    private DepartmentType departmentType = DepartmentType.DEPARTMENT;

    @NotNull(message = "Trạng thái là bắt buộc")
    private RecordStatus status = RecordStatus.ACTIVE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getParentDepartmentId() {
        return parentDepartmentId;
    }

    public void setParentDepartmentId(Long parentDepartmentId) {
        this.parentDepartmentId = parentDepartmentId;
    }

    public String getParentDepartmentName() {
        return parentDepartmentName;
    }

    public void setParentDepartmentName(String parentDepartmentName) {
        this.parentDepartmentName = parentDepartmentName;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public RecordStatus getStatus() {
        return status;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
    }
}
