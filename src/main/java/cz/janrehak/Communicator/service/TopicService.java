package cz.janrehak.Communicator.service;

import cz.janrehak.Communicator.model.Topic;

import java.util.List;


public interface TopicService {

    Topic saveTopic(Topic topic);

    Iterable<Topic> loadTopics();

}
