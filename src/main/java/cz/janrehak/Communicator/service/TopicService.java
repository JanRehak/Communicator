package cz.janrehak.Communicator.service;

import cz.janrehak.Communicator.model.Message;
import cz.janrehak.Communicator.model.Topic;
import org.springframework.security.core.userdetails.User;

import java.security.Principal;

public interface TopicService {

    Topic saveTopic(Topic topic, Message message);

}
