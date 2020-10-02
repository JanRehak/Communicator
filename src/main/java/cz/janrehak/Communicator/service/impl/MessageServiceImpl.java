package cz.janrehak.Communicator.service.impl;

import cz.janrehak.Communicator.exception.BadRequestException;
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

@Autowired MessageRepository messageRepository;
@Autowired UserRepository userRepository;


//    @Override
//    public Message saveMessage(Message message, User user) {
//        return null;
//    }

    @Override
    public Message saveMessage(Message message, User user, Principal principal) {


        //set time of creation
        message.setCreatedTime(LocalDateTime.now());

        
        message.setAuthor(
                userRepository.findByName(principal.getName())
                        .orElseThrow(() -> new NotFoundException("Author with supplied name not found"))
        );

        return messageRepository.save(message);
    }

    @Override
    public Iterable<Message> listAll() {
        return messageRepository.findAll();
    }
}
