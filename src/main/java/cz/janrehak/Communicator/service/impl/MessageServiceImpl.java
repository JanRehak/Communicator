package cz.janrehak.Communicator.service.impl;

import cz.janrehak.Communicator.model.Message;
import cz.janrehak.Communicator.repository.MessageRepository;
import cz.janrehak.Communicator.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageServiceImpl implements MessageService {

@Autowired MessageRepository messageRepository;


    @Override
    public Message saveMessage(Message message, User user) {

        message.setCreatedTime(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @Override
    public Iterable<Message> listAll() {
        return messageRepository.findAll();
    }
}
