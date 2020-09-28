package cz.janrehak.Communicator.controller;


import cz.janrehak.Communicator.model.Message;
import cz.janrehak.Communicator.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired MessageService messageService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping
    public Message postMessage(@RequestBody Message message, @AuthenticationPrincipal User user) {
       return messageService.saveMessage(message, user);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping
    public Iterable<Message> get() {
        return messageService.listAll();
    }

}
