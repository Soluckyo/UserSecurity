package com.example.usersecurity.controllers;

import com.example.usersecurity.entity.UserEntity;
import com.example.usersecurity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegistrationController {
    UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userEntity", new UserEntity());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute UserEntity userEntity, Model model) {
        userService.save(userEntity);
        return "redirect:/login";
    }
}
