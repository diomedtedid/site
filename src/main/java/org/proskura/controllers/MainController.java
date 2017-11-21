package org.proskura.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 20.11.2017.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /static/index.html");
        return modelAndView;
    }
}
