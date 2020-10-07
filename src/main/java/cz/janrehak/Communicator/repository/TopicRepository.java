package cz.janrehak.Communicator.repository;

import cz.janrehak.Communicator.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {


    Optional<Topic> findByName(String name);
    Optional<Topic> findById(Long id);
}
