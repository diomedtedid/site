package org.proskura.controllers;

import org.proskura.controllers.utils.ControllerUtil;
import org.proskura.model.Message;
import org.proskura.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.Enumeration;

import static java.awt.Color.white;
import static java.awt.SystemColor.text;

/**
 * Created by User on 20.11.2017.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public ModelAndView index (HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        String remoteAddr = ControllerUtil.getRemoutIp(request);
        messageService.save(new Message("", "visitor", request.getHeader("user-agent"), remoteAddr));

        modelAndView.setViewName("redirect: /static/index.html");
        return modelAndView;
    }
}
