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
        name = new String (name.getBytes ("ISO-8859-1"), "UTF-8");
        String email = (String)requestParam.get("email");
        email = new String (name.getBytes ("ISO-8859-1"), "UTF-8");
        String message = (String)requestParam.get("message");
        message = new String (name.getBytes ("ISO-8859-1"), "UTF-8");

        Message msg = new Message(email, name, message);
        System.out.println(msg);
        messageService.save(msg);

        return new ModelAndView("redirect: /#contact");
    }
}
