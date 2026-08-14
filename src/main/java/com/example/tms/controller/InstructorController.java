package com.example.tms.controller;

import com.example.tms.dto.InstructorDto;
import com.example.tms.entity.enums.InstructorType;
import com.example.tms.entity.enums.RecordStatus;
import com.example.tms.exception.BusinessException;
import com.example.tms.service.InstructorService;
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
@PreAuthorize("hasAnyRole('ADMIN','TRAINING_ADMIN')")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Instructors");
        model.addAttribute("keyword", keyword);
        model.addAttribute("instructors", instructorService.search(keyword));
        return "instructors/list";
    }

    @GetMapping("/instructors/new")
    public String createForm(Model model) {
        model.addAttribute("pageTitle", "Create Instructor");
        model.addAttribute("instructor", new InstructorDto());
        addFormOptions(model);
        return "instructors/form";
    }

    @PostMapping("/instructors")
    public String create(
            @Valid @ModelAttribute("instructor") InstructorDto instructor,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Create Instructor");
            addFormOptions(model);
            return "instructors/form";
        }
        try {
            instructorService.create(instructor);
        } catch (BusinessException ex) {
            bindingResult.reject("instructor.create.failed", ex.getMessage());
            model.addAttribute("pageTitle", "Create Instructor");
            addFormOptions(model);
            return "instructors/form";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Đã tạo giảng viên thành công.");
        return "redirect:/instructors";
    }

    private void addFormOptions(Model model) {
        model.addAttribute("instructorTypes", InstructorType.values());
        model.addAttribute("statuses", RecordStatus.values());
    }
}
