package com.example.tms.controller;

import com.example.tms.dto.UserCreateDto;
import com.example.tms.entity.enums.AppRole;
import com.example.tms.exception.BusinessException;
import com.example.tms.service.UserManagementService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class UserManagementController {

    private final UserManagementService userManagementService;

    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @GetMapping("/admin/users")
    public String list(Model model) {
        model.addAttribute("pageTitle", "Users");
        model.addAttribute("users", userManagementService.findAll());
        return "users/list";
    }

    @GetMapping("/admin/users/new")
    public String createForm(Model model) {
        model.addAttribute("pageTitle", "Create User");
        model.addAttribute("user", new UserCreateDto());
        model.addAttribute("roles", AppRole.values());
        return "users/form";
    }

    @PostMapping("/admin/users")
    public String create(
            @Valid @ModelAttribute("user") UserCreateDto user,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Create User");
            model.addAttribute("roles", AppRole.values());
            return "users/form";
        }
        try {
            userManagementService.create(user);
        } catch (BusinessException ex) {
            bindingResult.reject("user.create.failed", ex.getMessage());
            model.addAttribute("pageTitle", "Create User");
            model.addAttribute("roles", AppRole.values());
            return "users/form";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Đã tạo user thành công.");
        return "redirect:/admin/users";
    }
}
