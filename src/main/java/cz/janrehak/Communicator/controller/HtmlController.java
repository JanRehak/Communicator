package cz.janrehak.Communicator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HtmlController {

//    @RequestMapping("/")
//    public String get() {
//        return "index.html";
//    }



    @GetMapping("/users")
    public String users() {
        return "index.html";
    }



//    @GetMapping("/messages")
//    public String messages() {
//        return "messages.html";
//    }



}