package com.example.tms.controller;

import com.example.tms.dto.DepartmentDto;
import com.example.tms.entity.enums.DepartmentType;
import com.example.tms.entity.enums.RecordStatus;
import com.example.tms.exception.BusinessException;
import com.example.tms.service.DepartmentService;
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
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Departments");
        model.addAttribute("keyword", keyword);
        model.addAttribute("departments", departmentService.search(keyword));
        return "departments/list";
    }

    @GetMapping("/departments/new")
    public String createForm(Model model) {
        model.addAttribute("pageTitle", "Create Department");
        model.addAttribute("department", new DepartmentDto());
        addFormOptions(model);
        return "departments/form";
    }

    @PostMapping("/departments")
    public String create(
            @Valid @ModelAttribute("department") DepartmentDto department,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Create Department");
            addFormOptions(model);
            return "departments/form";
        }
        try {
            departmentService.create(department);
        } catch (BusinessException ex) {
            bindingResult.reject("department.create.failed", ex.getMessage());
            model.addAttribute("pageTitle", "Create Department");
            addFormOptions(model);
            return "departments/form";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Đã tạo phòng ban thành công.");
        return "redirect:/departments";
    }

    private void addFormOptions(Model model) {
        model.addAttribute("departmentTypes", DepartmentType.values());
        model.addAttribute("statuses", RecordStatus.values());
        model.addAttribute("parentDepartments", departmentService.findAll());
    }
}
