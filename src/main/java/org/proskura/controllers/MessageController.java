package org.proskura.controllers;

import org.proskura.configurations.WebConfiguration;
import org.proskura.model.Message;
import org.proskura.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MessageService messageService;


    @PostMapping
    public ModelAndView getMessage(@RequestParam Map requestParam) throws Exception  {
        String name = (String)requestParam.get("name");
        String email = (String)requestParam.get("email");
        String message = (String)requestParam.get("message");


        Message msg = new Message(email, name, message);
        messageService.save(msg);

        return new ModelAndView("redirect: /#contact");
    }
}
