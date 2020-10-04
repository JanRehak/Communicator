package cz.janrehak.Communicator.repository;


import cz.janrehak.Communicator.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    @Override
    Optional<Message> findById(Long aLong);
}
