package com.grzegorzmarkiewicz.document_manager.controller;

import com.grzegorzmarkiewicz.document_manager.model.User;
import com.grzegorzmarkiewicz.document_manager.service.SecuritySerice;
import com.grzegorzmarkiewicz.document_manager.service.UserService;
import com.grzegorzmarkiewicz.document_manager.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecuritySerice securitySerice;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()){
            return "registration";
        }

        userService.saveUser(userForm);
        securitySerice.autologin(userForm.getUsername(), userForm.getPassword());

        return "redirect:/welcome";
    }
}
