package cz.janrehak.Communicator.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("/api/test")
public class TestController {

@GetMapping()
public String getTestString () {
    return "Test";
}

}
