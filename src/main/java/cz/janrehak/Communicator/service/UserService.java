package cz.janrehak.Communicator.service;

import cz.janrehak.Communicator.model.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User name);

    Optional<User> getUser(String name);

    List<User> getAllUsers();

    Boolean isUserPresent(String userName);

}
