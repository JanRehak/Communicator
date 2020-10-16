package cz.janrehak.Communicator.controller;


import cz.janrehak.Communicator.model.User;
import cz.janrehak.Communicator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    @Secured({"ROLE_ADMIN"})
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userName}")
    public Optional<User> getUser(@PathVariable("userName") String name) {
        return userService.getUser(name);
    }

    @RequestMapping(value = "/getLoggedUser", method = RequestMethod.GET)
    public Optional<User> getLoggedUser(Principal principal) {
        return userService.getUser(principal.getName());
    }

}
