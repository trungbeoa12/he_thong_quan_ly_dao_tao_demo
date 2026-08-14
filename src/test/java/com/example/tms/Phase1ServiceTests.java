package com.example.tms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import com.example.tms.dto.DepartmentDto;
import com.example.tms.dto.EmployeeDto;
import com.example.tms.dto.UserCreateDto;
import com.example.tms.entity.enums.AppRole;
import com.example.tms.entity.enums.DepartmentType;
import com.example.tms.entity.enums.EmployeeLevel;
import com.example.tms.entity.enums.RecordStatus;
import com.example.tms.service.DepartmentService;
import com.example.tms.service.EmployeeService;
import com.example.tms.service.UserManagementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Phase1ServiceTests {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createsDepartment() {
        DepartmentDto dto = new DepartmentDto();
        dto.setDepartmentCode("QA-" + suffix());
        dto.setDepartmentName("Phòng Kiểm thử Phase 1");
        dto.setDepartmentType(DepartmentType.DEPARTMENT);
        dto.setStatus(RecordStatus.ACTIVE);

        DepartmentDto created = departmentService.create(dto);

        assertThat(created.getId()).isNotNull();
        assertThat(created.getDepartmentCode()).startsWith("QA-");
    }

    @Test
    void createsEmployeeWithDepartment() {
        Long departmentId = departmentService.findAll().get(0).getId();
        EmployeeDto dto = new EmployeeDto();
        dto.setEmployeeCode("T" + suffix());
        dto.setFullName("Nhân viên Test Phase 1");
        dto.setEmail("phase1-" + suffix().toLowerCase() + "@example.com");
        dto.setDepartmentId(departmentId);
        dto.setEmployeeLevel(EmployeeLevel.STAFF);
        dto.setStatus(RecordStatus.ACTIVE);

        EmployeeDto created = employeeService.create(dto);

        assertThat(created.getId()).isNotNull();
        assertThat(created.getDepartmentName()).isNotBlank();
    }

    @Test
    void createsUserWithRole() {
        UserCreateDto dto = new UserCreateDto();
        dto.setUsername("phase1-" + suffix().toLowerCase());
        dto.setPassword("Phase1@123");
        dto.setRole(AppRole.ROLE_EMPLOYEE);
        dto.setEnabled(true);

        var created = userManagementService.create(dto);

        assertThat(created.username()).startsWith("phase1-");
        assertThat(created.roles()).contains("ROLE_EMPLOYEE");
    }

    @Test
    void returnsEmployeesAsJsonWithBasicAuth() throws Exception {
        mockMvc.perform(get("/api/employees").with(httpBasic("admin", "Admin@123")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].employeeCode").isNotEmpty());
    }

    private String suffix() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
