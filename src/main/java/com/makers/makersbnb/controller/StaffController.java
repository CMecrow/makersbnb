package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Staff;
import com.makers.makersbnb.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class StaffController {

    @Autowired
    StaffRepository staffRepository;

    @GetMapping("/staff")
    public ModelAndView staffPage() {
        ModelAndView modelAndView = new ModelAndView("/staff");
        Iterable<Staff> staff = staffRepository.findAll();
        modelAndView.addObject("staff", staff);
        return modelAndView;
    }

    @GetMapping("/staff/new")
    public ModelAndView newStaffForm() {
        Staff staff = new Staff();
        ModelAndView newStaffForm = new ModelAndView("/staff/new");
        newStaffForm.addObject("staff", staff);
        return newStaffForm;
    }

    @PostMapping("/staff")
    public RedirectView create(Staff staff) {
        staffRepository.save(staff);
        return new RedirectView("/staff");
    }
}