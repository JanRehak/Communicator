package cz.janrehak.Communicator.controller;

import cz.janrehak.Communicator.model.Topic;
import cz.janrehak.Communicator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    TopicService topicService;

@PostMapping
    public Topic postTopic(@RequestBody Topic topic) {
        return topicService.saveTopic(topic);
}

@GetMapping
    public Iterable<Topic> loadTopics() {
        return topicService.loadTopics();
}


}
