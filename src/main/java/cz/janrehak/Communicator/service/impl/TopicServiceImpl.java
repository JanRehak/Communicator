package cz.janrehak.Communicator.service.impl;

import cz.janrehak.Communicator.model.Message;
import cz.janrehak.Communicator.model.Topic;
import cz.janrehak.Communicator.repository.TopicRepository;
import cz.janrehak.Communicator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import java.security.Principal;

public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;


    @Override
    public Topic saveTopic(Topic topic, Message message) {


        return topicRepository.save(topic);
    }
}
