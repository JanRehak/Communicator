package cz.janrehak.Communicator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HtmlController {

    @RequestMapping( value = "/", method = RequestMethod.GET)
    public String get() {
        return "index.html";
    }

    @GetMapping("/users")
    public String users() {
        return "users.html";
    }

    @GetMapping("/articles")
    public String articles() {
        return "articles.html";
    }

}