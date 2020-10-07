package cz.janrehak.Communicator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String get() {
        return "index.html";
    }

    @GetMapping("/users")
    public String users() {
        return "users.html";
    }

    @GetMapping("/topics")
    public String topics() {
        return "topics.html";
    }

    @GetMapping("/messages")
    public String messages() {
        return "messages.html";
    }



}