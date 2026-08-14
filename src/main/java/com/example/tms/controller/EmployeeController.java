package com.example.tms.controller;

import com.example.tms.dto.EmployeeDto;
import com.example.tms.entity.enums.EmployeeLevel;
import com.example.tms.entity.enums.Gender;
import com.example.tms.entity.enums.RecordStatus;
import com.example.tms.exception.BusinessException;
import com.example.tms.service.DepartmentService;
import com.example.tms.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@PreAuthorize("hasAnyRole('ADMIN','TRAINING_ADMIN','MANAGER')")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/employees")
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Employees");
        model.addAttribute("keyword", keyword);
        model.addAttribute("employees", employeeService.search(keyword));
        return "employees/list";
    }

    @GetMapping("/employees/new")
    public String createForm(Model model) {
        model.addAttribute("pageTitle", "Create Employee");
        model.addAttribute("employee", new EmployeeDto());
        addFormOptions(model);
        return "employees/form";
    }

    @PostMapping("/employees")
    public String create(
            @Valid @ModelAttribute("employee") EmployeeDto employee,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Create Employee");
            addFormOptions(model);
            return "employees/form";
        }
        try {
            employeeService.create(employee);
        } catch (BusinessException ex) {
            bindingResult.reject("employee.create.failed", ex.getMessage());
            model.addAttribute("pageTitle", "Create Employee");
            addFormOptions(model);
            return "employees/form";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Đã tạo nhân viên thành công.");
        return "redirect:/employees";
    }

    private void addFormOptions(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("employeeLevels", EmployeeLevel.values());
        model.addAttribute("statuses", RecordStatus.values());
    }
}
