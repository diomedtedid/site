package org.proskura.controllers;

import org.proskura.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by User on 25.11.2017.
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    @PostMapping
    public ModelAndView getMessage(@RequestParam Map requestParam) {
        String name = (String)requestParam.get("name");
        String email = (String)requestParam.get("email");
        String message = (String)requestParam.get("message");

        Message msg = new Message(email, name, message);

        return new ModelAndView("redirect: /#contact");
    }
}
