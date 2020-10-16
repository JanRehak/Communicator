package cz.janrehak.Communicator.service.impl;

import cz.janrehak.Communicator.exception.DatabaseException;
import cz.janrehak.Communicator.exception.NotFoundException;
import cz.janrehak.Communicator.model.Topic;
import cz.janrehak.Communicator.repository.TopicRepository;
import cz.janrehak.Communicator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Override
    public Topic saveTopic(Topic topic) {

        //making topic unique
        if (topicRepository.findByName(topic.getName()).isPresent()) {
            return topicRepository.findByName(topic.getName()).orElseThrow();
        }

        //topic cant be without name
        if (topic.getName().equals("")) {
            topic.setName("Default Topic");
        }

        return topicRepository.save(topic);
    }

    public  Iterable<Topic> loadTopics() {
        return topicRepository.findAll();
    }
}
