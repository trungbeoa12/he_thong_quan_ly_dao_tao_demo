package com.example.tms;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.UUID;

import com.example.tms.dto.CourseDto;
import com.example.tms.dto.InstructorDto;
import com.example.tms.entity.enums.CourseCategory;
import com.example.tms.entity.enums.InstructorType;
import com.example.tms.entity.enums.RecordStatus;
import com.example.tms.entity.enums.TrainingMethod;
import com.example.tms.entity.enums.TrainingType;
import com.example.tms.service.CourseService;
import com.example.tms.service.InstructorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Phase2ServiceTests {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createsInstructor() {
        InstructorDto dto = new InstructorDto();
        dto.setInstructorCode("INS-T-" + suffix());
        dto.setInstructorName("Giảng viên Test Phase 2");
        dto.setInstructorType(InstructorType.INTERNAL);
        dto.setOrganization("Khối Đào tạo");
        dto.setExpertise("Spring Boot");
        dto.setEmail("phase2-ins-" + suffix().toLowerCase() + "@example.com");
        dto.setPhone("0900000000");
        dto.setHourlyRate(BigDecimal.ZERO);
        dto.setStatus(RecordStatus.ACTIVE);

        InstructorDto created = instructorService.create(dto);

        assertThat(created.getId()).isNotNull();
        assertThat(created.getInstructorCode()).startsWith("INS-T-");
        assertThat(created.getEmail()).startsWith("phase2-ins-");
    }

    @Test
    void createsCourse() {
        CourseDto dto = new CourseDto();
        dto.setCourseCode("C-T-" + suffix());
        dto.setCourseName("Khóa học Test Phase 2");
        dto.setCategory(CourseCategory.IT);
        dto.setDescription("Dữ liệu kiểm thử danh mục khóa học.");
        dto.setTrainingType(TrainingType.INTERNAL);
        dto.setTrainingMethod(TrainingMethod.BLENDED);
        dto.setDefaultDurationHours(BigDecimal.valueOf(12));
        dto.setTargetAudience("Nhân viên CNTT");
        dto.setStatus(RecordStatus.ACTIVE);

        CourseDto created = courseService.create(dto);

        assertThat(created.getId()).isNotNull();
        assertThat(created.getCourseCode()).startsWith("C-T-");
        assertThat(created.getDefaultDurationHours()).isEqualByComparingTo("12");
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void rendersPhase2Pages() throws Exception {
        mockMvc.perform(get("/instructors")).andExpect(status().isOk());
        mockMvc.perform(get("/instructors/new")).andExpect(status().isOk());
        mockMvc.perform(get("/courses")).andExpect(status().isOk());
        mockMvc.perform(get("/courses/new")).andExpect(status().isOk());
    }

    private String suffix() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
