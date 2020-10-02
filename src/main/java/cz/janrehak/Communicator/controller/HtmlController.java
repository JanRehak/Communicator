package cz.janrehak.Communicator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HtmlController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get() {
        return "index.html";
    }

    @GetMapping("/index")
    public String index() {
        return "index.html";
    }

    @GetMapping("/users")
    public String users() {
        return "users.html";
    }

    @GetMapping("/messages")
    public String messages() {
        return "messages.html";
    }



}