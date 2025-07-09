package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.model.Staff;
import com.makers.makersbnb.repository.SpaceRepository;
import com.makers.makersbnb.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


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
}