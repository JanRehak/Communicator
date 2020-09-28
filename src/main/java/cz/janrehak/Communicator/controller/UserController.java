package cz.janrehak.Communicator.controller;


import cz.janrehak.Communicator.model.User;
import cz.janrehak.Communicator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userName}")
    public Optional <User> getUser(@PathVariable("userName") String name) {
        return userService.getUser(name);
    }

    @GetMapping(value = "/loggedUser")
    public Optional <User> getLoggedUser(@AuthenticationPrincipal org.springframework.security.core.userdetails.User loggedUser) {
        return userService.getUser(loggedUser.getUsername());
    }

}
