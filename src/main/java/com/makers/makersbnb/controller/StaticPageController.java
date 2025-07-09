package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;

@RestController
public class StaticPageController {

    @Autowired
    SpaceRepository spaceRepository;

    @GetMapping("/")
    public ModelAndView landingPage() {
        ModelAndView modelAndView = new ModelAndView("/index");
        long nSpaces = spaceRepository.count();
        modelAndView.addObject("nSpaces", nSpaces);
        Integer bookings = 123;
        modelAndView.addObject("bookings", bookings);
        String[] reviews = new String[] {"Awesome", "Nice", "Perfect"};
        modelAndView.addObject("reviews", reviews);
        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView contactPage() {
        ModelAndView modelAndView = new ModelAndView("/contact");
          HashMap<String, String> contact = new HashMap<String, String>() {{
          put("Email", "contact@makersbnb.co.uk");
          put("Call", "02038178870");
          put("Visit", "Zetland House, 5-25 Scrutton Steet, London, EC2A 4HJ");}};
          modelAndView.addObject("contact", contact);
          return modelAndView;
    }

    @GetMapping("/spaces")
    public ModelAndView spacesPage() {
        ModelAndView modelAndView = new ModelAndView("/spaces");
        Iterable<Space> spaces = spaceRepository.findAll();
        modelAndView.addObject("spaces", spaces);
        return modelAndView;
    }

    @GetMapping("/spaces/new")
    public ModelAndView newSpaceForm() {
        // this is the space referred to in th:object (look back at the form code)
        Space space = new Space();
        ModelAndView newSpaceForm = new ModelAndView("/spaces/new");
        newSpaceForm.addObject("space", space);
        return newSpaceForm;
    }

    @PostMapping("/spaces")
// Spring Boot uses the form data to create an instance of space
// which is then passed in as an arg here
    public RedirectView create(Space space) {
        spaceRepository.save(space);
        // assumes you already created a method to handle `GET "/spaces"`
        return new RedirectView("/spaces");
    }


}
