package com.makers.makersbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TermsAndConditionController {
    @GetMapping("/termsandconditions")
    public ModelAndView getTermsAndConditions() {
        ModelAndView modelAndView = new ModelAndView("/termsandconditionspage");
        String[] message = new String[] {"Coming soon! In the meantime, please behave yourselves."};
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
