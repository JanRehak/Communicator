package cz.janrehak.Communicator.service;

import cz.janrehak.Communicator.model.Message;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public interface MessageService {

    Message saveMessage(Message message, User user);

    Iterable <Message> listAll();
}
