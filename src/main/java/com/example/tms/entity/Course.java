package com.example.tms.entity;

import java.math.BigDecimal;

import com.example.tms.entity.enums.CourseCategory;
import com.example.tms.entity.enums.RecordStatus;
import com.example.tms.entity.enums.TrainingMethod;
import com.example.tms.entity.enums.TrainingType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_code", nullable = false, unique = true, length = 50)
    private String courseCode;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 50)
    private CourseCategory category;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "training_type", nullable = false, length = 30)
    private TrainingType trainingType;

    @Enumerated(EnumType.STRING)
    @Column(name = "training_method", nullable = false, length = 30)
    private TrainingMethod trainingMethod;

    @Column(name = "default_duration_hours", nullable = false, precision = 8, scale = 2)
    private BigDecimal defaultDurationHours;

    @Column(name = "target_audience")
    private String targetAudience;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private RecordStatus status;

    public Long getId() {
        return id;
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
