package org.proskura.controllers;

import org.proskura.configurations.WebConfiguration;
import org.proskura.controllers.utils.ControllerUtil;
import org.proskura.model.Message;
import org.proskura.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView getMessage(@RequestParam Map requestParam, HttpServletRequest request) throws Exception  {
        String name = (String)requestParam.get("name");
        String email = (String)requestParam.get("email");
        String message = (String)requestParam.get("message");
        String ip = ControllerUtil.getRemoutIp(request);


        Message msg = new Message(email, name, message, ip);
        messageService.save(msg);

        return new ModelAndView("redirect: /#contact");
    }
}
