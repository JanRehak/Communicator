package cz.janrehak.Communicator.service.impl;


import cz.janrehak.Communicator.exception.BadRequestException;
import cz.janrehak.Communicator.exception.NotFoundException;
import cz.janrehak.Communicator.model.Message;
import cz.janrehak.Communicator.model.Topic;
import cz.janrehak.Communicator.repository.MessageRepository;
import cz.janrehak.Communicator.repository.TopicRepository;
import cz.janrehak.Communicator.repository.UserRepository;
import cz.janrehak.Communicator.service.MessageService;
import cz.janrehak.Communicator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    TopicService topicService;

    //theoretially the principal can be obsolid by getting the logged user from user
    @Override
    public Message saveMessage(Message message, User user, Principal principal) {

        message.setCreatedTime(LocalDateTime.now());

        message.setAuthor(
                userRepository.findByName(principal.getName())
                        .orElseThrow(() -> new NotFoundException("Author with supplied name not found"))
        );

        //if no topic selected, select default

//        inputed topic is a topic of message / find by name
//        message.setTopic(topicRepository.findByName(message.getTopic().getName())
//                .orElseThrow(() -> new NotFoundException("Topic with supplied name not found")));

//        //find by ID
        Long topicId  = message.getTopic().getId();
        System.out.println(topicId);
        message.setTopic(topicRepository.findById(topicId).orElseThrow());

        if (message.getTopic() == null || message.getTopic().getName().equals("")) {
            message.setTopic(topicRepository.findById(1L)
                    .orElseThrow(() -> new NotFoundException("Author with supplied name not found")));
        }
//
//        message.setTopic(topicRepository.findById(message.getId()).orElseThrow(()
//                -> new NotFoundException("Topic by given id not found.")));



        return messageRepository.save(message);
    }


    @Override
    public void deleteMessage(Long id, Principal principal) {

        //if principal is admin or author -> delete message
        if (isAdminOrAuthor(id, principal)) {

            //delete message
            messageRepository.delete(messageRepository.findById(id).orElseThrow(() -> new NotFoundException("Message by given id not found")));
        }

        if (!isAdminOrAuthor(id, principal)) {
            throw new BadRequestException("You must be admin or author of the message to delete the message");
        }
    }

    @Override
    public Iterable<Message> listAll() {
        return messageRepository.findAll();
    }

    @Override
    //TODO move into userService?
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
