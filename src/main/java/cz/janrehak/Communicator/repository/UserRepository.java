package cz.janrehak.Communicator.repository;

import cz.janrehak.Communicator.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);
    List<User> findAll();
    Optional<User> findByName(String name);


}
