package cz.janrehak.Communicator.service.impl;


import cz.janrehak.Communicator.exception.NotFoundException;
import cz.janrehak.Communicator.model.Message;
import cz.janrehak.Communicator.repository.MessageRepository;
import cz.janrehak.Communicator.repository.UserRepository;
import cz.janrehak.Communicator.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserRepository userRepository;

    //theoretially the principal can be obsolid by getting the logged user from user
    @Override
    public Message saveMessage(Message message, User user, Principal principal) {

        message.setCreatedTime(LocalDateTime.now());
        message.setAuthor(
                userRepository.findByName(principal.getName())
                        .orElseThrow(() -> new NotFoundException("Author with supplied name not found"))
        );


        //TODO if invalid input,then

        return messageRepository.save(message);
    }


    @Override
    public void deleteMessage(Long id, Principal principal) {

        //if principal is admin or author -> delete message
        if (isAdminOrAuthor(id, principal)) {
            //delete message
            messageRepository.delete(messageRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found")));
        }
    }

    @Override
    public Iterable<Message> listAll() {
        return messageRepository.findAll();
    }

    @Override
    public boolean isAdminOrAuthor(Long id, Principal principal) {

        //if principal is author of message
        //TODO potencionalne nebezpecny nullpoint?
        if (userRepository.findByName(principal.getName()).equals(messageRepository.findById(id).get().getAuthor())) {
            return true;
        }

        //if principal is ADMIN
        if (userRepository.findByName(principal.getName()).get().getRoles().contains("ADMIN")) {
            return true;
        }
        else return false;
    }
}
