package cz.janrehak.Communicator.repository;

import cz.janrehak.Communicator.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {


}
