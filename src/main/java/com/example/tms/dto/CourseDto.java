package com.example.tms.dto;

import java.math.BigDecimal;

import com.example.tms.entity.enums.CourseCategory;
import com.example.tms.entity.enums.RecordStatus;
import com.example.tms.entity.enums.TrainingMethod;
import com.example.tms.entity.enums.TrainingType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CourseDto {

    private Long id;

    @NotBlank(message = "Mã course là bắt buộc")
    @Size(max = 50, message = "Mã course không được vượt quá 50 ký tự")
    private String courseCode;

    @NotBlank(message = "Tên course là bắt buộc")
    @Size(max = 255, message = "Tên course không được vượt quá 255 ký tự")
    private String courseName;

    @NotNull(message = "Category là bắt buộc")
    private CourseCategory category = CourseCategory.IT;

    private String description;

    @NotNull(message = "Training type là bắt buộc")
    private TrainingType trainingType = TrainingType.INTERNAL;

    @NotNull(message = "Training method là bắt buộc")
    private TrainingMethod trainingMethod = TrainingMethod.OFFLINE;

    @NotNull(message = "Default duration hours là bắt buộc")
    @DecimalMin(value = "0.5", message = "Default duration hours phải lớn hơn 0")
    private BigDecimal defaultDurationHours = BigDecimal.valueOf(8);

    private String targetAudience;

    @NotNull(message = "Trạng thái là bắt buộc")
    private RecordStatus status = RecordStatus.ACTIVE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public CourseCategory getCategory() {
        return category;
    }

    public void setCategory(CourseCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    public TrainingMethod getTrainingMethod() {
        return trainingMethod;
    }

    public void setTrainingMethod(TrainingMethod trainingMethod) {
        this.trainingMethod = trainingMethod;
    }

    public BigDecimal getDefaultDurationHours() {
        return defaultDurationHours;
    }

    public void setDefaultDurationHours(BigDecimal defaultDurationHours) {
        this.defaultDurationHours = defaultDurationHours;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public RecordStatus getStatus() {
        return status;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
    }
}
