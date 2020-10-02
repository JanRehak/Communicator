package cz.janrehak.Communicator.service;

import cz.janrehak.Communicator.model.Message;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.security.Principal;
import java.util.Optional;

public interface MessageService {

//    Message saveMessage(Message message, User user);
    Message saveMessage(Message message, Principal principal);
    void deleteMessage(Message message, Principal principal);

    Iterable <Message> listAll();
}
