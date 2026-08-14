package com.example.tms.controller;

import com.example.tms.dto.CourseDto;
import com.example.tms.entity.enums.CourseCategory;
import com.example.tms.entity.enums.RecordStatus;
import com.example.tms.entity.enums.TrainingMethod;
import com.example.tms.entity.enums.TrainingType;
import com.example.tms.exception.BusinessException;
import com.example.tms.service.CourseService;
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
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Courses");
        model.addAttribute("keyword", keyword);
        model.addAttribute("courses", courseService.search(keyword));
        return "courses/list";
    }

    @GetMapping("/courses/new")
    public String createForm(Model model) {
        model.addAttribute("pageTitle", "Create Course");
        model.addAttribute("course", new CourseDto());
        addFormOptions(model);
        return "courses/form";
    }

    @PostMapping("/courses")
    public String create(
            @Valid @ModelAttribute("course") CourseDto course,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Create Course");
            addFormOptions(model);
            return "courses/form";
        }
        try {
            courseService.create(course);
        } catch (BusinessException ex) {
            bindingResult.reject("course.create.failed", ex.getMessage());
            model.addAttribute("pageTitle", "Create Course");
            addFormOptions(model);
            return "courses/form";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Đã tạo khóa học thành công.");
        return "redirect:/courses";
    }

    private void addFormOptions(Model model) {
        model.addAttribute("categories", CourseCategory.values());
        model.addAttribute("trainingTypes", TrainingType.values());
        model.addAttribute("trainingMethods", TrainingMethod.values());
        model.addAttribute("statuses", RecordStatus.values());
    }
}
